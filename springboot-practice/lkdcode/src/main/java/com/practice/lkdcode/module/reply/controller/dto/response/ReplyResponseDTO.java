package com.practice.lkdcode.module.reply.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO.*;

public sealed interface ReplyResponseDTO permits Create, Get, Delete, Update {
    @Builder
    record Get(
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            String userEmail,
            Long postId
    ) implements ReplyResponseDTO {
    }

    @Builder
    record Create(
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            String userEmail,
            Long postId
    ) implements ReplyResponseDTO {
    }

    @Builder
    record Delete(
            // TODO : ...
    ) implements ReplyResponseDTO {

    }

    @Builder
    record Update(
            // TODO : ...
    ) implements ReplyResponseDTO {
    }
}
