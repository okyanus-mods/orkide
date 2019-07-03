package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.okyanus.api.event.RawCommandEvent;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.event.server.ServerCommandEvent;

public class CommandListener implements EventHandler<RawCommandEvent> {

    @Override
    public void handle(RawCommandEvent event) {
        Server s = Bukkit.getServer();
        CommandSender sender = null;

        if (event.getPlayer().isPresent())
            sender = new PlayerImpl(event.getPlayer().get());
        else
            sender = s.getConsoleSender();

        ServerCommandEvent commandEvent = new ServerCommandEvent(sender, event.getCommand());
        s.getPluginManager().callEvent(commandEvent);

        event.setCancelled(commandEvent.isCancelled());

        if (!event.isCancelled()) {
            event.setCommand(commandEvent.getCommand());
            event.setCancelled(s.dispatchCommand(sender, event.getCommand()));
        }
    }

}
