package com.FTIsland.BE.island.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class IslandBooksResponse {
    private Integer userId;
    private Integer bookId;
    private Integer islandId;
    private String title;
    private String description;
    private String category;
    private String country;
    private Integer totalPage;
    private String image;
    // private float progress;

    @Builder
    public IslandBooksResponse(Integer userId, Integer bookId, Integer islandId, String title, String description,
                               String category, String country, Integer totalPage, String image) {
        this.userId = userId;
        this.bookId = bookId;
        this.islandId = islandId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.country = country;
        this.totalPage = totalPage;
        this.image = image;
        // this.progress = progress;
    }
}

