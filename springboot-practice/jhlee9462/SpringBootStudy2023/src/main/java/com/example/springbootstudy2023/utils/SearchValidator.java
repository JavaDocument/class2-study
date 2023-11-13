package com.example.springbootstudy2023.utils;

import com.example.springbootstudy2023.dto.SearchDTO;
import com.example.springbootstudy2023.exception.ValidateException;
import org.springframework.stereotype.Component;

@Component
public class SearchValidator implements Validator {

    @Override
    public void validate(Object target) throws ValidateException {
        if (((SearchDTO.BoardSearchDTO) target).keyword().trim().isEmpty())
            throw new ValidateException("검색어를 입력해주세요.");
    }
}
