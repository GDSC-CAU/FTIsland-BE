package com.FTIsland.BE.dto;

import com.FTIsland.BE.entity.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDTO<T> {
    private final ResponseStatus status;
    private final String message;
    private final T data;
}
