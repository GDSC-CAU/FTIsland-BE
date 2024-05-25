package com.FTIsland.BE.island.controller;

import com.FTIsland.BE.dto.IslandBooksDTO;
import com.FTIsland.BE.dto.ReadDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.island.dto.IslandInfoDTO;
import com.FTIsland.BE.island.dto.IslandInfoRequest;
import com.FTIsland.BE.island.dto.IslandInfoResponse;
import com.FTIsland.BE.service.BookInfoService;
import com.FTIsland.BE.island.service.IslandInfoService;
import com.FTIsland.BE.service.ReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IslandInfoController {
    private final IslandInfoService islandInfoService;
    private final BookInfoService bookInfoService;
    private final ReadService readService;

    @GetMapping("/island/info")
    public IslandInfoResponse getIslandInfoById(@RequestBody IslandInfoRequest islandInfoRequest) {
        return islandInfoService.findById(islandInfoRequest);
    }

    @PostMapping("/book/progress")
    public List<ReadDTO> getBookInfoWithRead(@RequestBody IslandBooksDTO islandBooksDTO) {
        return readService.progress(islandBooksDTO);
    }

    @PostMapping("/island/books")
    public List<IslandBooksDTO> getBookInfoByislandId(@RequestBody IslandBooksDTO islandBooksDTO) {
        // 만약 userId가 -1이라면 비회원이므로 book info db를 island id로 검색한 결과만 리턴
        // 비회원인 경우 반환 정상
        List<IslandBooksDTO> islandBooksDTOList = new ArrayList<>();
        List<Optional<BookInfoEntity>> bookInfoEntityList = bookInfoService.findNameByIslandId(islandBooksDTO.getIslandId());

        // IslandBooksDTO로 변환해서 list로 리턴

        for (Optional<BookInfoEntity> bookInfoEntityOptional : bookInfoEntityList) {
            bookInfoEntityOptional.ifPresent(bookInfoEntity -> {
                IslandBooksDTO dto = new IslandBooksDTO(
                        islandBooksDTO.getUserId(), // 비회원일 경우 userId는 -1로 설정
                        bookInfoEntity.getId(),
                        islandBooksDTO.getIslandId(),
                        bookInfoEntity.getTitle(),
                        bookInfoEntity.getDescription(),
                        bookInfoEntity.getCategory(),
                        bookInfoEntity.getCountry(),
                        bookInfoEntity.getTotalPage(),
                        bookInfoEntity.getImage(),
                        0.00f
                );

                islandBooksDTOList.add(dto);

            });
        }
        return islandBooksDTOList;
    }
}
