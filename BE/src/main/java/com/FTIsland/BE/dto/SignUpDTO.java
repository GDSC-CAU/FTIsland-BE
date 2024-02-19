package com.FTIsland.BE.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SignUpDTO {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,16}$", message = "아이디는 영문 소문자/숫자로 이루어진 4~16자여야 합니다.")

    private String inputId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 영문 대/소문자, 숫자, 특수 문자로 이루어진 8~16자여야 합니다.")
    private String inputPassword;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "주언어 설정은 필수입니다.")
    private String mainLanguage;

    @NotBlank(message = "보조언어 설정은 필수입니다.")
    private String subLanguage;

    public SignUpDTO(String inputId, String inputPassword, String name, String mainLanguage, String subLanguage) {
        this.inputId = inputId;
        this.inputPassword = inputPassword;
        this.name = name;
        this.mainLanguage = mainLanguage;
        this.subLanguage = subLanguage;
    }
}
