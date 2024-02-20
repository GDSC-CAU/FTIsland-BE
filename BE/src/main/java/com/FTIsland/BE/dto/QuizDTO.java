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
    private Integer userId;
    private Integer bookId;
    private String mainLan;
    private String subLan;
    private String question;
    private String mainQuestion;
    private String subQuestion;

    public QuizDTO(String question, String mainQuestion, String subQuestion){
        this.question = question;
        this.mainQuestion = mainQuestion;
        this.subQuestion = subQuestion;
    }
}
