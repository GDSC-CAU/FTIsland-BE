package com.FTIsland.BE.entity;

import com.FTIsland.BE.base.BaseEntity;
import com.FTIsland.BE.dto.SignUpDTO;
import com.FTIsland.BE.user.dto.UserLanguageRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@Slf4j
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String inputId;
    private String inputPassword;
    private String name;
    private int level;
    private String mainLanguage;
    private String subLanguage;
    private boolean isParent;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "id")
    private ReadEntity readEntity;

    @Builder
    public User(Integer id, String inputId, String inputPassword, String name, int level, String mainLanguage, String subLanguage, boolean isParent) {
        this.id = id;
        this.inputId = inputId;
        this.inputPassword = inputPassword;
        this.name = name;
        this.level = level;
        this.mainLanguage = mainLanguage;
        this.subLanguage = subLanguage;
        this.isParent = isParent;
    }

    public static User toUserEntity(SignUpDTO signUpDTO) {
        log.info(signUpDTO.getInputPassword());
        User user = new User();
        user.setInputId(signUpDTO.getInputId());
        user.setInputPassword(signUpDTO.getInputPassword());
        user.setName(signUpDTO.getName());
        user.setMainLanguage(signUpDTO.getMainLanguage());
        user.setSubLanguage(signUpDTO.getSubLanguage());
        return user;
    }

    public void update(Integer id, String inputId, String inputPassword, String name, int level, String mainLanguage, String subLanguage, boolean isParent) {
        this.id = id;
        this.inputId = inputId;
        this.inputPassword = inputPassword;
        this.name = name;
        this.level = level;
        this.mainLanguage = mainLanguage;
        this.subLanguage = subLanguage;
        this.isParent = isParent;
    }

    public void updateLevel(int level) {
        this.level = level;
    }

    public void updateLanguage(final UserLanguageRequest userLanguageRequest) {
        this.mainLanguage = userLanguageRequest.getMainLanguage();
        this.subLanguage = userLanguageRequest.getSubLanguage();
    }
}