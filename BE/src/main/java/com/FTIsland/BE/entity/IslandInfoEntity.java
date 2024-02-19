package com.FTIsland.BE.entity;

import com.FTIsland.BE.dto.IslandInfoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "islandinfo")
public class IslandInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public static IslandInfoEntity toIslandInfoEntity(IslandInfoDTO islandInfoDTO) {
        IslandInfoEntity islandInfoEntity = new IslandInfoEntity();
        islandInfoEntity.setId(islandInfoDTO.getId());
        islandInfoEntity.setName(islandInfoDTO.getName());
        return islandInfoEntity;
    }
}
