package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.UserSignUpDTO;
import com.FTIsland.BE.entity.Role;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService { // 자체 로그인 회원 가입 시 사용하는 회원 가입 API의 로직
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpDTO userSignUpDto) throws Exception {

        if (userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if (userRepository.findByName(userSignUpDto.getName()).isPresent()) {
            throw new Exception("이미 존재하는 이름입니다.");
        }

        User user = User.builder()
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .name(userSignUpDto.getName())
                .isParent(userSignUpDto.isParent())
                .level(userSignUpDto.getLevel())
                .mainLanguage(userSignUpDto.getMainLanguage())
                .subLanguage(userSignUpDto.getSubLanguage())
                .role(Role.USER)
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }

}
