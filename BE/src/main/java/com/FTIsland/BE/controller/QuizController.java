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

        // 퀴즈 생성
        ChatGptResponse chatGptResponse = null;
        chatGptResponse = chatGptService.askQuestion(bookTitle, userLevel);
        String threeQuiz = chatGptResponse.getChoices().get(0).getMessage().getContent();
        System.out.println(threeQuiz);

        return quizService.makeQuiz(threeQuiz);
    }
}
