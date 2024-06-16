package com.FTIsland.BE.book.feedback.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class BookFeedbackRequest {

    private Integer userId;
    private Integer feedback;

    @Builder
    public BookFeedbackRequest(Integer userId, Integer feedback) {
        this.userId = userId;
        this.feedback = feedback;
    }
}
