package com.FTIsland.BE.island.service;

import com.FTIsland.BE.book.info.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IslandBooksService {

    private final BookInfoRepository bookInfoRepository;

    @Transactional
    public List<BookInfoEntity> findBookInfoByIslandId(Integer islandId) {
        return bookInfoRepository.findByIslandInfoEntityId(islandId);
    }
}
