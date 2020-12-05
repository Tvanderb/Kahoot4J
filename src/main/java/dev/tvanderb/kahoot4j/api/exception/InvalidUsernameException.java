package dev.tvanderb.kahoot4j.api.exception;

import org.jetbrains.annotations.NotNull;

/**
 * This exception is thrown when there's something wrong with a username.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class InvalidUsernameException extends Exception {

    private final String username;

    /**
     * Create a new {@link InvalidUsernameException} instance.
     *
     * @param username The username that caused this {@link InvalidUsernameException}.
     * @param message  The message to show in the stack trace.
     */
    public InvalidUsernameException(@NotNull String username, @NotNull String message) {
        super(message);

        this.username = username;
    }

    /**
     * @return The username responsible for this {@link InvalidUsernameException}.
     */
    @NotNull
    public String getFaultyUsername() {
        return username;
    }

}
