package com.practice.lkdcode.module.user.exception.custom;

import com.practice.lkdcode.global.exception.custom.AppException;
import com.practice.lkdcode.module.user.exception.custom.enums.UserErrorCode;

public class UserNotFoundByIdException extends AppException {

    public UserNotFoundByIdException(UserErrorCode errorCode) {
        super(errorCode);
    }
}
