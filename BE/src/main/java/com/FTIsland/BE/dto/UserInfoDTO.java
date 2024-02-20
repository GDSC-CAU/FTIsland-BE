package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserInfoDTO {
    private Integer userId;
    private String name;
    private String mainLanguage;
    private String subLanguage;

    public UserInfoDTO(Integer userId, String name, String mainLanguage, String subLanguage){
        this.userId = userId;
        this.name = name;
        this.mainLanguage = mainLanguage;
        this.subLanguage = subLanguage;
    }

}
