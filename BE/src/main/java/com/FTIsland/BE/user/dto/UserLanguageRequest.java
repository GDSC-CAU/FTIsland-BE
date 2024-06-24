package com.FTIsland.BE.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class UserLanguageRequest {
    private Integer userId;
    private String mainLanguage;
    private String subLanguage;

    @Builder
    public UserLanguageRequest(Integer userId, String mainLanguage, String subLanguage) {
        this.userId = userId;
        this.mainLanguage = mainLanguage;
        this.subLanguage = subLanguage;
    }
}
