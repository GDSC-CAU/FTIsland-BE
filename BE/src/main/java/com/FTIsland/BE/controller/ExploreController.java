package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.ExploreDTO;
import com.FTIsland.BE.service.ExploreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ExploreController {
    private final ExploreService exploreService;

    @PostMapping("/book/explore")
    public ExploreDTO getReadInfoForExplore(@RequestBody ExploreDTO exploreDTO){
        return exploreService.explore(exploreDTO);
    }
}
