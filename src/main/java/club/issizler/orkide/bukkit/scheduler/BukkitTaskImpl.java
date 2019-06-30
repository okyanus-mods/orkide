package club.issizler.orkide.bukkit.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Consumer;

import java.util.Objects;

public class BukkitTaskImpl implements BukkitTask, Runnable {

    public static final int ERROR = 0;
    public static final int NO_REPEATING = -1;
    public static final int CANCEL = -2;
    public static final int PROCESS_FOR_FUTURE = -3;
    public static final int DONE_FOR_FUTURE = -4;
    private final Runnable rTask;
    private final Consumer<BukkitTask> cTask;
    private final Plugin plugin;
    private final int id;
    private volatile BukkitTaskImpl next = null;
    private volatile long period;
    private long nextRun;

    BukkitTaskImpl() {
        this(null, null, BukkitTaskImpl.NO_REPEATING, BukkitTaskImpl.NO_REPEATING);
    }

    BukkitTaskImpl(final Object task) {
        this(null, task, BukkitTaskImpl.NO_REPEATING, BukkitTaskImpl.NO_REPEATING);
    }

    BukkitTaskImpl(final Plugin plugin, final Object task, final int id, final long period) {
        this.plugin = plugin;
        if (task instanceof Runnable) {
            this.rTask = (Runnable) task;
            this.cTask = null;
        } else if (task instanceof Consumer) {
            this.cTask = (Consumer<BukkitTask>) task;
            this.rTask = null;
        } else if (task == null) {
            // Head or Future task
            this.rTask = null;
            this.cTask = null;
        } else {
            throw new AssertionError("Illegal task class " + task);
        }
        this.id = id;
        this.period = period;
    }

    @Override
    public final int getTaskId() {
        return id;
    }

    @Override
    public final Plugin getOwner() {
        return plugin;
    }

    @Override
    public boolean isSync() {
        return true;
    }

    @Override
    public void run() {
        if (rTask != null) {
            rTask.run();
        } else {
            Objects.requireNonNull(cTask).accept(this);
        }
    }

    long getPeriod() {
        return period;
    }

    void setPeriod(long period) {
        this.period = period;
    }

    long getNextRun() {
        return nextRun;
    }

    void setNextRun(long nextRun) {
        this.nextRun = nextRun;
    }

    BukkitTaskImpl getNext() {
        return next;
    }

    void setNext(BukkitTaskImpl next) {
        this.next = next;
    }

    Class<?> getTaskClass() {
        return (rTask != null) ? rTask.getClass() : ((cTask != null) ? cTask.getClass() : null);
    }

    @Override
    public boolean isCancelled() {
        return (period == BukkitTaskImpl.CANCEL);
    }

    @Override
    public void cancel() {
        Bukkit.getScheduler().cancelTask(id);
    }

    /**
     * This method properly sets the status to cancelled, synchronizing when required.
     *
     * @return false if it is a craft future task that has already begun execution, true otherwise
     */
    boolean cancel0() {
        setPeriod(BukkitTaskImpl.CANCEL);
        return true;
    }

}
