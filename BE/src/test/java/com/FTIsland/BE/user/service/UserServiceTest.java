package com.FTIsland.BE.user.service;

import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import com.FTIsland.BE.user.dto.UserLanguageRequest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Nested
    class 사용자_언어_설정_업데이트 {
        @Test
        void 정상적으로_사용자_언어_설정_업데이트() {
            // given
            Integer userId = 1;
            String afterMainLanguage = "jn";
            String afterSubLanguage = "ch";

            UserLanguageRequest userLanguageRequest = new UserLanguageRequest().builder()
                    .userId(userId).mainLanguage(afterMainLanguage).subLanguage(afterSubLanguage).build();

            User user = mock(User.class);

            // when
            when(userRepository.findById(userId)).thenReturn(Optional.of(user));

            userService.patchUserLanguage(userLanguageRequest);

            // then
            verify(userRepository).findById(userId);
            verify(user).updateLanguage(userLanguageRequest);
        }

        @Test
        void 사용자가_없는_경우_예외처리() {
            // given
            Integer userId = 200000;
            String afterMainLanguage = "jn";
            String afterSubLanguage = "ch";
            UserLanguageRequest userLanguageRequest = new UserLanguageRequest()
                    .builder().userId(userId).mainLanguage(afterMainLanguage).subLanguage(afterSubLanguage).build();

            // when
            when(userRepository.findById(userId)).thenReturn(Optional.empty());

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                userService.patchUserLanguage(userLanguageRequest);
            });

            // Then
            assertEquals("User Not Found", exception.getMessage());
            verify(userRepository).findById(userId);
        }
    }
}