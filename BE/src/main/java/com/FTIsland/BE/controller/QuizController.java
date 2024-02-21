package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.ChatGptResponse;
import com.FTIsland.BE.dto.QuizDTO;
import com.FTIsland.BE.service.BookInfoService;
import com.FTIsland.BE.service.ChatGptService;
import com.FTIsland.BE.service.QuizService;
import com.FTIsland.BE.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final UserService userService;
    private final QuizService quizService;
    private final ChatGptService chatGptService;
    private final BookInfoService bookInfoService;

    @PostMapping("/book/quiz")
    public List<QuizDTO> getQuiz(@RequestBody QuizDTO quizDTO){
        // 사용자 맞춤형 생각해보기 질문 생성을 위해 user entity의 level 정보 조회
        Integer userLevel = userService.findLevelById(quizDTO.getUserId());

        // 책 이름으로 생각해보기 질문을 생성해야하기 때문에 bookId를 통해 동화 제목 조회
        String bookTitle = bookInfoService.findNameById(quizDTO.getBookId());

        // 책의 description 조회 - 동화 제목만으로는 버전이 다를 수 있기 때문에
        // String description = bookInfoService.findDescriptionByUd(quizDTO.getBookId());

        // 이미 해당 동화-레벨 맞춤형 질문이 있으면 DB에서 가져오기 / 없다면 퀴즈 생성 후 저장
          // 1. quizService에서 동화-레벨 쌍으로 검색

          // 2-a. 있으면

          // 2-b. 없다면

            // 1. 퀴즈 생성
        ChatGptResponse chatGptResponse = null;
        chatGptResponse = chatGptService.askQuestion(bookTitle, userLevel);
        String threeQuiz = chatGptResponse.getChoices().get(0).getMessage().getContent();
        System.out.println(threeQuiz);

            // 2. 저장


        // 생성된 퀴즈 3개를 파싱하고 해당 퀴즈 리스트를 주언어, 서브언어로 번역 후 반환
        return quizService.translationQuiz(
                quizService.makeQuiz(threeQuiz),
                quizDTO.getMainLan(),
                quizDTO.getSubLan());
    }
}
