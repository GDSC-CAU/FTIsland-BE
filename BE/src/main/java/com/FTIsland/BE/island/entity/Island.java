package com.FTIsland.BE.island.entity;

import lombok.Getter;

@Getter
public enum Island {
    BOOKS_PER_ISLAND(4);

    private final Integer books_per_island;

    Island(Integer books_per_island) {
        this.books_per_island = books_per_island;
    }
}
