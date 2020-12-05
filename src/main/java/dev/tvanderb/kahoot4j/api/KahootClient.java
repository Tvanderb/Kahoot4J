package dev.tvanderb.kahoot4j.api;

import dev.tvanderb.kahoot4j.api.events.IEventManager;

/**
 * A class representing a client-side Kahoot player.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public interface KahootClient {

    /**
     * An enumeration of {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} statuses.
     */
    enum ClientStatus {
        PRE_INITIALIZATION,
        HANDSHAKE,
        SOLVE_CHALLENGE,
        SETUP_WEBSOCKET,
        LOGIN,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    /**
     * @return The current status of this {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}.
     */
    ClientStatus getCurrentStatus();

    /**
     * @return The username of this {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}.
     */
    String getUsername();

    /**
     * Set this {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}'s username.
     */
    void setUsername(String username);

    /**
     * @return The set {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager} for this {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}.
     */
    IEventManager getEventManager();

}
