package com.practice.lkdcode.module.post.exception.custom;

import com.practice.lkdcode.global.exception.custom.AppErrorCode;
import com.practice.lkdcode.global.exception.custom.AppException;
import lombok.Getter;

public class PostNotFoundByIdException extends AppException {
    @Getter
    private final Long id;

    public PostNotFoundByIdException(AppErrorCode errorCode, Long id) {
        super(errorCode);
        this.id = id;
    }

}
