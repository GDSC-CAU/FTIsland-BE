package com.FTIsland.BE.book.progress.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IslandBooksRequest {
    private Integer userId;
    private Integer bookId;
    private Integer islandId;
    private String title;
    private String description;
    private String category;
    private String country;
    private Integer totalPage;
    private String image;
    private float progress;

    @Builder
    public IslandBooksRequest(Integer userId, Integer bookId, Integer islandId, String title, String description,
                          String category, String country, Integer totalPage, String image, float progress) {
        this.userId = userId;
        this.bookId = bookId;
        this.islandId = islandId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.country = country;
        this.totalPage = totalPage;
        this.image = image;
        this.progress = progress;
    }

}
