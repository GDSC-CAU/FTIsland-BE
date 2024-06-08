package com.FTIsland.BE.book.content.controller;

import com.FTIsland.BE.book.content.service.BookContentService;
import com.FTIsland.BE.book.content.dto.BookContentRequest;
import com.FTIsland.BE.book.content.dto.BookContentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookContentController {
    private final BookContentService bookContentService;

    @PostMapping("/book/content")
    public List<BookContentResponse> getBookInfoById(@RequestBody BookContentRequest bookContentRequest){
        return bookContentService.findByBookId(bookContentRequest); // 해당 id의 동화 내용 list
    }

}
