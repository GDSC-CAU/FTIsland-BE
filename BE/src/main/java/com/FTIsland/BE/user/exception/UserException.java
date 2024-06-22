package com.FTIsland.BE.user.exception;

import com.FTIsland.BE.base.BaseException;

public class UserException extends BaseException {
    public UserException(final UserExceptionType exceptionType) {
        super(exceptionType);
    }
}
