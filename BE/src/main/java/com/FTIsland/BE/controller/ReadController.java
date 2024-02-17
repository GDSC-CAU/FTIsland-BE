package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.ReadDTO;
import com.FTIsland.BE.service.ReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReadController {
    private final ReadService readService;

    @PutMapping("/book/last-page")
    public ReadDTO putRead(@RequestBody ReadDTO readDTO){
        return readService.save(readDTO);
    }
}
