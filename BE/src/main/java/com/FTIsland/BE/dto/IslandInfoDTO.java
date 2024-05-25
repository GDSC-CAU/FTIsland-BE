package com.FTIsland.BE.dto;


import com.FTIsland.BE.entity.IslandInfoEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class IslandInfoDTO {
    private Integer id;
    private String name;

    @Builder
    public IslandInfoDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public IslandInfoEntity toEntity() {
        return IslandInfoEntity.builder().id(id).name(name).build();
    }

    public static IslandInfoDTO toIslandInfoDTO(IslandInfoEntity islandInfoEntity) {
        IslandInfoDTO islandInfoDTO = new IslandInfoDTO();
        islandInfoDTO.setId(islandInfoDTO.getId());
        islandInfoDTO.setName(islandInfoDTO.getName());
        return islandInfoDTO;
    }
}
