package com.FTIsland.BE.island.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class IslandInfoRequest {
    private Integer id;

    @Builder
    public IslandInfoRequest(Integer id) {
        this.id = id;
    }
}
