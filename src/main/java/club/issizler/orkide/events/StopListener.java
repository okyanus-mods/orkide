package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.okyanus.api.event.StopEvent;
import club.issizler.orkide.Orkide;

public class StopListener implements EventHandler<StopEvent> {

    private final Orkide orkide;

    public StopListener(Orkide orkide) {
        this.orkide = orkide;
    }

    @Override
    public void handle(StopEvent event) {
        orkide.manager.disablePlugins();
    }

}
