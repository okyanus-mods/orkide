package club.issizler.orkide.bukkit.scheduler;

import org.bukkit.plugin.Plugin;

class AsyncDebuggerImpl {

    private AsyncDebuggerImpl next = null;
    private final int expiry;
    private final Plugin plugin;
    private final Class<?> clazz;

    AsyncDebuggerImpl(final int expiry, final  Plugin plugin, final Class<?> clazz) {
        this.expiry = expiry;
        this.plugin = plugin;
        this.clazz = clazz;

    }

    final AsyncDebuggerImpl getNextHead(final int time) {
        AsyncDebuggerImpl next, current = this;
        while (time > current.expiry && (next = current.next) != null) {
            current = next;
        }
        return current;
    }

    final AsyncDebuggerImpl setNext(final AsyncDebuggerImpl next) {
        return this.next = next;
    }

    StringBuilder debugTo(final StringBuilder string) {
        for (AsyncDebuggerImpl next = this; next != null; next = next.next) {
            string.append(next.plugin.getDescription().getName()).append(':').append(next.clazz.getName()).append('@').append(next.expiry).append(',');
        }
        return string;
    }

}
