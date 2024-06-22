package com.FTIsland.BE.user.service;

import com.FTIsland.BE.user.dto.UserLanguageRequest;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService { // 자체 로그인 회원 가입 시 사용하는 회원 가입 API의 로직
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    // client에서 받은 access token을 이용해 id의 list를 반환한다.
//    public Long getUserId(String email) {
//        List<Integer> userIds;
//        Optional<User> user = userRepository.findByEmail(email);
//
//        return user.get().getId();
//    }


    public Integer findLevelById(Integer userId){
        Optional<User> byId = userRepository.findById(userId);
        if(byId.isPresent()){
            User userInfo = byId.get();
            return userInfo.getLevel();
        } else { // 해당 유저가 존재하지 않을 때
            return null;
        }
    }

    @Transactional
    public void patchUserLanguage(UserLanguageRequest userLanguageRequest) {
        User user = userRepository.findById(userLanguageRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.updateLanguage(userLanguageRequest);
    }
}
