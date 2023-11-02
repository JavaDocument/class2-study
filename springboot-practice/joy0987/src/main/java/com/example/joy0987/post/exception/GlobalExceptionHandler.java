package com.example.joy0987.post.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 컨트롤러 전역에서 발생하는 예외를 catch
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler (RuntimeException.class) // 특정 클래스에서 발생할 수 있는 예외를 catch
    public String handlerRuntimeException (final RuntimeException e) {
        log.error("handlerRuntimeException : {}", e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler (NullPointerException.class) // 특정 클래스에서 발생할 수 있는 예외를 catch
    public String handlerNullPointerException (final RuntimeException e) {
        log.error("handlerRuntimeException : {}", e.getMessage());
        return e.getMessage();
    }
}
