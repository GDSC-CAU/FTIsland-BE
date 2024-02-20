package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.UserLanguageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.FTIsland.BE.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final UserService userService;

    @PostMapping("/language")
    public UserLanguageDTO saveUserLanguage(@RequestBody UserLanguageDTO userLanguageDTO){
        return userService.save(userLanguageDTO);
    }
}
