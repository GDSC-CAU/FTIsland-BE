package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VocaDTO {
    private Integer userId;
    private Integer vocaId;
    private String word;
    private String subWord;
    private String image;
}
