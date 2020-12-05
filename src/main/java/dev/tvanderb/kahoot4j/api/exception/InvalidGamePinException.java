package dev.tvanderb.kahoot4j.api.exception;

import dev.tvanderb.kahoot4j.api.KahootClient;
import org.jetbrains.annotations.NotNull;

/**
 * This exception is thrown when a {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} tries to connect to a game that doesn't exist.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class InvalidGamePinException extends Exception {

    private final KahootClient client;
    private final Integer gamePin;

    /**
     * Create a new {@link InvalidGamePinException} instance.
     *
     * @param client The client that tried to connect.
     * @param message The message to show in the stack trace.
     */
    public InvalidGamePinException(@NotNull KahootClient client, @NotNull Integer gamePin, @NotNull String message) {
        super(message);

        this.client = client;
        this.gamePin = gamePin;
    }

    /**
     * @return The client that tried to connect.
     */
    @NotNull
    public KahootClient getClient() {
        return client;
    }

    /**
     * @return The game pin that the {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} attempted to connect to.
     */
    @NotNull
    public Integer getGamePin() {
        return gamePin;
    }

}
