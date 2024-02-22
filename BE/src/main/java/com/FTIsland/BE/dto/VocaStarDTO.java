package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VocaStarDTO {
    private Integer userId;
    private Integer vocaId;
    private Boolean isStar;
}
