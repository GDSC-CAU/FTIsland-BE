package com.FTIsland.BE.island.dto;

import com.FTIsland.BE.island.entity.IslandInfoEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class IslandInfoRequest {
    private Integer id;

    @Builder
    public IslandInfoRequest(Integer id) {
        this.id = id;
    }
}
