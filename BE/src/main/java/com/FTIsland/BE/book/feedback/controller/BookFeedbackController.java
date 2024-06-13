package com.FTIsland.BE.book.feedback.controller;

import com.FTIsland.BE.book.feedback.dto.BookFeedbackRequest;
import com.FTIsland.BE.dto.ResponseDTO;
import com.FTIsland.BE.book.feedback.service.BookFeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookFeedbackController {

    private final BookFeedbackService bookFeedbackService;

    @PostMapping("/book/feedback")
    public ResponseEntity<ResponseDTO> updateLevel(@RequestBody BookFeedbackRequest bookFeedbackRequest) {
        ResponseDTO responseDTO = bookFeedbackService.updateLevel(bookFeedbackRequest);
        return ResponseEntity.ok(responseDTO);

    }
}
