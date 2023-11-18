package com.practice.lkdcode.module.reply.exception.custom;

import com.practice.lkdcode.global.exception.custom.AppErrorCode;
import com.practice.lkdcode.global.exception.custom.AppException;

public class UnauthorizedReplyUpdateException extends AppException {
    public UnauthorizedReplyUpdateException(AppErrorCode errorCode) {
        super(errorCode);
    }
}
