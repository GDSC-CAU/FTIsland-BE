package com.FTIsland.BE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@Table(name = "user")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String email;
    private String picture;
    private boolean isParent;

    // 이후 OAuth2 로그인 성공 시 추가 정보를 입력하는 폼으로 이동하도록 구현
    private int level;
    private String mainLanguage;
    private String subLanguage;

    // Enum 타입은 문자열 형태로 저장해야 함
    // 첫 로그인 시에 Role을 Guest로 설정, 추가 정보 입력 후 User로 업데이트
    @Enumerated(EnumType.STRING)
    private Role role;

    // JWT RefreshToken 필드
    // JWT를 이용해 로그인 성공 시 AccessToken, RefreshToken을 발행하는데
    // 발행된 RefreshToken을 User entity에 저장
    private String refreshToken;

    // user 권한 설정
    public void authorizeUser() {
        this.role = Role.USER;
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }

//    @Builder
//    public User(String name, String email, String picture, Role role,
//                boolean isParent, int level, String mainLanguage, String subLanguage) {
//        this.name = name;
//        this.email = email;
//        this.picture = picture;
//        this.role = role;
//        this.isParent = isParent;
//        this.level = level;
//        this.mainLanguage = mainLanguage;
//        this.subLanguage = subLanguage;
//    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}