package dev.tvanderb.kahoot4j.api.events;

import dev.tvanderb.kahoot4j.annotations.EventHandler;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Interface to specify an event listener class.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public interface KahootEventListener {

    default void accept(@NotNull Event e) {
        for (final Method method : this.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventHandler.class)) {
                EventHandler handler = method.getAnnotation(EventHandler.class);

                if (e.getClass().isInstance(handler.target())) {
                    try {
                        method.invoke(e);
                    } catch (IllegalAccessException | InvocationTargetException ignore) {}
                }
            }
        }
    }

}