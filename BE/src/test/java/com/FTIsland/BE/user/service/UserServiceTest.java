package com.FTIsland.BE.user.service;

import com.FTIsland.BE.user.entity.User;
import com.FTIsland.BE.user.repository.UserRepository;
import com.FTIsland.BE.user.dto.UserLanguageRequest;
import com.FTIsland.BE.user.exception.UserException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.FTIsland.BE.user.exception.UserExceptionType.USER_NOT_FOUND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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

            // Then
            assertThatThrownBy(() -> userService.patchUserLanguage(userLanguageRequest))
                    .isInstanceOf(UserException.class)
                    .hasMessage(USER_NOT_FOUND.getMessage());
        }
    }
}