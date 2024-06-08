package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookFeedbackDTO;
import com.FTIsland.BE.dto.ResponseDTO;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookFeedbackService {
    private final UserRepository userRepository;
    public ResponseDTO updateLevel(BookFeedbackDTO bookFeedbackDTO) {

        // book feedback dto에는 userId, feedback이 들어있음
        // 비회원인 경우에는 생각해보기 질문을 띄우지 않음
        Integer userId = bookFeedbackDTO.getUserId();
        Integer feedback = bookFeedbackDTO.getFeedback();

        // userId로 사용자 조회
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // 사용자가 존재하지 않으면 오류 응답 반환
            return new ResponseDTO<>(HttpServletResponse.SC_NOT_FOUND, "cannot find user in database", null);
        }

        // 피드백이 있는 경우 레벨 업데이트

        // 유저 레벨이 3이고 음수를 입력받은 경우
        if(user.getLevel() == 3 && feedback < 0) {
            return new ResponseDTO<>(HttpServletResponse.SC_OK, "ok", null);
        }

        // 유저 레벨이 9이고 양수를 입력받은 경우
        else if(user.getLevel() == 9 && feedback >0) {
            return new ResponseDTO<>(HttpServletResponse.SC_OK, "ok", null);
        }

        user.setLevel(user.getLevel() + feedback);
        userRepository.save(user); // 사용자 정보 저장
        return new ResponseDTO<>(HttpServletResponse.SC_OK, "ok", null);

    }
}
