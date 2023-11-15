package com.example.springbootstudy2023.global.utils;

import com.example.springbootstudy2023.global.exception.ValidateException;

public interface Validator {

    void validate(Object target) throws ValidateException;

}
