package com.FTIsland.BE.island.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class IslandBooksRequest {
    private Integer userId;
    private Integer islandId;

    @Builder
    public IslandBooksRequest(Integer userId, Integer islandId) {
        this.userId = userId;
        this.islandId = islandId;
    }
}
