package com.FTIsland.BE.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ExploreDTO {
    private Long userId;
    private Integer bookId;
    private Boolean read;
    private Integer offset;
    private Integer limit;
}
