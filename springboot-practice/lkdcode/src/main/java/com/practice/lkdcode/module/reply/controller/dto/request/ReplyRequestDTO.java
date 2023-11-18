package com.practice.lkdcode.module.reply.controller.dto.request;

import javax.validation.constraints.NotBlank;

import static com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO.*;

public sealed interface ReplyRequestDTO permits CreateRequestDTO, UpdateRequestDTO {
    record CreateRequestDTO(
            @NotBlank(message = "댓글 내용을 입력해주세요.")
            String content
    ) implements ReplyRequestDTO {
    }

    record UpdateRequestDTO(
            @NotBlank(message = "수정할 댓글 내용을 입력해주세요.")
            String content,
            Long postId
    ) implements ReplyRequestDTO {
    }
}
