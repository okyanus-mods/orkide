package club.issizler.orkide.bukkit.scheduler;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.logging.Level;

public class BukkitSchedulerImpl implements BukkitScheduler {

    private static final int RECENT_TICKS = 30;
    private final AtomicInteger ids = new AtomicInteger(1);
    private final PriorityQueue<BukkitTaskImpl> pending = new PriorityQueue<>(10,
            Comparator.comparingLong(BukkitTaskImpl::getNextRun).thenComparingInt(BukkitTaskImpl::getTaskId));
    private final List<BukkitTaskImpl> temp = new ArrayList<>();
    private final ConcurrentHashMap<Integer, BukkitTaskImpl> runners = new ConcurrentHashMap<>();
    private final Executor executor = Executors.newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat("Orkide Scheduler Thread - %d").build());
    private volatile BukkitTaskImpl head = new BukkitTaskImpl();
    private final AtomicReference<BukkitTaskImpl> tail = new AtomicReference<>(head);
    private volatile BukkitTaskImpl currentTask = null;
    private volatile int currentTick = -1;
    private AsyncDebuggerImpl debugHead = new AsyncDebuggerImpl(-1, null, null) {
        @Override
        StringBuilder debugTo(StringBuilder string) {
            return string;
        }
    };
    private AsyncDebuggerImpl debugTail = debugHead;

    private static void validate(final Plugin plugin, final Object task) {
        Validate.notNull(plugin, "Plugin cannot be null");
        Validate.notNull(task, "Task cannot be null");
        Validate.isTrue(task instanceof Runnable || task instanceof Consumer || task instanceof Callable, "Task must be Runnable, Consumer, or Callable");
        if (!plugin.isEnabled()) {
            throw new IllegalPluginAccessException("Plugin attempted to register task while disabled");
        }
    }

    private <E> E deprecated() {
        throw new UnsupportedOperationException("Deprecated, so not implemented in Orkide!");
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return this.scheduleSyncRepeatingTask(plugin, task, delay, BukkitTaskImpl.NO_REPEATING);
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        return this.scheduleSyncDelayedTask(plugin, task, 0L);
    }

    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return runTaskTimer(plugin, task, delay, period).getTaskId();
    }

    @Override
    public BukkitTask runTask(Plugin plugin, Runnable task) throws IllegalArgumentException {
        return runTaskLater(plugin, task, 0L);
    }

    @Override
    public void runTask(Plugin plugin, Consumer<BukkitTask> task) throws IllegalArgumentException {
        runTaskLater(plugin, task, 0L);
    }

    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
        return runTaskLaterAsynchronously(plugin, task, 0L);
    }

    @Override
    public void runTaskAsynchronously(Plugin plugin, Consumer<BukkitTask> task) throws IllegalArgumentException {
        runTaskLaterAsynchronously(plugin, task, 0L);
    }

    @Override
    public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        return runTaskTimer(plugin, task, delay, BukkitTaskImpl.NO_REPEATING);
    }

    @Override
    public void runTaskLater(Plugin plugin, Consumer<BukkitTask> task, long delay) throws IllegalArgumentException {
        runTaskTimer(plugin, task, delay, BukkitTaskImpl.NO_REPEATING);
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        return runTaskTimerAsynchronously(plugin, task, delay, BukkitTaskImpl.NO_REPEATING);
    }

    @Override
    public void runTaskLaterAsynchronously(Plugin plugin, Consumer<BukkitTask> task, long delay) throws IllegalArgumentException {
        runTaskTimerAsynchronously(plugin, task, delay, BukkitTaskImpl.NO_REPEATING);
    }

    @Override
    public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
        return runTaskTimer(plugin, (Object) task, delay, period);
    }

    @Override
    public void runTaskTimer(Plugin plugin, Consumer<BukkitTask> task, long delay, long period) throws IllegalArgumentException {
        runTaskTimer(plugin, (Object) task, delay, period);
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
        return runTaskTimerAsynchronously(plugin, (Object) task, delay, period);
    }

    @Override
    public void runTaskTimerAsynchronously(Plugin plugin, Consumer<BukkitTask> task, long delay, long period) throws IllegalArgumentException {
        runTaskTimerAsynchronously(plugin, (Object) task, delay, BukkitTaskImpl.NO_REPEATING);
    }

    // ACTUAL LOGIC FROM NOW ON

    @Override
    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        validate(plugin, task);
        final BukkitFutureImpl<T> future = new BukkitFutureImpl<>(task, plugin, nextId());
        handle(future, 0L);
        return future;
    }

    @Override
    public void cancelTask(int taskId) {
        if (taskId <= 0) {
            return;
        }
        BukkitTaskImpl task = runners.get(taskId);
        if (task != null) {
            task.cancel0();
        }
        task = new BukkitTaskImpl(
                new Runnable() {
                    @Override
                    public void run() {
                        if (!check(BukkitSchedulerImpl.this.temp)) {
                            check(BukkitSchedulerImpl.this.pending);
                        }
                    }

                    private boolean check(final Iterable<BukkitTaskImpl> collection) {
                        final Iterator<BukkitTaskImpl> tasks = collection.iterator();
                        while (tasks.hasNext()) {
                            final BukkitTaskImpl task = tasks.next();
                            if (task.getTaskId() == taskId) {
                                task.cancel0();
                                tasks.remove();
                                if (task.isSync()) {
                                    runners.remove(taskId);
                                }
                                return true;
                            }
                        }
                        return false;
                    }
                });
        handle(task, 0L);
        for (BukkitTaskImpl taskPending = head.getNext(); taskPending != null; taskPending = taskPending.getNext()) {
            if (taskPending == task) {
                return;
            }
            if (taskPending.getTaskId() == taskId) {
                taskPending.cancel0();
            }
        }
    }

    @Override
    public void cancelTasks(Plugin plugin) {
        Validate.notNull(plugin, "Cannot cancel tasks of null plugin");
        final BukkitTaskImpl task = new BukkitTaskImpl(
                new Runnable() {
                    @Override
                    public void run() {
                        check(BukkitSchedulerImpl.this.pending);
                        check(BukkitSchedulerImpl.this.temp);
                    }

                    void check(final Iterable<BukkitTaskImpl> collection) {
                        final Iterator<BukkitTaskImpl> tasks = collection.iterator();
                        while (tasks.hasNext()) {
                            final BukkitTaskImpl task = tasks.next();
                            if (task.getOwner().equals(plugin)) {
                                task.cancel0();
                                tasks.remove();
                                if (task.isSync()) {
                                    runners.remove(task.getTaskId());
                                }
                            }
                        }
                    }
                });
        handle(task, 0L);
        for (BukkitTaskImpl taskPending = head.getNext(); taskPending != null; taskPending = taskPending.getNext()) {
            if (taskPending == task) {
                break;
            }
            if (taskPending.getTaskId() != -1 && taskPending.getOwner().equals(plugin)) {
                taskPending.cancel0();
            }
        }
        for (BukkitTaskImpl runner : runners.values()) {
            if (runner.getOwner().equals(plugin)) {
                runner.cancel0();
            }
        }
    }

    @Override
    public boolean isCurrentlyRunning(int taskId) {
        final BukkitTaskImpl task = runners.get(taskId);
        if (task == null) {
            return false;
        }
        if (task.isSync()) {
            return (task == currentTask);
        }
        final AsyncTaskImpl asyncTask = (AsyncTaskImpl) task;
        synchronized (asyncTask.getWorkers()) {
            return !asyncTask.getWorkers().isEmpty();
        }
    }

    @Override
    public boolean isQueued(int taskId) {
        if (taskId <= 0) {
            return false;
        }
        for (BukkitTaskImpl task = head.getNext(); task != null; task = task.getNext()) {
            if (task.getTaskId() == taskId) {
                return task.getPeriod() >= BukkitTaskImpl.NO_REPEATING; // The task will run
            }
        }
        BukkitTaskImpl task = runners.get(taskId);
        return task != null && task.getPeriod() >= BukkitTaskImpl.NO_REPEATING;
    }

    @Override
    public List<BukkitWorker> getActiveWorkers() {
        final ArrayList<BukkitWorker> workers = new ArrayList<>();
        for (final BukkitTaskImpl taskObj : runners.values()) {
            // Iterator will be a best-effort (may fail to grab very new values) if called from an async thread
            if (taskObj.isSync()) {
                continue;
            }
            final AsyncTaskImpl task = (AsyncTaskImpl) taskObj;
            synchronized (task.getWorkers()) {
                // This will never have an issue with stale threads; it's state-safe
                workers.addAll(task.getWorkers());
            }
        }
        return workers;
    }

    @Override
    public List<BukkitTask> getPendingTasks() {
        final ArrayList<BukkitTaskImpl> truePending = new ArrayList<>();
        for (BukkitTaskImpl task = head.getNext(); task != null; task = task.getNext()) {
            if (task.getTaskId() != -1) {
                // -1 is special code
                truePending.add(task);
            }
        }

        final ArrayList<BukkitTask> pending = new ArrayList<>();
        for (BukkitTaskImpl task : runners.values()) {
            if (task.getPeriod() >= BukkitTaskImpl.NO_REPEATING) {
                pending.add(task);
            }
        }

        for (final BukkitTaskImpl task : truePending) {
            if (task.getPeriod() >= BukkitTaskImpl.NO_REPEATING && !pending.contains(task)) {
                pending.add(task);
            }
        }
        return pending;
    }

    public BukkitTask runTaskTimer(Plugin plugin, Object runnable, long delay, long period) {
        validate(plugin, runnable);
        if (delay < 0L) {
            delay = 0;
        }
        if (period == BukkitTaskImpl.ERROR) {
            period = 1L;
        } else if (period < BukkitTaskImpl.NO_REPEATING) {
            period = BukkitTaskImpl.NO_REPEATING;
        }
        return handle(new BukkitTaskImpl(plugin, runnable, nextId(), period), delay);
    }

    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Object runnable, long delay, long period) {
        validate(plugin, runnable);
        if (delay < 0L) {
            delay = 0;
        }
        if (period == BukkitTaskImpl.ERROR) {
            period = 1L;
        } else if (period < BukkitTaskImpl.NO_REPEATING) {
            period = BukkitTaskImpl.NO_REPEATING;
        }
        return handle(new AsyncTaskImpl(runners, plugin, runnable, nextId(), period), delay);
    }

    public void mainThreadHeartbeat(final int currentTick) {
        this.currentTick = currentTick;
        final List<BukkitTaskImpl> temp = this.temp;
        parsePending();
        while (isReady(currentTick)) {
            final BukkitTaskImpl task = pending.remove();
            if (task.getPeriod() < BukkitTaskImpl.NO_REPEATING) {
                if (task.isSync()) {
                    runners.remove(task.getTaskId(), task);
                }
                parsePending();
                continue;
            }
            if (task.isSync()) {
                currentTask = task;
                try {
                    task.run();
                } catch (final Throwable throwable) {
                    task.getOwner().getLogger().log(
                            Level.WARNING,
                            String.format(
                                    "Task #%s for %s generated an exception",
                                    task.getTaskId(),
                                    task.getOwner().getDescription().getFullName()),
                            throwable);
                } finally {
                    currentTask = null;
                }
                parsePending();
            } else {
                debugTail = debugTail.setNext(new AsyncDebuggerImpl(currentTick + RECENT_TICKS, task.getOwner(), task.getTaskClass()));
                executor.execute(task);
                // We don't need to parse pending
                // (async tasks must live with race-conditions if they attempt to cancel between these few lines of code)
            }
            final long period = task.getPeriod(); // State consistency
            if (period > 0) {
                task.setNextRun(currentTick + period);
                temp.add(task);
            } else if (task.isSync()) {
                runners.remove(task.getTaskId());
            }
        }
        pending.addAll(temp);
        temp.clear();
        debugHead = debugHead.getNextHead(currentTick);
    }

    private void addTask(final BukkitTaskImpl task) {
        final AtomicReference<BukkitTaskImpl> tail = this.tail;
        BukkitTaskImpl tailTask = tail.get();
        while (!tail.compareAndSet(tailTask, task)) {
            tailTask = tail.get();
        }
        tailTask.setNext(task);
    }

    private BukkitTaskImpl handle(final BukkitTaskImpl task, final long delay) {
        task.setNextRun(currentTick + delay);
        addTask(task);
        return task;
    }

    private int nextId() {
        return ids.incrementAndGet();
    }

    private void parsePending() {
        BukkitTaskImpl head = this.head;
        BukkitTaskImpl task = head.getNext();
        BukkitTaskImpl lastTask = head;
        for (; task != null; task = (lastTask = task).getNext()) {
            if (task.getTaskId() == -1) {
                task.run();
            } else if (task.getPeriod() >= BukkitTaskImpl.NO_REPEATING) {
                pending.add(task);
                runners.put(task.getTaskId(), task);
            }
        }
        // We split this because of the way things are ordered for all of the async calls in CraftScheduler
        // (it prevents race-conditions)
        for (task = head; task != lastTask; task = head) {
            head = task.getNext();
            task.setNext(null);
        }
        this.head = lastTask;
    }

    private boolean isReady(final int currentTick) {
        return !pending.isEmpty() && pending.peek().getNextRun() <= currentTick;
    }

    // DEPRECATED METHODS FROM NOW ON
    // Will not be implemented unless someone cares enough to do so
    // Certainly not me
    // ~ Admicos

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
        return deprecated();
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return deprecated();
    }

    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return deprecated();
    }

    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return scheduleAsyncRepeatingTask(plugin, task, 0L, BukkitTaskImpl.NO_REPEATING);
    }

    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return scheduleAsyncDelayedTask(plugin, task, 0L);
    }

    @Override
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return runTaskTimerAsynchronously(plugin, (Object) task, delay, period).getTaskId();
    }

    @Override
    public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return deprecated();
    }

    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return deprecated();
    }

    @Override
    public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
        return deprecated();
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
        return deprecated();
    }

    @Override
    public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
        return deprecated();
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
        return deprecated();
    }

}
