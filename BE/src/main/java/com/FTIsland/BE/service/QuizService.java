package com.FTIsland.BE.service;


import com.FTIsland.BE.dto.QuizDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {
    public List<QuizDTO> makeQuiz(String threeQuiz){
        // 리스트에 질문 3개 담기
        // 1. parsing
        String quizLine[] = threeQuiz.split("\n");

        // 2. list에 추가
        List<QuizDTO> quizDTOS = new ArrayList<>();
        quizDTOS.add(new QuizDTO(quizLine[0]));
        quizDTOS.add(new QuizDTO(quizLine[1]));
        quizDTOS.add(new QuizDTO(quizLine[2]));

        // QuizDTO List 반환
        return quizDTOS;
    }

}
