package com.FTIsland.BE.controller;


import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.service.BookInfoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookInfoController {
    private final BookInfoService bookInfoService;

    @GetMapping("/book/info")
    public BookInfoDTO getBookInfoById(@RequestParam Integer bookId){
        return bookInfoService.findById(bookId); // 해당 id의 동화가 있다면 DTO, 없다면 null return
    }

}
