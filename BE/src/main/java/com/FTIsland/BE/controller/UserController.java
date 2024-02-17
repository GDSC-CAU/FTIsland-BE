package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.UserSignUpDTO;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.service.UserService;
import com.nimbusds.oauth2.sdk.auth.JWTAuthentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up-custom")
    public String signUp(@RequestBody UserSignUpDTO userSignUpDto) throws Exception {
        userService.signUp(userSignUpDto);
        return "회원가입 성공";
    }

    @GetMapping("/jwt-test")
    public String jwtTest() {
        return "jwtTest 요청 성공";
    }

//    @PostMapping("/oauth/info")
//    public void getUserId(@AuthenticationPrincipal JwtAuthenticationToken userPrincipal) {
//        log.info(userPrincipal.getName());
//       // log.info(String.valueOf(userService.getUserId(userPrincipal.getEmail())));
//        //return userService.getUserId(userPrincipal.getEmail());
//    }
}
