package com.FTIsland.BE.book.progress.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class BookProgressResponse {
    private Integer userId;
    private Integer bookId;
    private Integer lastPage;

    @Builder
    public BookProgressResponse(Integer userId, Integer bookId, Integer lastPage){
        this.userId = userId;
        this.bookId = bookId;
        this.lastPage = lastPage;
    }
}
