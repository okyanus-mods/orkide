package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.DisconnectEvent;
import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements EventHandler<DisconnectEvent> {

    @Override
    public void handle(DisconnectEvent event) {
        PlayerQuitEvent quitEvent = new PlayerQuitEvent(new PlayerImpl(event.getPlayer()), event.getMessage());
        Bukkit.getServer().getPluginManager().callEvent(quitEvent);

        event.setMessage(quitEvent.getQuitMessage());
    }

}
