package com.FTIsland.BE.service;


import com.FTIsland.BE.dto.QuizDTO;
import com.FTIsland.BE.entity.QuizEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final TranslationService translationService;

    // 동화-레벨 조합의 퀴즈가 있는지 확인

    // 생성한 퀴즈 String을 3개의 퀴즈 String list로 변환
    public List<String> makeQuiz(String threeQuiz) {
        // 리스트에 질문 3개 담기
        // 1. parsing
        String quizLine[] = threeQuiz.split("\n");

        // 2. list에 추가
        List<String> quizs = new ArrayList<>();
        quizs.add(quizLine[0]);
        quizs.add(quizLine[1]);
        quizs.add(quizLine[2]);

        // QuizDTO List 반환
        return quizs;
    }

    // 3개의 퀴즈 list를 번역 후 QuizDTO로 반환
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
