package com.FTIsland.BE.island.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class IslandInfoRequest {
    private Integer id;

    @Builder
    public IslandInfoRequest(Integer id) {
        this.id = id;
    }
}
