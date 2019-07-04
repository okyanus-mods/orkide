package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.ConnectEvent;
import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements EventHandler<ConnectEvent> {

    @Override
    public void handle(ConnectEvent event) {
        new Thread(() -> {
            AsyncPlayerPreLoginEvent preLoginEvent = new AsyncPlayerPreLoginEvent(new PlayerImpl(event.getPlayer()).getName(), event.getAddress(), event.getPlayer().getUUID());
            Bukkit.getServer().getPluginManager().callEvent(preLoginEvent);

            event.setCancelled(preLoginEvent.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED);
            event.setCancelReason(preLoginEvent.getKickMessage());

            if (event.isCancelled())
                event.getPlayer().kick(event.getCancelReason()); // Manual cancellation since this is async.
        }).start();

        if (event.isCancelled())
            return;

        PlayerJoinEvent joinEvent = new PlayerJoinEvent(new PlayerImpl(event.getPlayer()), event.getMessage());
        Bukkit.getServer().getPluginManager().callEvent(joinEvent);

        event.setMessage(joinEvent.getJoinMessage());
    }

}
