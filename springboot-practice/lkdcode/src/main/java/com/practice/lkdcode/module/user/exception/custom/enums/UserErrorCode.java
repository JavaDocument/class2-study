package com.practice.lkdcode.module.user.exception.custom.enums;

import com.practice.lkdcode.global.exception.custom.AppErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements AppErrorCode {
    LOGIN_FAIL_ERROR("아이디 혹은 비밀번호를 다시 확인해주세요.", HttpStatus.BAD_REQUEST),
    USER_EMAIL_DUPLICATION_ERROR("아이디가 중복되었습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_USER_BY_ID_ERROR("존재하지 않는 회원입니다.", HttpStatus.BAD_REQUEST),
    ;

    private final String message;
    private final HttpStatus httpStatus;
}
