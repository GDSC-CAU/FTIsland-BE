package com.FTIsland.BE.island.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Table(name = "islandinfo")
@NoArgsConstructor
public class IslandInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Builder
    public IslandInfoEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "islandinfo")
    private List<BookInfoEntity> bookInfos;
}
