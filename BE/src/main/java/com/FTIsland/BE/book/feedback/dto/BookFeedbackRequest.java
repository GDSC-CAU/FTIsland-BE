package com.FTIsland.BE.book.feedback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookFeedbackDTO {

    private Integer userId;
    private Integer feedback;

    public BookFeedbackDTO(Integer userId, Integer feedback) {
        this.userId = userId;
        this.feedback = feedback;
    }
}
