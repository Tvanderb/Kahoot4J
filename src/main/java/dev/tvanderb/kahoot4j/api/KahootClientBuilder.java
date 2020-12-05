package dev.tvanderb.kahoot4j.api;

import dev.tvanderb.kahoot4j.api.events.IEventManager;
import dev.tvanderb.kahoot4j.api.events.KahootEventListener;
import dev.tvanderb.kahoot4j.api.exception.InvalidUsernameException;

/**
 * A class to easily construct a {@link KahootClient}.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class KahootClientBuilder {

    private String username;
    private IEventManager eventManager;

    /**
     * Creates a new {@link KahootClientBuilder KahootBuilder} instance.
     *
     * @param username The username the client will have.
     */
    public KahootClientBuilder(String username) {
        this.username = username;
    }

    /**
     * Change the username of this {@link KahootClientBuilder KahootBuilder} instance.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Change the EventManger of this {@link KahootClientBuilder KahootBuilder} instance.
     * The default is [add link]
     *
     * @param eventManager The new {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager}.
     */
    public void setEventManager(IEventManager eventManager) {
        this.eventManager = eventManager;
    }

    /**
     * Add a {@link dev.tvanderb.kahoot4j.api.events.KahootEventListener KahootEventListener} to the {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager}.
     *
     * @param listener The listener to add.
     */
    public void addEventListener(KahootEventListener listener) {
        this.eventManager.addEventListener(listener);
    }

    /**
     * Remove a {@link dev.tvanderb.kahoot4j.api.events.KahootEventListener KahootEventListener} from the {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager}.
     *
     * @param listener The listener to add.
     */
    public void removeEventListener(KahootEventListener listener) {
        this.eventManager.removeEventListener(listener);
    }

    /**
     * Construct a {@link KahootClient} from this {@link KahootClientBuilder}.
     *
     * @return A built {@link KahootClient}.
     */
    public KahootClient build() throws InvalidUsernameException {
        if (username == null) {
            throw new InvalidUsernameException("", "Username has not been defined!");
        }

        if (username.length() > 15) {
            throw new InvalidUsernameException(username, "Username exceeds Kahoot's 15 character limit!");
        }

        return null;
    }

}
