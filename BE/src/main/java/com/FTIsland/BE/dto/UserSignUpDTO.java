package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSignUpDTO {
    private String email;
    private String password;
    private String name;
    private boolean isParent;
    private int level;
    private String mainLanguage;
    private String subLanguage;
}
