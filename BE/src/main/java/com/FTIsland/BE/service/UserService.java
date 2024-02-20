package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookInfoDTO;
import com.FTIsland.BE.dto.QuizDTO;
import com.FTIsland.BE.dto.UserLanguageDTO;
import com.FTIsland.BE.entity.Role;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public UserLanguageDTO updateUserLanguage(UserLanguageDTO userLanguageDTO) {
        // 넘어온 userId, mainLanguage, subLanguage로 userDB에 update
        Optional<User> byId = userRepository.findById(userLanguageDTO.getUserId());
        if(byId.isPresent()){
            User user = byId.get();
            user.setMainLanguage(userLanguageDTO.getMainLanguage());
            user.setSubLanguage(userLanguageDTO.getSubLanguage());
        }
        return userLanguageDTO;
    }
}
