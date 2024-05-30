package com.FTIsland.BE.island.controller;

import com.FTIsland.BE.dto.IslandBooksDTO;
import com.FTIsland.BE.dto.ReadDTO;
import com.FTIsland.BE.island.dto.IslandInfoRequest;
import com.FTIsland.BE.island.dto.IslandInfoResponse;
import com.FTIsland.BE.service.BookInfoService;
import com.FTIsland.BE.island.service.IslandInfoService;
import com.FTIsland.BE.service.ReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IslandInfoController {
    private final IslandInfoService islandInfoService;
    private final ReadService readService;

    @GetMapping("/island/info")
    public IslandInfoResponse getIslandInfoById(@RequestBody IslandInfoRequest islandInfoRequest) {
        return islandInfoService.findById(islandInfoRequest);
    }

    @PostMapping("/book/progress")
    public List<ReadDTO> getBookInfoWithRead(@RequestBody IslandBooksDTO islandBooksDTO) {
        return readService.progress(islandBooksDTO);
    }
}
