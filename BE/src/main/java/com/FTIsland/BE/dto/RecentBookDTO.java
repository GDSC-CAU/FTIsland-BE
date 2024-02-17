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
public class RecentBookDTO {
    private Long userId;
    private Integer bookId;
    private String title;
    private String description;
    private LocalDateTime updatedAt;
    private String image;
}
