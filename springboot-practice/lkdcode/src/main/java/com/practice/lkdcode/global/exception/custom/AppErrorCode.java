package com.practice.lkdcode.global.exception.custom;

import org.springframework.http.HttpStatus;

public interface AppErrorCode {

    String getMessage();

    HttpStatus getHttpStatus();

}
