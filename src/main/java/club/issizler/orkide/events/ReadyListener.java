package club.issizler.orkide.events;

import club.issizler.okyanus.api.event.EventHandler;
import club.issizler.okyanus.api.event.ReadyEvent;
import club.issizler.orkide.Orkide;

public class ReadyListener implements EventHandler<ReadyEvent> {

    private final Orkide orkide;

    public ReadyListener(Orkide orkide) {
        this.orkide = orkide;
    }

    @Override
    public void handle(ReadyEvent event) {
        orkide.onEnablePostworld();
    }

}
