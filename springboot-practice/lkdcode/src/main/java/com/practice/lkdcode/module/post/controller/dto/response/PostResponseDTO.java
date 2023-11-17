package com.practice.lkdcode.module.post.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.practice.lkdcode.module.user.domain.User;
import lombok.Builder;

import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO.*;

public sealed interface PostResponseDTO permits Create, Update, Delete, Get {
    @Builder
    record Create(
            Long id,
            String title,
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime updatedAt,
            Long userId
    ) implements PostResponseDTO {
    }

    @Builder
    @JsonInclude
    record Update(
            Long id,
            String title,
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime updatedAt,
            Long userId

    ) implements PostResponseDTO {
    }

    @Builder
    record Delete(
            Long id,
            String title,
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime updatedAt,
            Long userId
    ) implements PostResponseDTO {
    }

    @Builder
    record Get(
            Long id,
            String title,
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime updatedAt,
            Long userId
    ) implements PostResponseDTO {
    }

}
