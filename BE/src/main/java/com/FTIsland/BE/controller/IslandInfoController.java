package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.IslandInfoDTO;
import com.FTIsland.BE.service.IslandInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IslandInfoController {
    private final IslandInfoService islandInfoService;

    @RequestMapping("/saveIslandInfo")
    public void saveIslandInfo() {islandInfoService.save();}

    @GetMapping("/island/info")
    public IslandInfoDTO getIslandInfoById(@RequestParam Integer islandId) {
        return islandInfoService.findById(islandId);
    }
}
