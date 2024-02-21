package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.ChatGptResponse;
import com.FTIsland.BE.dto.QuizDTO;
import com.FTIsland.BE.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final UserService userService;
    private final QuizService quizService;
    private final ChatGptService chatGptService;
    private final BookInfoService bookInfoService;
    private final BookContentService bookContentService;

    @PostMapping("/book/quiz")
    public List<QuizDTO> getQuiz(@RequestBody QuizDTO quizDTO){
        // 사용자 맞춤형 생각해보기 질문 생성을 위해 user entity의 level 정보 조회
        Integer userLevel = userService.findLevelById(quizDTO.getUserId());

        // 책 이름으로 생각해보기 질문을 생성해야하기 때문에 bookId를 통해 동화 제목 조회
        String bookTitle = bookInfoService.findNameById(quizDTO.getBookId());

        // 책의 contents 조회 - 동화 제목만으로는 버전이 다를 수 있기 때문에
        // 1. bookContentService의 findByBookId method를 쓰기 위해 QuizDTO -> BookContentDTO 변환
        BookContentDTO bookContentDTO = new BookContentDTO();
        bookContentDTO.setBookId(quizDTO.getBookId());
        bookContentDTO.setMainLan(quizDTO.getMainLan());
        bookContentDTO.setSubLan(quizDTO.getSubLan());
        // 2. content List 조회
        List<BookContentDTO> bookContentDTOS = bookContentService.findByBookId(bookContentDTO);
        List<String> bookContentList = new ArrayList<>();
        for(BookContentDTO dto : bookContentDTOS){
            bookContentList.add(dto.getKorContents());
        }
        String bookContents = String.join(" ", bookContentList);
        // System.out.println(bookContents);

        // 퀴즈 생성
        ChatGptResponse chatGptResponse = null;
        chatGptResponse = chatGptService.askQuestion(bookTitle, userLevel, bookContents);
        String threeQuiz = chatGptResponse.getChoices().get(0).getMessage().getContent();
        // System.out.println(threeQuiz);


        // 생성된 퀴즈 3개를 파싱하고 해당 퀴즈 리스트를 주언어, 서브언어로 번역 후 반환
        return quizService.translationQuiz(
                quizService.makeQuiz(threeQuiz),
                quizDTO.getMainLan(),
                quizDTO.getSubLan());
    }
}
