package dev.tvanderb.kahoot4j.api;

import dev.tvanderb.kahoot4j.api.events.IEventManager;
import dev.tvanderb.kahoot4j.api.events.KahootEventListener;
import dev.tvanderb.kahoot4j.api.exception.InvalidUsernameException;
import dev.tvanderb.kahoot4j.internal.KahootClientImpl;
import org.jetbrains.annotations.NotNull;

/**
 * A class to easily construct a {@link KahootClient}.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class KahootClientBuilder {

    private String username = null;
    private IEventManager eventManager;

    /**
     * Creates a new {@link KahootClientBuilder KahootBuilder} instance.
     */
    public KahootClientBuilder() {}

    /**
     * Change the username of this {@link KahootClientBuilder KahootBuilder} instance.
     *
     * @param username The new username.
     */
    public KahootClientBuilder setUsername(@NotNull String username) {
        this.username = username;
        return this;
    }

    /**
     * Change the EventManger of this {@link KahootClientBuilder KahootBuilder} instance.
     * The default is an instance of {@link dev.tvanderb.kahoot4j.internal.events.DefaultEventManager DefaultEventManager}.
     *
     * @param eventManager The new {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager}.
     */
    public KahootClientBuilder setEventManager(@NotNull IEventManager eventManager) {
        this.eventManager = eventManager;
        return this;
    }

    /**
     * Add a {@link dev.tvanderb.kahoot4j.api.events.KahootEventListener KahootEventListener} to the {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager}.
     *
     * @param listener The listener to add.
     */
    public KahootClientBuilder addEventListener(KahootEventListener listener) {
        this.eventManager.addEventListener(listener);
        return this;
    }

    /**
     * Remove a {@link dev.tvanderb.kahoot4j.api.events.KahootEventListener KahootEventListener} from the {@link dev.tvanderb.kahoot4j.api.events.IEventManager IEventManager}.
     *
     * @param listener The listener to add.
     */
    public KahootClientBuilder removeEventListener(KahootEventListener listener) {
        this.eventManager.removeEventListener(listener);
        return this;
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

        return new KahootClientImpl(username, eventManager);
    }

}
