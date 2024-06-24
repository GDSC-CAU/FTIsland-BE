package com.FTIsland.BE.user.exception;

import com.FTIsland.BE.base.BaseExceptionType;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum UserExceptionType implements BaseExceptionType {
    USER_NOT_FOUND(NOT_FOUND, "해당하는 사용자를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    UserExceptionType(final HttpStatus httpStatus, final String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
