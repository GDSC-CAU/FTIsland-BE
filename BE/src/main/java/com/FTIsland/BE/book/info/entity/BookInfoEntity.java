package com.FTIsland.BE.book.info.entity;

import com.FTIsland.BE.base.BaseEntity;
import com.FTIsland.BE.island.entity.IslandInfoEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "bookinfo")
@NoArgsConstructor
@ToString
public class BookInfoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private String country;

    @Column
    private Integer totalPage;

    @Column
    private String image;

    @Builder
    public BookInfoEntity (Integer id, String title, String description, String category, String country, Integer totalPage, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.country = country;
        this.totalPage = totalPage;
        this.image = image;
    }

    @ManyToOne
    @JoinColumn(name = "islandId", referencedColumnName = "id")
    private IslandInfoEntity islandInfoEntity;

}
