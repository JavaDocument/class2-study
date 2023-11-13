package com.example.springbootstudy2023.exception;

public class ValidateException extends RuntimeException {

    public ValidateException(String message) {
        super(message);
    }
}
