package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReadDTO {
    private Integer userId;
    private Integer bookId;
    private Integer offset;
    private Integer limitNum;
    // private Float progress;
    private Integer lastPage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ReadDTO(Integer userId, Integer bookId, Integer offset, Integer limitNum, Integer lastPage){
        this.userId = userId;
        this.bookId = bookId;
        this.offset = offset;
        this.limitNum = limitNum;
        this.lastPage = lastPage;
    }
}
