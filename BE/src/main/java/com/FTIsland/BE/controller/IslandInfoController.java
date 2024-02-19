package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.dto.IslandBooksDTO;
import com.FTIsland.BE.dto.IslandInfoDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.service.BookInfoService;
import com.FTIsland.BE.service.IslandInfoService;
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

    @RequestMapping("/saveIslandInfo")
    public void saveIslandInfo() {islandInfoService.save();}

    @GetMapping("/island/info")
    public IslandInfoDTO getIslandInfoById(@RequestParam Integer islandId) {
        return islandInfoService.findById(islandId);
    }

    @PostMapping("/island/books")
    public List<IslandBooksDTO> getBookInfoByislandId(@RequestBody IslandBooksDTO islandBooksDTO) {
        // 만약 userId가 -1이라면 비회원이므로 book info db를 island id로 검색한 결과만 리턴
        List<IslandBooksDTO> islandBooksDTOList = new ArrayList<>();
        if(islandBooksDTO.getUserId() < 0) {
            List<Optional<BookInfoEntity>> bookInfoEntityList = bookInfoService.findNameByIslandId(islandBooksDTO.getIslandId());

            // IslandBooksDTO로 변환해서 list로 리턴
            // IslandBooksDTO로 변환해서 list로 리턴

            for (Optional<BookInfoEntity> bookInfoEntityOptional : bookInfoEntityList) {
                bookInfoEntityOptional.ifPresent(bookInfoEntity -> {
                    IslandBooksDTO dto = new IslandBooksDTO(
                            -1, // 비회원일 경우 userId는 -1로 설정
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
        
        // 회원인 경우 read table에서 검색해야 함
        else {

        }
        return islandBooksDTOList;
    }
}
