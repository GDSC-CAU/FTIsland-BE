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
    private Long userId;
    private Integer bookId;
    private Integer offset;
    private Integer limit;
    private Float progress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}