package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QuizDTO {
    private Long userId;
    private Integer bookId;
    private String question;

    public QuizDTO(String question){
        this.question = question;
    }
}
