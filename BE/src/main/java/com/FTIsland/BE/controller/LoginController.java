package com.FTIsland.BE.controller;

import aj.org.objectweb.asm.TypeReference;
import com.FTIsland.BE.dto.*;
import com.FTIsland.BE.repository.UserRepository;
import com.FTIsland.BE.service.LoginService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.api.client.http.HttpHeaders;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/sign-up")
    public ResponseDTO addUser(@RequestBody SignUpDTO signUpDTO) {
        return loginService.save(signUpDTO);
    }

    @PostMapping("/login")
    public ResponseDTO loginUser(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }


}
