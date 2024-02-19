package com.FTIsland.BE.dto;

import com.FTIsland.BE.entity.ResponseStatus;

public class ResponseUtil {
    public static <T>ResponseDTO<T> SUCCESS (String message, T data) {
        return new ResponseDTO(ResponseStatus.SUCCESS, message, data);
    }

    public static <T>ResponseDTO<T> FAILURE (String message, T data) {
        return new ResponseDTO(ResponseStatus.FAILURE, message, data);
    }

    public static <T>ResponseDTO<T> ERROR (String message, T data) {
        return new ResponseDTO(ResponseStatus.ERROR, message, data);
    }
}
