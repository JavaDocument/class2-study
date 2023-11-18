package com.practice.lkdcode.module.post.exception.custom;

import com.practice.lkdcode.global.exception.custom.AppErrorCode;
import com.practice.lkdcode.global.exception.custom.AppException;

public class UnauthorizedPostUpdateException extends AppException {
    public UnauthorizedPostUpdateException(AppErrorCode errorCode) {
        super(errorCode);
    }
}
