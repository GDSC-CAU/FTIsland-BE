package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.service.BookContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookContentController {
    private final BookContentService bookContentService;

    @RequestMapping("/saveBookContent")
    public void saveBookContent(){ // DB에 동화 정보 저장
        bookContentService.save();
    }

    @GetMapping("/book/content")
    public List<BookContentDTO> getBookInfoById(@RequestParam Integer bookId){
        return bookContentService.findByBookId(bookId); // 해당 id의 동화 내용 list
    }

}
