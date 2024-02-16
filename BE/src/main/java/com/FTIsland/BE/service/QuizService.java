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
    public List<QuizDTO> makeQuiz(Integer userLevel){
        // 퀴즈 생성

        // 리스트에 질문 3개 담기
        List<QuizDTO> quizDTOS = new ArrayList<>();
        quizDTOS.add(new QuizDTO("늑대는 어땠을까요?"));
        quizDTOS.add(new QuizDTO("돼지 엄마는 어땠을까요?"));
        // QuizDTO List 반환
        return quizDTOS;
    }

}
