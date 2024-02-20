package com.FTIsland.BE.dto;

import com.FTIsland.BE.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserLanguageDTO {
    private Integer userId;
    private String mainLanguage;
    private String subLanguage;

    public UserLanguageDTO(Integer userId, String mainLanguage, String subLanguage) {
        this.userId = userId;
        this.mainLanguage = mainLanguage;
        this.subLanguage = subLanguage;
    }
}
