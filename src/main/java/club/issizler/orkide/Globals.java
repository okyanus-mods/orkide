package club.issizler.orkide;

import club.issizler.okyanus.api.Okyanus;
import club.issizler.orkide.bukkit.ServerImpl;
import org.bukkit.Server;

public class Globals {

    public static Server server = new ServerImpl(Okyanus.getServer());

}
