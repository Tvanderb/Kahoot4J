package dev.tvanderb.kahoot4j.api.events.game.question;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.entities.Game;
import dev.tvanderb.kahoot4j.api.entities.Question;
import dev.tvanderb.kahoot4j.api.events.game.GameEvent;
import org.jetbrains.annotations.NotNull;

public class QuestionEvent extends GameEvent {

    private final Question question;

    /**
     * Creates a new {@link GameEvent GameEvent} instance.
     *
     * @param raw      The raw JSON message received from Kahoot.
     * @param client   The {@link KahootClient KahootClient} that this event is for.
     * @param game     The {@link Game Game} that this event is for.
     * @param question The {@link Question Question} that this event is for.
     */
    public QuestionEvent(@NotNull String raw, @NotNull KahootClient client, @NotNull Game game, @NotNull Question question) {
        super(raw, client, game);

        this.question = question;
    }

    /**
     * @return The question surrounding this event.
     */
    @NotNull
    public Question getQuestion() {
        return question;
    }

}
