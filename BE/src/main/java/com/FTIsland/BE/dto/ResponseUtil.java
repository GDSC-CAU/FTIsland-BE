package com.FTIsland.BE.dto;

import com.FTIsland.BE.entity.ResponseStatus;
import jakarta.servlet.http.HttpServletResponse;

public class ResponseUtil {
    public static <T>ResponseDTO<T> SUCCESS (String message, T data) {
        return new ResponseDTO(HttpServletResponse.SC_OK, message, data);
    }

    public static <T>ResponseDTO<T> FAILURE (String message, T data) {
        return new ResponseDTO(HttpServletResponse.SC_OK, message, data);
    }

    public static <T>ResponseDTO<T> ERROR (String message, T data) {
        return new ResponseDTO(HttpServletResponse.SC_NOT_FOUND, message, data);
    }
}
