package com.FTIsland.BE.island.controller;

import com.FTIsland.BE.dto.IslandBooksDTO;
import com.FTIsland.BE.island.dto.IslandBooksRequest;
import com.FTIsland.BE.island.entity.BookInfoEntity;
import com.FTIsland.BE.island.dto.IslandBooksResponse;
import com.FTIsland.BE.service.BookInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IslandBooksController {

    private final BookInfoService bookInfoService;

    @GetMapping("/island/books")
    public List<IslandBooksResponse> getBookInfoByIslandId(@RequestBody IslandBooksRequest islandBooksRequest) {
        // userId가 -1이라면 비회원이므로 book info db를 island id로 검색한 결과만 리턴
        // 비회원인 경우 반환 정상

        List<BookInfoEntity> bookInfoEntityList = bookInfoService.findBookInfoByIslandId(islandBooksRequest.getIslandId());
        List<IslandBooksResponse> collect = bookInfoEntityList
                .stream()
                .map(m -> new IslandBooksResponse().builder()
                        .bookId(m.getId())
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