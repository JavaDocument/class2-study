package com.practice.lkdcode.module.reply.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO.*;

public sealed interface ReplyResponseDTO permits CreateResponseDTO, GetResponseDTO, DeleteResponseDTO, UpdateResponseDTO {
    @Builder
    record GetResponseDTO(
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            String userEmail,
            Long postId
    ) implements ReplyResponseDTO {
    }

    @Builder
    record CreateResponseDTO(
            String content,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt,
            String userEmail,
            Long postId
    ) implements ReplyResponseDTO {
    }

    @Builder
    record DeleteResponseDTO(
            // TODO : ...
    ) implements ReplyResponseDTO {

    }

    @Builder
    record UpdateResponseDTO(
            // TODO : ...
    ) implements ReplyResponseDTO {
    }
}
