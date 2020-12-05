package dev.tvanderb.kahoot4j.api.events;

import dev.tvanderb.kahoot4j.api.KahootClient;

/**
 * Base event class.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class Event {

    private final KahootClient client;

    /**
     * Creates a new {@link dev.tvanderb.kahoot4j.api.events.Event Event} instance.
     *
     * @param client The {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} that this event is for.
     */
    public Event(KahootClient client) {
        this.client = client;
    }

    /**
     * @return The {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} that this event is for.
     */
    public KahootClient getClient() {
        return client;
    }

}
