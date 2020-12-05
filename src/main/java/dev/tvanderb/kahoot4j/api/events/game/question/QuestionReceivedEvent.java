package dev.tvanderb.kahoot4j.api.events.game.question;

import dev.tvanderb.kahoot4j.api.KahootClient;
import dev.tvanderb.kahoot4j.api.entities.Game;
import dev.tvanderb.kahoot4j.api.entities.Question;
import org.jetbrains.annotations.NotNull;

public class QuestionReceivedEvent extends QuestionEvent {

    /**
     * Creates a new {@link dev.tvanderb.kahoot4j.api.events.game.GameEvent GameEvent} instance.
     *
     * @param raw      The raw JSON message received from Kahoot.
     * @param client   The {@link KahootClient KahootClient} that this event is for.
     * @param game     The {@link Game Game} that this event is for.
     * @param question The {@link Question Question} that this event is for.
     */
    public QuestionReceivedEvent(@NotNull String raw, @NotNull KahootClient client, @NotNull Game game, @NotNull Question question) {
        super(raw, client, game, question);
    }

}
