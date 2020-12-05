package dev.tvanderb.kahoot4j.api.entities;

/**
 * Class representing a question in a Kahoot {@link Game Game}.
 *
 * @author Talon 'tvanderb' Vanderbeken
 */
public interface Question {

    enum QuestionType {
        QUIZ;
    }

    int getAvailableTime();

    int getQuestionNumber();

    void answer(AnswerBlock... answers);

}
