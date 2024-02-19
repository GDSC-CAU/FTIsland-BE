package com.FTIsland.BE.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginDTO {
    public String inputId;
    public String inputPassword;

    public LoginDTO(String inputId, String inputPassword) {
        this.inputId = inputId;
        this.inputPassword = inputPassword;
    }

}
