package com.FTIsland.BE.controller;

import com.FTIsland.BE.service.BookContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookContentController {
    private final BookContentService bookContentService;

    @RequestMapping("/saveBookContent")
    public void saveBookContent(){ // DB에 동화 정보 저장
        bookContentService.save();
    }

}
