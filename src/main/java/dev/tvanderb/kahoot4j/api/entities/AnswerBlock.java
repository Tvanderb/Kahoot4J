package dev.tvanderb.kahoot4j.api.entities;

public enum AnswerBlock {

    RED(0),
    BLUE(1),
    ORANGE(2),
    GREEN(3);

    private final Integer rawValue;
    AnswerBlock(Integer rawValue) {
        this.rawValue = rawValue;
    }

    /**
     * @return The raw Kahoot API ID of this {@link AnswerBlock}.
     */
    public Integer getRawValue() {
        return rawValue;
    }

}
