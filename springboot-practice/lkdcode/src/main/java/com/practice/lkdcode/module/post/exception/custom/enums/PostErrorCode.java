package com.practice.lkdcode.module.post.exception.custom.enums;

import com.practice.lkdcode.global.exception.custom.AppErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public enum PostErrorCode implements AppErrorCode {
    NOT_FOUND_POST_BY_ID_ERROR("존재하지 않는 게시글입니다. Id : ", HttpStatus.BAD_REQUEST),
    ;
    private final String message;
    private final HttpStatus httpStatus;

}
