package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SignUpDTO {
    private String inputId;
    private String inputPassword;
    private String name;
    private String mainLanguage;
    private String subLanguage;

    public SignUpDTO(String inputId, String inputPassword, String name, String mainLanguage, String subLanguage) {
        this.inputId = inputId;
        this.inputPassword = inputPassword;
        this.name = name;
        this.mainLanguage = mainLanguage;
        this.subLanguage = subLanguage;
    }
}
