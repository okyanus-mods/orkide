package club.issizler.orkide;

import club.issizler.okyanus.api.Mod;
import club.issizler.orkide.events.JoinListener;
import club.issizler.orkide.events.LeaveListener;
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

        registerEvent(new JoinListener());
        registerEvent(new LeaveListener());

        File plugins = new File("./plugins");
        if (!plugins.exists()) {
            plugins.mkdirs();
            System.out.println("Orkide: You can now place your plugins in the newly created plugins folder!");
        }

        orkide.loadFolder(plugins);
        orkide.onEnableStartup();
    }

}
