package com.practice.lkdcode.module.reply.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ReplyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void test1() {
    }
}
