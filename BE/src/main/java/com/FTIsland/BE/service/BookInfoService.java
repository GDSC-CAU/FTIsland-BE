package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Optional<BookInfoEntity>> findNameByIslandId(Integer islandId) {
        List<Optional<BookInfoEntity>> bookInfoEntityList = bookInfoRepository.findByIslandId(islandId);
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
