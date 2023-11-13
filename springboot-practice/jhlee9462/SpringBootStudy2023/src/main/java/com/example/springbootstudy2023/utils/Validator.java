package com.example.springbootstudy2023.utils;

import com.example.springbootstudy2023.exception.ValidateException;

public interface Validator {

    void validate(Object target) throws ValidateException;

}
