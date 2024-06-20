package com.FTIsland.BE.island.entity;

import com.FTIsland.BE.base.BaseEntity;
import com.FTIsland.BE.book.info.entity.BookInfoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "islandinfo")
@NoArgsConstructor
public class IslandInfoEntity extends BaseEntity {
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

    @OneToMany(mappedBy = "islandInfoEntity")
    private List<BookInfoEntity> bookInfoEntities = new ArrayList<>();


}
