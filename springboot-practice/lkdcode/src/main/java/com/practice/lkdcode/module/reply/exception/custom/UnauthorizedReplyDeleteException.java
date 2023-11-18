package com.practice.lkdcode.module.reply.exception.custom;

import com.practice.lkdcode.global.exception.custom.AppErrorCode;
import com.practice.lkdcode.global.exception.custom.AppException;

public class UnauthorizedReplyDeleteException extends AppException {
    public UnauthorizedReplyDeleteException(AppErrorCode errorCode) {
        super(errorCode);
    }
}
