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
    private Integer offset_value;
    private Integer limitNum;
    private Integer lastPage;

    public ReadDTO(Integer userId, Integer bookId, Integer offsetvalue, Integer limitNum, Integer lastPage){
        this.userId = userId;
        this.bookId = bookId;
        this.offset_value = offsetvalue;
        this.limitNum = limitNum;
        this.lastPage = lastPage;
    }
}
