package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.UserLanguageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.FTIsland.BE.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final UserService userService;

    @PutMapping("/language")
    public UserLanguageDTO updateUserLanguage(@RequestBody UserLanguageDTO userLanguageDTO){
        return userService.updateUserLanguage(userLanguageDTO);
    }
}
