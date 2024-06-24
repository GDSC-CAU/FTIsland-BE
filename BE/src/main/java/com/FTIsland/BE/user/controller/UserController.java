package com.FTIsland.BE.user.controller;

import ch.qos.logback.core.status.Status;
import com.FTIsland.BE.response.ResponseEntity;
import com.FTIsland.BE.response.StatusCode;
import com.FTIsland.BE.user.dto.UserLanguageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.ResponseHandler;
import org.springframework.web.bind.annotation.*;
import com.FTIsland.BE.user.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/user/language")
    public ResponseEntity updateUserLanguage(@RequestBody UserLanguageRequest userLanguageRequest){
        userService.patchUserLanguage(userLanguageRequest);

        return ResponseEntity.builder().status(StatusCode.OK).build();
    }
}
