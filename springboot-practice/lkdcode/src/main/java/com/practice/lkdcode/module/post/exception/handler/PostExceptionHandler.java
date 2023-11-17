package com.practice.lkdcode.module.post.exception.handler;

import com.practice.lkdcode.module.post.exception.custom.PostNotFoundByIdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
}
