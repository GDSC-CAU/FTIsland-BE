package com.FTIsland.BE.book.feedback.entity;

import lombok.Getter;

@Getter
public class Feedback {
    public static final Integer FEEDBACK_MINUS_ONE = -1;
    public static final Integer FEEDBACK_ZERO = 0;
    public static final Integer FEEDBACK_ONE = 1;

    private Integer feedback;

    public Feedback(Integer feedback) {
        this.feedback = feedback;
    }
}
