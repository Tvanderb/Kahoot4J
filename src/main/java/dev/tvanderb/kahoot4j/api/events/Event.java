package dev.tvanderb.kahoot4j.api.events;

import dev.tvanderb.kahoot4j.api.KahootClient;
import org.jetbrains.annotations.NotNull;

/**
 * Base event class.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class Event {

    private final KahootClient client;
    private final String raw;

    /**
     * Creates a new {@link dev.tvanderb.kahoot4j.api.events.Event Event} instance.
     *
     * @param raw    The raw JSON message received from Kahoot.
     * @param client The {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} that this event is for.
     */
    @NotNull
    public Event(@NotNull String raw, @NotNull KahootClient client) {
        this.client = client;
        this.raw = raw;
    }

    /**
     * @return The {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} that this event is for.
     */
    @NotNull
    public KahootClient getClient() {
        return client;
    }

    /**
     * @return The raw JSON message received from Kahoot.
     */
    @NotNull
    public String getEventRaw() {
        return raw;
    }

}
