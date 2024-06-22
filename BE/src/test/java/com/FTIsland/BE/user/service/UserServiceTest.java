package com.FTIsland.BE.user.service;

import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import com.FTIsland.BE.response.ResponseEntity;
import com.FTIsland.BE.user.dto.UserLanguageRequest;
import org.apache.coyote.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    User user = new User().builder()
            .name("테스트 회원")
            .inputId("testId")
            .inputPassword("testPassword")
            .mainLanguage("ko")
            .subLanguage("en")
            .level(4)
            .build();

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(user);
    }

    @Test
    @DisplayName("사용자 언어 설정 서비스 테스트")
    void 사용자_언어_설정_업데이트() {
        // given
        Integer userId = user.getId();;
        String afterMainLanguage = "jn";
        String afterSubLanguage = "ch";

        UserLanguageRequest userLanguageRequest = new UserLanguageRequest().builder()
                .userId(userId).mainLanguage(afterMainLanguage).subLanguage(afterSubLanguage).build();

        // when
        userService.patchUserLanguage(userLanguageRequest);

        // then

    }
}