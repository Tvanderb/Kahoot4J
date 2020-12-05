package dev.tvanderb.kahoot4j.annotations;

import dev.tvanderb.kahoot4j.api.events.Event;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define an event handler.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventHandler {
    /**
     * @return The {@link dev.tvanderb.kahoot4j.api.events.Event Event} that this method is listening for.
     */
    @NotNull Class<? extends Event> target();
}
