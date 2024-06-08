package com.FTIsland.BE.island.service;

import com.FTIsland.BE.book.info.entity.BookInfoEntity;
import com.FTIsland.BE.island.entity.Island;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class IslandBooksServiceTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private IslandBooksService islandBooksService;

    @Test
    @DisplayName("섬 동화 정보 불러오기 서비스 테스트")
    void 섬_동화_정보_불러오기() {
        // given
        Integer islandId = 1;

        // when
        List<BookInfoEntity> bookInfoEntities = islandBooksService.findBookInfoByIslandId(islandId);

        // then
        assertThat(bookInfoEntities.size()).isEqualTo(Island.BOOKS_PER_ISLAND.getBooks_per_island());
    }
}