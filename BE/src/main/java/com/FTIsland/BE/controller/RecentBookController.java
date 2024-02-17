package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.RecentBookDTO;
import com.FTIsland.BE.service.RecentBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecentBookController {
    private final RecentBookService recentBookService;

    @PostMapping("/book/recent-books")
    public List<RecentBookDTO> findRecentBooks(@RequestBody RecentBookDTO recentBookDTO){
        return recentBookService.findByUserId(recentBookDTO);
    }
}
