package club.issizler.template;

import club.issizler.okyanus.api.Mod;
import club.issizler.okyanus.api.cmd.CommandBuilder;
import club.issizler.okyanus.api.cmd.CommandManager;

public class TemplateMod implements Mod {

    @Override
    public void init() {
        System.out.println("Hello, world!");

        CommandManager.getInstance().register(
                new CommandBuilder()
                        .name("hello")
                        .run(source -> {
                            source.send("Hello, world!");
                            return 1;
                        })
        );
    }

}
