package dev.tvanderb.kahoot4j.api.entities;

/**
 * Class representing an an answer to a {@link Question Question}.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public interface Answer {

    /**
     * @return The {@link Game Game} that the {@link Question Question} is in.
     */
    Game getGame();

    /**
     * @return The {@link Question Question} that this answer is for.
     */
    Question getQuestion();

    /**
     * @return Whether or not the {@link dev.tvanderb.kahoot4j.api.KahootClient KahootClient} answered correctly.
     */
    boolean wasCorrect();

    /**
     * @apiNote This array will only contain other answers when it was a jumble question.
     * @return The correct answer.
     */
    AnswerBlock[] correctAnswer();

}
