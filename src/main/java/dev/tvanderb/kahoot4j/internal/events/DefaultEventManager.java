package dev.tvanderb.kahoot4j.internal.events;

import dev.tvanderb.kahoot4j.api.events.Event;
import dev.tvanderb.kahoot4j.api.events.IEventManager;
import dev.tvanderb.kahoot4j.api.events.KahootEventListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DefaultEventManager implements IEventManager {

    private final List<KahootEventListener> eventListeners = new ArrayList<>();

    @Override
    public void addEventListener(@NotNull KahootEventListener listener) {
        eventListeners.add(listener);
    }

    @Override
    public void removeEventListener(@NotNull KahootEventListener listener) {
        eventListeners.remove(listener);
    }

    @Override
    public @NotNull List<KahootEventListener> getEventListeners() {
        return eventListeners;
    }

    @Override
    public void sendEvent(@NotNull Event event) {
        for (KahootEventListener listener : eventListeners) {
            try {
                listener.accept(event);
            } catch (Exception ignore) {}
        }
    }

}
