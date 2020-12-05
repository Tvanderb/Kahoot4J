package dev.tvanderb.kahoot4j.api.events;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This class is used to manage events.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public interface IEventManager {

    /**
     * Add an {@link KahootEventListener} for this {@link IEventManager} to listen for.
     *
     * @param listener The listener to add.
     */
    void addEventListener(@NotNull KahootEventListener listener);

    /**
     * Remove an {@link KahootEventListener} for this {@link IEventManager} to listen for.
     *
     * @param listener The listener to remove.
     */
    void removeEventListener(@NotNull KahootEventListener listener);

    /**
     * @return A list of this {@link IEventManager}'s listeners.
     */
    List<KahootEventListener> getEventListeners();

    /**
     * Sends an event to this {@link IEventManager}'s listeners.
     *
     * @param event The event.
     */
    void sendEvent(@NotNull Event event);

}
