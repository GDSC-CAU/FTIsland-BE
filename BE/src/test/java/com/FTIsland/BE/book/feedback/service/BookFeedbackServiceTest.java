package com.FTIsland.BE.book.feedback.service;

import com.FTIsland.BE.book.feedback.dto.BookFeedbackRequest;
import com.FTIsland.BE.dto.ResponseDTO;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.FTIsland.BE.book.feedback.entity.Feedback.FEEDBACK_MINUS_ONE;
import static net.bytebuddy.implementation.bytecode.constant.IntegerConstant.MINUS_ONE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookFeedbackServiceTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookFeedbackService bookFeedbackService;

    User user = new User().builder()
            .name("테스트 회원")
            .inputId("testId")
            .inputPassword("testPassword")
            .level(4)
            .build();

    @BeforeEach
    void setUp() {
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(user);
    }

    @Test
    @DisplayName("동화 난이도 피드백 서비스 테스트")
    void 동화_난이도_피드백_업데이트() {
        // given
        Integer userId = user.getId();
        Integer feedback = FEEDBACK_MINUS_ONE;

        BookFeedbackRequest bookFeedbackRequest
                = new BookFeedbackRequest().builder().userId(userId).feedback(feedback).build();

        // when
        ResponseDTO responseDTO = bookFeedbackService.updateLevel(bookFeedbackRequest);

        // then
        assertThat(responseDTO.getStatus()).isEqualTo(HttpServletResponse.SC_OK);
        assertThat(responseDTO.getMessage()).isEqualTo("피드백 업데이트를 완료했습니다.");
        assertThat(responseDTO.getData()).isEqualTo(null);
    }

}