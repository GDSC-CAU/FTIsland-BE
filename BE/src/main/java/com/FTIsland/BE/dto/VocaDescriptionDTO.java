package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VocaDescriptionDTO {
    private String word;
    private String description;
    private String bookName;

    public VocaDescriptionDTO(String word, String description, String bookName){
        this.word = word;
        this.description = description;
        this.bookName = bookName;
    }
}
