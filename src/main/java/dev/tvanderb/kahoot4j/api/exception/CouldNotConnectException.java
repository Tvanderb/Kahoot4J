package dev.tvanderb.kahoot4j.api.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Thrown when a {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} couldn't connect to a game.
 */
public class CouldNotConnectException extends Exception {

    private final Integer gamePin;

    /**
     * Create a new {@link CouldNotConnectException CouldNotConnectException} instance.
     *
     * @param gamePin The game pin that couldn't be connected to.
     * @param message The message to display in the stack trace.
     */
    public CouldNotConnectException(@NotNull Integer gamePin, @NotNull String message) {
        super(message);

        this.gamePin = gamePin;
    }

    /**
     * @return The game pin that couldn't be connected to.
     */
    @NotNull
    public Integer getGamePin() {
        return gamePin;
    }

}
