package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookContentDTO {
    private String book;
    private Integer page;
    private String mainContents;
    private String subContents;
    private String image;

    public BookContentDTO(String book, Integer page, String mainContents, String subContents, String image){
        this.book = book;
        this.page = page;
        this.mainContents = mainContents;
        this.subContents = subContents;
        this.image = image;
    }
}


