package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.DropEvent;
import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.orkide.bukkit.entity.ItemImpl;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements EventHandler<DropEvent> {

    @Override
    public void handle(DropEvent event) {
        PlayerDropItemEvent dropItemEvent = new PlayerDropItemEvent(new PlayerImpl(event.getPlayer()), new ItemImpl());
        Bukkit.getServer().getPluginManager().callEvent(dropItemEvent);

        event.setCancelled(dropItemEvent.isCancelled());
    }

}
