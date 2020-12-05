package dev.tvanderb.kahoot4j.api;

import dev.tvanderb.kahoot4j.internal.KahootClientImpl;
import org.jetbrains.annotations.NotNull;

/**
 * A class to easily construct [add link here].
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class KahootBuilder {

    @NotNull
    public static KahootBuilder create(String username) {
        return new KahootBuilder(username);
    }

    private String username;
    private int gameId;

    /**
     * Creates a new {@link dev.tvanderb.kahoot4j.api.KahootBuilder KahootBuilder} instance.
     *
     * @param username The username the client will have.
     */
    private KahootBuilder(String username) {
        this.username = username;
    }

    /**
     * Set the username of this {@link dev.tvanderb.kahoot4j.api.KahootBuilder KahootBuilder} instance.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
