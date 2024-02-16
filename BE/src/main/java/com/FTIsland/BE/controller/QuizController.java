package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.QuizDTO;
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

    @PostMapping("/book/quiz")
    public List<QuizDTO> getQuiz(@RequestBody QuizDTO quizDTO){
        Integer userLevel = userService.findLevelById(quizDTO.getUserId());
        return quizService.makeQuiz(userLevel);
    }
}
