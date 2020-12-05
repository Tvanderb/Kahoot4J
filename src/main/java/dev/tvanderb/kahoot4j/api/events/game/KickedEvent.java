package dev.tvanderb.kahoot4j.api.events.game;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.entities.Game;
import org.jetbrains.annotations.NotNull;

/**
 * This event is fired when the {@link KahootClient KahootClient} is kicked from a game.
 */
public class KickedEvent extends GameEvent {

    /**
     * Creates a new {@link GameEvent GameEvent} instance.
     *
     * @param raw    The raw JSON message received from Kahoot.
     * @param client The {@link KahootClient KahootClient} that this event is for.
     * @param game   The {@link Game Game} that this event is for.
     */
    public KickedEvent(@NotNull String raw, @NotNull KahootClient client, @NotNull Game game) {
        super(raw, client, game);
    }

}
