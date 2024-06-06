package com.FTIsland.BE.island.controller;

import com.FTIsland.BE.island.dto.IslandBooksRequest;
import com.FTIsland.BE.island.entity.BookInfoEntity;
import com.FTIsland.BE.island.dto.IslandBooksResponse;
import com.FTIsland.BE.island.service.IslandBooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IslandBooksController {

    private final IslandBooksService islandBooksService;

    @GetMapping("/island/books")
    public List<IslandBooksResponse> getBookInfoByIslandId(@RequestBody IslandBooksRequest islandBooksRequest) {

        List<BookInfoEntity> bookInfoEntityList = islandBooksService.findBookInfoByIslandId(islandBooksRequest.getIslandId());
        List<IslandBooksResponse> collect = bookInfoEntityList
                .stream()
                .map(m -> new IslandBooksResponse().builder()
                        .userId(islandBooksRequest.getUserId())
                        .bookId(m.getId())
                        .islandId(m.getId())
                        .title(m.getTitle())
                        .description(m.getDescription())
                        .category(m.getCategory())
                        .country(m.getCountry())
                        .totalPage(m.getTotalPage())
                        .image(m.getImage())
                        .build())
                .toList();

        return collect;
    }
}
