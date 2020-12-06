package dev.tvanderb.kahoot4j.api;

import dev.tvanderb.kahoot4j.api.entities.Game;
import dev.tvanderb.kahoot4j.api.events.IEventManager;
import dev.tvanderb.kahoot4j.api.exception.CouldNotConnectException;
import dev.tvanderb.kahoot4j.api.exception.InvalidGamePinException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

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
     * @return The set {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager} for this {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}.
     */
    IEventManager getEventManager();

    /**
     * Connect to a Kahoot Game.
     *
     * @param gamePin The game pin of the game you wish to connect to.
     * @return The {@link Game} object representing that game.
     */
    Game connect(int gamePin) throws IOException, InvalidGamePinException, CouldNotConnectException;

}
