package com.FTIsland.BE.service;

import com.FTIsland.BE.island.dto.IslandInfoDTO;
import com.FTIsland.BE.island.service.IslandInfoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IslandInfoServiceTest {

    @Autowired
    private IslandInfoService islandInfoService;

    @Test
    @DisplayName("섬 정보 불러오기 테스트")
    void getIslandInfo() {
        IslandInfoDTO islandInfoDTO =  islandInfoService.findById(1);
        assertThat(islandInfoDTO.getId()).isEqualTo(1);
        assertThat(islandInfoDTO.getName()).isEqualTo("지혜");
    }
}