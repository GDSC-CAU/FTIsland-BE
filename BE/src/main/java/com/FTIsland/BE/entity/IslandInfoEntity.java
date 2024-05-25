package com.FTIsland.BE.entity;

import com.FTIsland.BE.dto.IslandInfoDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "islandinfo")
@NoArgsConstructor
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

    @Builder
    public IslandInfoEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
