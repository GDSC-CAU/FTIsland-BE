package com.FTIsland.BE.controller;


import com.FTIsland.BE.service.BookInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookInfoController {
    private final BookInfoService bookInfoService;

    @RequestMapping("/saveBookInfo")
    public void saveBookInfo(){ // DB에 동화 정보 저장
        bookInfoService.save();
    }


}
