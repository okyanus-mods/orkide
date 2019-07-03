package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.ConnectEvent;
import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements EventHandler<ConnectEvent> {

    @Override
    public void handle(ConnectEvent event) {
        Event joinEvent = new PlayerJoinEvent(new PlayerImpl(event.getPlayer()), event.getPlayer() + " joined the server!");
        Bukkit.getServer().getPluginManager().callEvent(joinEvent);
    }

}
