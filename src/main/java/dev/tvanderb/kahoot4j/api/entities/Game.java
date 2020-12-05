package dev.tvanderb.kahoot4j.api.entities;

import dev.tvanderb.kahoot4j.api.KahootClient;

/**
 * Class representing a Kahoot game.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public interface Game {

    enum GameType {
        QUIZ;
    }

    /**
     * @return The {@link KahootClient KahootClient} that is in this game.
     */
    KahootClient getSelf();

    /**
     * @return The name of the game.
     */
    String getName();

    /**
     * @return The total amount of points the {@link KahootClient KahootClient} has.
     */
    int getPoints();

    /**
     * @return The game pin of this {@link Game}.
     */
    int getGamePin();

    /**
     * @return The number of questions in this game.
     */
    int getQuestionCount();

    /**
     * Disconnect from this game.
     */
    void disconnect();

}