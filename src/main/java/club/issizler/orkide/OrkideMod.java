package club.issizler.orkide;

import club.issizler.okyanus.api.Mod;
import club.issizler.okyanus.api.cmd.CommandBuilder;
import club.issizler.orkide.commands.PluginsCommand;
import club.issizler.orkide.events.ReadyListener;
import club.issizler.orkide.events.StopListener;

import java.io.File;

public class OrkideMod extends Mod {

    private Orkide orkide = new Orkide();

    @Override
    public void init() {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");

        registerEvent(new ReadyListener(orkide));
        registerEvent(new StopListener(orkide));

        File plugins = new File("./plugins");
        if (!plugins.exists()) {
            plugins.mkdirs();
            System.out.println("Orkide: You can now place your plugins in the newly created plugins folder!");
            return;
        }

        registerCommand(
                new CommandBuilder("plugins")
                        .run(new PluginsCommand(this.orkide))
        );

        orkide.loadFolder(plugins);
        orkide.onEnableStartup();
    }

}
