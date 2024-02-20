package com.FTIsland.BE.dto;

import com.FTIsland.BE.entity.ResponseStatus;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.http.HttpResponse;

@Getter
@AllArgsConstructor
public class ResponseDTO<T> {
    private final int status;
    private final String message;
    private final T data;
}
