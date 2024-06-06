package com.FTIsland.BE.island.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class IslandBooksRequest {
    private Integer userId;
    private Integer islandId;

    @Builder
    public IslandBooksRequest(Integer userId, Integer islandId) {
        this.userId = userId;
        this.islandId = islandId;
    }
}
