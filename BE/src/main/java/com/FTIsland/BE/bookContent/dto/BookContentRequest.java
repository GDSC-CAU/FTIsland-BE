package com.FTIsland.BE.bookContent.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookContentRequest {
    private Integer bookId; // BookInfo에 title 있음.
    private String mainLan;
    private String subLan;

    @Builder
    public BookContentRequest(Integer bookId, String mainLan, String subLan){
        this.bookId = bookId;
        this.mainLan = mainLan;
        this.subLan = subLan;
    }
}


