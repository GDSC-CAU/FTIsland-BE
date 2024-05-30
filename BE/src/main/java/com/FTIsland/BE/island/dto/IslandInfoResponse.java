package com.FTIsland.BE.island.dto;

import com.FTIsland.BE.island.entity.IslandInfoEntity;
import lombok.*;

@Getter
@NoArgsConstructor
public class IslandInfoResponse {
    private Integer id;
    private String name;

    @Builder
    public IslandInfoResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public IslandInfoEntity toEntity() {
        return IslandInfoEntity.builder().id(id).name(name).build();
    }
}
