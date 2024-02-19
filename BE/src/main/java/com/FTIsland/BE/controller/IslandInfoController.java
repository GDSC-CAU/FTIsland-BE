package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.dto.IslandBooksDTO;
import com.FTIsland.BE.dto.IslandInfoDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.entity.ReadEntity;
import com.FTIsland.BE.service.BookInfoService;
import com.FTIsland.BE.service.IslandInfoService;
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
            List<Optional<BookInfoEntity>> bookInfoEntityList = bookInfoService.findNameByIslandId(islandBooksDTO.getIslandId());
            log.info(String.valueOf(bookInfoEntityList.size()));

            List<Optional<ReadEntity>> readEntityList = new ArrayList<>();
            // IslandBooksDTO로 변환해서 list로 리턴
            for (Optional<BookInfoEntity> bookInfoEntityOptional : bookInfoEntityList) {
                // bookInfoEntityOptional로 넘어온 bookId와, islandBooksDTO로 넘어온 userId를 이용해 read table을 검색
                // 이때 book Id는 이미 island에 해당하는 bookId만을 고른 것임

                Integer userId = islandBooksDTO.getUserId();
                Integer bookId = bookInfoEntityOptional.get().getId();
                if (bookId != null) {
                     readEntityList.add(readService.findByUserIdAndBookId(userId, bookId));
                }

            }
            log.info("readentitylist" + String.valueOf(readEntityList.size()));

            // readEntityList에 있는 정보들을 islandBooksDTOList로 바꿔서 변환
            for(Optional<ReadEntity> readEntityOptional : readEntityList) {

                Integer bookId = readEntityOptional.get().getBookId();
                BookInfoDTO bookEntityOptional = bookInfoService.findById(bookId);
                log.info(bookEntityOptional.getTitle());
                log.info(String.valueOf(readEntityOptional.get().getOffset()));

                readEntityOptional.ifPresent(readEntity -> {
                    IslandBooksDTO dto = new IslandBooksDTO(
                            islandBooksDTO.getUserId(), // 비회원일 경우 userId는 -1로 설정
                            readEntity.getId(),
                            islandBooksDTO.getIslandId(),
                            bookEntityOptional.getTitle(),
                            bookEntityOptional.getDescription(),
                            bookEntityOptional.getCategory(),
                            bookEntityOptional.getCountry(),
                            bookEntityOptional.getTotalPage(),
                            bookEntityOptional.getImage(),
                            0.00f
                    );
                    // progress 계산
                    float progressCal = (readEntity.getOffset() + 1) * readEntity.getLimitNum();
                    dto.setProgress(progressCal);
                    islandBooksDTOList.add(dto);
                });
            }
            log.info(String.valueOf(islandBooksDTOList.size()));
            return islandBooksDTOList;
        }
    }
}
