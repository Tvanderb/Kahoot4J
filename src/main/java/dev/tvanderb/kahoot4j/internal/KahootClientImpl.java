package dev.tvanderb.kahoot4j.internal;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.events.IEventManager;

/**
 * Implementation of {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class KahootClientImpl implements KahootClient {

    private ClientStatus status = ClientStatus.PRE_INITIALIZATION;

    private IEventManager eventManager;
    private String username;


    /**
     * Create a new default {@link dev.tvanderb.kahoot4j.internal.KahootClientImpl KahootClient} implementation.
     */
    public KahootClientImpl(String username) {
        this.username = username;
    }

    @Override
    public ClientStatus getCurrentStatus() {
        return status;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public IEventManager getEventManager() {
        return eventManager;
    }

}
