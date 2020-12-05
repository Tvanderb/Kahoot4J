package dev.tvanderb.kahoot4j.api.exception;

import org.jetbrains.annotations.NotNull;

public class CouldNotConnectException extends Exception {

    private final Integer gamePin;
    private final String message;

    public CouldNotConnectException(@NotNull Integer gamePin, @NotNull String message) {
        this.gamePin = gamePin;
        this.message = message;
    }

    @NotNull
    public Integer getGamePin() {
        return gamePin;
    }

    @NotNull
    public String message() {
        return message;
    }

}
