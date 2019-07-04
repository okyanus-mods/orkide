package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.BreakEvent;
import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.orkide.bukkit.block.BlockImpl;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements EventHandler<BreakEvent> {

    @Override
    public void handle(BreakEvent event) {
        BlockBreakEvent breakEvent = new BlockBreakEvent(new BlockImpl(event.getBlock()), new PlayerImpl(event.getPlayer()));
        Bukkit.getServer().getPluginManager().callEvent(breakEvent);

        event.setCancelled(breakEvent.isCancelled());
    }

}
