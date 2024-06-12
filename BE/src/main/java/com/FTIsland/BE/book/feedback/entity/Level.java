package com.FTIsland.BE.book.feedback.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Level {
    public static final Integer LEVEL_ONE = 1;
    public static final Integer LEVEL_TWO = 2;
    public static final Integer LEVEL_THREE = 3;
    public static final Integer LEVEL_FOUR = 4;
    public static final Integer LEVEL_FIVE = 5;
    public static final Integer LEVEL_SIX = 6;
    public static final Integer LEVEL_SEVEN = 7;
    public static final Integer LEVEL_EIGHT = 8;
    public static final Integer LEVEL_NINE = 9;

    public final Integer level;

    @Builder
    public Level(Integer level) {
        this.level = level;
    }
}
