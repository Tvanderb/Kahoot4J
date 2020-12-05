package dev.tvanderb.kahoot4j.internal;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.events.IEventManager;
import org.jetbrains.annotations.NotNull;

/**
 * Implementation of {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient}.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public class KahootClientImpl implements KahootClient {

    private ClientStatus status = ClientStatus.PRE_INITIALIZATION;

    private final IEventManager eventManager;
    private final String username;

    /**
     * Create a new default {@link dev.tvanderb.kahoot4j.internal.KahootClientImpl KahootClient} implementation.
     */
    public KahootClientImpl(@NotNull String username, @NotNull IEventManager eventManager) {
        this.username = username;
        this.eventManager = eventManager;
    }

    @Override
    @NotNull
    public ClientStatus getCurrentStatus() {
        return status;
    }

    @Override
    @NotNull
    public String getUsername() {
        return username;
    }

    @Override
    @NotNull
    public IEventManager getEventManager() {
        return eventManager;
    }

}
