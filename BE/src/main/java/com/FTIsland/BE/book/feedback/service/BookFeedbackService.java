package com.FTIsland.BE.book.feedback.service;

import com.FTIsland.BE.book.feedback.dto.BookFeedbackRequest;
import com.FTIsland.BE.dto.ResponseDTO;
import com.FTIsland.BE.user.entity.User;
import com.FTIsland.BE.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.FTIsland.BE.book.feedback.entity.Level.LEVEL_NINE;
import static com.FTIsland.BE.book.feedback.entity.Level.LEVEL_THREE;
import static com.FTIsland.BE.book.feedback.entity.Feedback.FEEDBACK_ZERO;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookFeedbackService {

    private final UserRepository userRepository;

    @Transactional
    public ResponseDTO updateLevel(BookFeedbackRequest bookFeedbackRequest) {

        Integer userId = bookFeedbackRequest.getUserId();
        Integer feedback = bookFeedbackRequest.getFeedback();

        User user = userRepository.findById(userId).orElse(null);

        /*
         * (예외) 사용자가 없는 경우
         */
        if (user == null) {
            return new ResponseDTO<>(HttpServletResponse.SC_NOT_FOUND, "사용자를 찾을 수 없습니다.", null);
        }

        /*
         * 피드백 업데이트
         */

        // (예외) 레벨이 3이고 음수를 입력받은 경우
        if(user.getLevel() == LEVEL_THREE && feedback < FEEDBACK_ZERO) {
            return new ResponseDTO<>(HttpServletResponse.SC_OK, "", null);
        }

        // (예외) 유저 레벨이 9이고 양수를 입력받은 경우
        else if(user.getLevel() == LEVEL_NINE && feedback > FEEDBACK_ZERO) {
            return new ResponseDTO<>(HttpServletResponse.SC_OK, "", null);
        }

        user.updateLevel(user.getLevel() + feedback);
        return new ResponseDTO<>(HttpServletResponse.SC_OK, "피드백 업데이트를 완료했습니다.", null);
    }
}
