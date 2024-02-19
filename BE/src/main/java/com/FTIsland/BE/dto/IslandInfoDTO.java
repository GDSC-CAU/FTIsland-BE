package com.FTIsland.BE.dto;


import com.FTIsland.BE.entity.IslandInfoEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class IslandInfoDTO {
    private Integer id;
    private String name;

    public IslandInfoDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static IslandInfoDTO toIslandInfoDTO(IslandInfoEntity islandInfoEntity) {
        IslandInfoDTO islandInfoDTO = new IslandInfoDTO();
        islandInfoDTO.setId(islandInfoDTO.getId());
        islandInfoDTO.setName(islandInfoDTO.getName());
        return islandInfoDTO;
    }
}
