package club.issizler.orkide.commands;

import club.issizler.okyanus.api.cmd.CommandRunnable;
import club.issizler.okyanus.api.cmd.CommandSource;
import club.issizler.orkide.Orkide;

import java.util.Arrays;

public class PluginsCommand implements CommandRunnable {

    private Orkide orkide;

    public PluginsCommand(Orkide orkide) {
        this.orkide = orkide;
    }

    @Override
    public int run(CommandSource source) {
        source.send(Arrays.toString(orkide.manager.getPlugins()));
        return 1;
    }

}
