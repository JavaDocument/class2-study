package com.practice.lkdcode.global.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> catchMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String defaultMessage = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        log.error("valid Exception : {}", defaultMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(defaultMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> catchRuntimeException(RuntimeException e) {
        String message = e.getMessage();
        log.error("runtimeException message : {}", message);
        log.error("runtimeException fillInStackTrace : {}", e.fillInStackTrace().toString());
        log.error("runtimeException : {}", e.toString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body("알 수 없는 예외 상황 : " + message);
    }
}
