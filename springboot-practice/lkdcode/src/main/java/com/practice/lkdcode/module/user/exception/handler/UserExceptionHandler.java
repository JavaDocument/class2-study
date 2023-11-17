package com.practice.lkdcode.module.user.exception.handler;

import com.practice.lkdcode.module.user.exception.custom.UserEmailDuplicationException;
import com.practice.lkdcode.module.user.exception.custom.UserLoginFailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ExceptionHandler(UserLoginFailException.class)
    public ResponseEntity<?> catchUserLoginFailException(UserLoginFailException e) {
        log.error(e.getMessage());

        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(e.getMessage());
    }

    @ExceptionHandler(UserEmailDuplicationException.class)
    public ResponseEntity<?> catchUserEmailDuplicationException(UserEmailDuplicationException e) {
        log.error(e.getMessage());

        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(e.getMessage());
    }
}
