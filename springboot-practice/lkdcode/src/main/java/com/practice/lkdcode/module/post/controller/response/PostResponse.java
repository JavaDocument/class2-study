package com.practice.lkdcode.module.post.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonPropertyOrder({"message", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PostResponse<T> {
    private final String message;
    private final T data;

    private PostResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public static <T> PostResponse<T> ok(T data) {
        return new PostResponse<>("성공", data);
    }

    public static <T> PostResponse<T> error(T data) {
        return new PostResponse<>("실패", data);
    }

}
