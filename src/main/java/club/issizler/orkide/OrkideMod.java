package club.issizler.orkide;

import club.issizler.okyanus.api.Mod;
import club.issizler.okyanus.api.cmd.CommandBuilder;
import club.issizler.okyanus.api.cmd.CommandManager;
import club.issizler.okyanus.api.event.EventManager;
import club.issizler.orkide.commands.PluginsCommand;
import club.issizler.orkide.events.ReadyListener;

import java.io.File;

public class OrkideMod implements Mod {

    Orkide orkide = new Orkide();

    @Override
    public void init() {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
        EventManager.getInstance().register(new ReadyListener(orkide));

        File plugins = new File("./plugins");
        if (!plugins.exists()) {
            plugins.mkdirs();
            System.out.println("Orkide: You can now place your plugins in the newly created plugins folder!");
            return;
        }

        CommandManager.getInstance().register(
                new CommandBuilder()
                        .name("plugins")
                        .run(new PluginsCommand(this.orkide))
        );

        orkide.loadFolder(plugins);
        orkide.onEnableStartup();
    }

}
