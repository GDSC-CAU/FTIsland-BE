package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.*;
import com.FTIsland.BE.service.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/sign-up")
    public ResponseDTO addUser(@Valid @RequestBody SignUpDTO signUpDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String, String> validatorResult = loginService.validateHandling(bindingResult);

            return new ResponseDTO<>(HttpServletResponse.SC_NOT_FOUND, "invalid input", validatorResult);
        }

        return loginService.save(signUpDTO);
    }

    @PostMapping("/login")
    public ResponseDTO loginUser(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }


}
