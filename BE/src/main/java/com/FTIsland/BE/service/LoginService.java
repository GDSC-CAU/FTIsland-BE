package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.LoginDTO;
import com.FTIsland.BE.dto.ResponseDTO;
import com.FTIsland.BE.dto.SignUpDTO;
import com.FTIsland.BE.dto.UserInfoDTO;
import com.FTIsland.BE.entity.ResponseStatus;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    public ResponseDTO save(SignUpDTO signUpDTO) {
        // 사용자가 입력한 id로 User 검색
        log.info(signUpDTO.getInputId());
        List<Optional<User>> users = userRepository.findByInputId(signUpDTO.getInputId());

        // 중복 id가 있으면 duplicated id return
        if (!users.isEmpty()) {
            return new ResponseDTO<>(ResponseStatus.ERROR, "duplicate id", null);
        }

        // 중복 id가 없다면 회원 가입 진행
        User userKid = User.toUserEntity(signUpDTO);
        userKid.setParent(false); // kid 먼저 save
        userKid.setLevel(5);
        userRepository.save(userKid);

        User userParent = User.toUserEntity(signUpDTO);
        userParent.setParent(true); // parent 다음 save
        userParent.setLevel(5);
        userRepository.save(userParent);

        // 회원 가입 후 response dto return
        return new ResponseDTO<>(ResponseStatus.SUCCESS, "ok", null);
    }

    public ResponseDTO login(LoginDTO loginDTO) {
        // 사용자가 입력한 id로 User 검색
        List<Optional<User>> users = userRepository.findByInputId(loginDTO.getInputId());
        log.info(loginDTO.getInputId());
        log.info(String.valueOf(users.size()));

        // inputId가 있으면 정보 가져와서 db의 userId, mainlanguage, sublanguage return
        if(users.size() != 0) {
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUserId(users.get(0).get().getId());
            userInfoDTO.setName(users.get(0).get().getName());
            userInfoDTO.setMainLanguage(users.get(0).get().getMainLanguage());
            userInfoDTO.setSubLanguage(users.get(0).get().getSubLanguage());
            return new ResponseDTO<>(ResponseStatus.SUCCESS, "ok", userInfoDTO);

        } else { // 없으면 ERROR response dto return
            return new ResponseDTO<>(ResponseStatus.ERROR, "not in database", null);

        }
    }

    @Transactional
    public Map<String, String> validateHandling(BindingResult bindingResult) {
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : bindingResult.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }
}
