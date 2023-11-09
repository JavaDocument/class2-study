package com.practice.lkdcode.global.exception;

import lombok.Getter;

public class AppException extends RuntimeException {

    @Getter
    private final AppErrorCode errorCode;

    public AppException(AppErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
