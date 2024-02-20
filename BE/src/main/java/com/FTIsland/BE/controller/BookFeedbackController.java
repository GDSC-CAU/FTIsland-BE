package com.FTIsland.BE.controller;


import com.FTIsland.BE.dto.BookFeedbackDTO;
import com.FTIsland.BE.dto.ResponseDTO;
import com.FTIsland.BE.service.BookFeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookFeedbackController {

    private final BookFeedbackService bookFeedbackService;

    @PostMapping("/book/feedback")
    public ResponseDTO updateLevel(@RequestBody BookFeedbackDTO bookFeedbackDTO) {
        return bookFeedbackService.updateLevel(bookFeedbackDTO);

    }
}
