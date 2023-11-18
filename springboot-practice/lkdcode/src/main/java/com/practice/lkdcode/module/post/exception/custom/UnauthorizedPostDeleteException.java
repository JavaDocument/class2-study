package com.practice.lkdcode.module.post.exception.custom;

import com.practice.lkdcode.global.exception.custom.AppErrorCode;
import com.practice.lkdcode.global.exception.custom.AppException;

public class UnauthorizedPostDeleteException extends AppException {
    public UnauthorizedPostDeleteException(AppErrorCode errorCode) {
        super(errorCode);
    }
}
