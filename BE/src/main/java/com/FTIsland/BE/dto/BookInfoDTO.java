package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookInfoDTO {
    private Integer id;
    private String title;
    private String description;
    private String category;
    private String country;
    private Integer totalPage;
    private String image;
}
