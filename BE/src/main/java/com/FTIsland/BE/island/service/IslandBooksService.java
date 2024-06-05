package com.FTIsland.BE.island.service;

import com.FTIsland.BE.island.entity.BookInfoEntity;
import com.FTIsland.BE.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IslandBooksService {

    private final BookInfoRepository bookInfoRepository;

    @Transactional
    public List<Optional<BookInfoEntity>> findNameByIslandId(Integer islandId) {
        List<Optional<BookInfoEntity>> bookInfoEntityList = bookInfoRepository.findByIslandId(islandId);
        return bookInfoEntityList;

    }
}
