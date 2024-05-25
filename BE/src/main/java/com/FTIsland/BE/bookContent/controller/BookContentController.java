package com.FTIsland.BE.bookContent.controller;

import com.FTIsland.BE.bookContent.dto.BookContentRequest;
import com.FTIsland.BE.bookContent.dto.BookContentResponse;
import com.FTIsland.BE.dto.BookContentDTO;
import com.FTIsland.BE.service.BookContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/book/content")
    public List<BookContentResponse> getBookInfoById(@RequestBody BookContentRequest bookContentRequest){
        return bookContentService.findByBookId(bookContentRequest); // 해당 id의 동화 내용 list
    }

}
