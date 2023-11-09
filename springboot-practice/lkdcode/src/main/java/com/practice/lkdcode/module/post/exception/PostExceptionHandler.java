package com.practice.lkdcode.module.post.exception;

import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class PostExceptionHandler {

    @ExceptionHandler(PostNotFoundByIdException.class)
    public ResponseEntity<?> catchPostNotFoundByIdException(PostNotFoundByIdException e) {
        String errorMessage = e.getMessage() + e.getId();
        int httpStatus = e.getErrorCode().getHttpStatus().value();
        log.error("catchPostNotFoundByIdException : " + errorMessage);

        return ResponseEntity
                .status(httpStatus)
                .body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> catchMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String defaultMessage = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        log.error(defaultMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(defaultMessage);
    }

}
