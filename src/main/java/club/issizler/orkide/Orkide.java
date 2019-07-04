package club.issizler.orkide;

import club.issizler.orkide.bukkit.ServerImpl;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

public class Orkide {

    public static final String BUKKIT_VERSION = "1.14.3-R0.1-SNAPSHOT";

    public PluginManager manager = new SimplePluginManager(Globals.server, ((ServerImpl) Globals.server).commandMap);

    Orkide() {
        ((ServerImpl) Globals.server).pluginManager = manager;
        manager.registerInterface(JavaPluginLoader.class);
    }

    void loadFolder(File plugins) {
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

    void onEnableStartup() {
        for (Plugin plugin : manager.getPlugins()) {
            if (plugin.getDescription().getLoad() == PluginLoadOrder.STARTUP)
                manager.enablePlugin(plugin);
        }
    }

}
