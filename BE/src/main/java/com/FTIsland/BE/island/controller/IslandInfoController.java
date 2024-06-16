package com.FTIsland.BE.island.controller;

import com.FTIsland.BE.island.dto.IslandInfoRequest;
import com.FTIsland.BE.island.dto.IslandInfoResponse;
import com.FTIsland.BE.island.service.IslandInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IslandInfoController {
    private final IslandInfoService islandInfoService;

    @GetMapping("/island/info")
    public IslandInfoResponse getIslandInfoById(@RequestBody IslandInfoRequest islandInfoRequest) {
        return islandInfoService.findById(islandInfoRequest);
    }
}
