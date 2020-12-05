package dev.tvanderb.kahoot4j.api.events.game;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.entities.Game;
import dev.tvanderb.kahoot4j.api.events.Event;
import org.jetbrains.annotations.NotNull;

/**
 * Base event for all {@link dev.tvanderb.kahoot4j.api.entities.Game Game} related events.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class GameEvent extends Event {

    private final Game game;

    /**
     * Creates a new {@link GameEvent GameEvent} instance.
     *
     * @param raw    The raw JSON message received from Kahoot.
     * @param client The {@link KahootClient KahootClient} that this event is for.
     * @param game   The {@link Game Game} that this event is for.
     */
    public GameEvent(@NotNull String raw, @NotNull KahootClient client, @NotNull Game game) {
        super(raw, client);

        this.game = game;
    }

    /**
     * @return The game that this event is for.
     */
    @NotNull
    public Game getGame() {
        return game;
    }

}
