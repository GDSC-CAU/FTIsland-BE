package com.FTIsland.BE.book.progress.controller;

import com.FTIsland.BE.book.progress.dto.BookProgressRequest;
import com.FTIsland.BE.dto.ReadDTO;
import com.FTIsland.BE.service.ReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookProgressController {
    private final ReadService readService;

    @GetMapping("/book/progress")
    public List<ReadDTO> getBookInfoWithRead(@RequestBody BookProgressRequest bookProgressRequest) {
        return readService.getProgress(bookProgressRequest);
    }
}
