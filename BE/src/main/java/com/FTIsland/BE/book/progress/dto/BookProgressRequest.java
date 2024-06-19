package com.FTIsland.BE.book.progress.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookProgressRequest {
    private Integer userId;
    private Integer islandId;

    @Builder
    public BookProgressRequest(Integer userId, Integer islandId) {
        this.userId = userId;
        this.islandId = islandId;
    }
}
