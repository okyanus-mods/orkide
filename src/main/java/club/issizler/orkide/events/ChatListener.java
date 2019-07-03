package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.ChatEvent;
import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;

public class ChatListener implements EventHandler<ChatEvent> {

    @Override
    public void handle(ChatEvent event) {
        Server s = Bukkit.getServer();
        AsyncPlayerChatEvent chatEvent = new AsyncPlayerChatEvent(false, new PlayerImpl(event.getPlayer()), event.getMessage(), new HashSet<>(s.getOnlinePlayers()));

        s.getPluginManager().callEvent(chatEvent);

        event.setMessage(chatEvent.getMessage());
        event.setFormat(chatEvent.getFormat());
        event.setCancelled(chatEvent.isCancelled());
    }

}
