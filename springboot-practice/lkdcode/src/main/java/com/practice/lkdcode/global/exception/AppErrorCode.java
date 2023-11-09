package com.practice.lkdcode.global.exception;

import org.springframework.http.HttpStatus;

public interface AppErrorCode {

    String getMessage();

    HttpStatus getHttpStatus();

}
