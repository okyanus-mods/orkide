package club.issizler.orkide;


import club.issizler.orkide.bukkit.ServerImpl;
import org.bukkit.Server;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

public class Orkide {

    public PluginManager manager = new SimplePluginManager(Globals.server, new SimpleCommandMap(Globals.server));

    public Orkide() {
        ((ServerImpl) Globals.server).pluginManager = manager;
        manager.registerInterface(JavaPluginLoader.class);
    }

    public void loadFolder(File plugins) {
        for (Plugin plugin : manager.loadPlugins(plugins)) {
            Globals.server.getLogger().info("Loading " + plugin.getName());
            plugin.onLoad();
        }
    }

    public void onEnablePostworld() {
        for (Plugin plugin : manager.getPlugins()) {
            if (plugin.getDescription().getLoad() == PluginLoadOrder.POSTWORLD)
                manager.enablePlugin(plugin);
        }
    }

    public void onEnableStartup() {
        for (Plugin plugin : manager.getPlugins()) {
            if (plugin.getDescription().getLoad() == PluginLoadOrder.STARTUP)
                manager.enablePlugin(plugin);
        }
    }

}
