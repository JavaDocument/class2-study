package com.practice.lkdcode.module.user.exception.custom;

import com.practice.lkdcode.global.exception.custom.AppException;
import com.practice.lkdcode.module.user.exception.custom.enums.UserErrorCode;

public class UserEmailDuplicationException extends AppException {

    public UserEmailDuplicationException(UserErrorCode errorCode) {
        super(errorCode);
    }
}
