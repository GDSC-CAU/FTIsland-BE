package com.FTIsland.BE.island.service;

import com.FTIsland.BE.island.dto.IslandInfoRequest;
import com.FTIsland.BE.island.dto.IslandInfoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IslandInfoServiceTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private IslandInfoService islandInfoService;

    @Test
    @DisplayName("섬 정보 불러오기 서비스 테스트")
    void getIslandInfo() {
        // given
        Integer id = 1;
        // when
        IslandInfoRequest request = new IslandInfoRequest().builder().id(id).build();
        IslandInfoResponse islandInfoResponse =  islandInfoService.findById(request);
        assertThat(islandInfoResponse.getId()).isEqualTo(1);
        assertThat(islandInfoResponse.getName()).isEqualTo("지혜");
    }
}