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

    KahootClient getSelf();

    String getName();

    int getPoints();

    int getGamePin();

    int getQuestionCount();

    void disconnect();

}