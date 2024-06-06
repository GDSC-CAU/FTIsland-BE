package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.island.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookInfoService {
    private final BookInfoRepository bookInfoRepository;

    public BookInfoDTO findById(Integer id) {
        Optional<BookInfoEntity> byId = bookInfoRepository.findById(id);
        if(byId.isPresent()){
            BookInfoEntity bookInfoEntity = byId.get();
            BookInfoDTO bookInfoDTO = BookInfoDTO.toBookInfoDTO(bookInfoEntity);
            return bookInfoDTO;
        } else {
            return null;
        }
    }

    public String findNameById(Integer id) {
        Optional<BookInfoEntity> byId = bookInfoRepository.findById(id);
        if(byId.isPresent()){
            BookInfoEntity bookInfoEntity = byId.get();
            String bookTitle = bookInfoEntity.getTitle();
            return bookTitle;
        } else {
            return null;
        }
    }

    public List<BookInfoEntity> findBookInfoByIslandId(Integer islandId) {
        List<BookInfoEntity> bookInfoEntityList = bookInfoRepository.findByIslandInfoEntityId(islandId);
        return bookInfoEntityList;
    }

    public String findDescriptionByBookId(Integer bookId) {
        Optional<BookInfoEntity> bookInfoEntity = bookInfoRepository.findById(bookId);
        if(bookInfoEntity.isPresent()){
            return bookInfoEntity.get().getDescription();
        }
        return null;
    }
}
