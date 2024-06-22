package com.FTIsland.BE.user.controller;

import com.FTIsland.BE.user.dto.UserLanguageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FTIsland.BE.user.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/user/language")
    public ResponseEntity<ResponseHandler<Void>> updateUserLanguage(@RequestBody UserLanguageRequest userLanguageRequest){
        userService.patchUserLanguage(userLanguageRequest);
        return ResponseEntity.ok().build();
    }
}
