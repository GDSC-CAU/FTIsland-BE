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
    private final TranslationService translationService;

    public List<QuizDTO> makeQuiz(String threeQuiz) {
        // 리스트에 질문 3개 담기
        // 1. parsing
        String quizLine[] = threeQuiz.split("\n");

        // 2. list에 추가
        List<QuizDTO> quizDTOS = new ArrayList<>();
        quizDTOS.add(new QuizDTO(quizLine[0], null, null));
        quizDTOS.add(new QuizDTO(quizLine[1], null, null));
        quizDTOS.add(new QuizDTO(quizLine[2], null, null));

        // QuizDTO List 반환
        return quizDTOS;
    }

    public List<QuizDTO> translationQuiz(List<QuizDTO> quizDTOS, String mainLan, String subLan) {

        List<QuizDTO> translatedQuizDTOS = new ArrayList<>();

        String selectedLanguage = "ko";

        for (QuizDTO dto : quizDTOS) {
            // 번역 로직

            // 1. 주, 보조 언어 텍스트 둘 다 한국어를 기본으로 설정
            String mainText = dto.getQuestion();
            String subText = dto.getQuestion();

            // 2. 요청한 언어에 맞게 번역
            if (mainLan.equals("ko")) { // 주 언어가 한국어가 아니라면 번역해서 저장
                selectedLanguage = subLan;
                subText = translationService.test(selectedLanguage, subText);
            }
            if (subLan.equals("ko")) { // 보조 언어가 한국어가 아니라면 번역해서 저장
                selectedLanguage = mainLan;
                mainText = translationService.test(selectedLanguage, mainText);
            }

            // DTO List에 추가
            translatedQuizDTOS.add(new QuizDTO(null, mainText, subText));
        }

        return translatedQuizDTOS;

    }
}
