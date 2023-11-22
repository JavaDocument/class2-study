package com.practice.lkdcode.module.reply.controller.dto.request;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

import static com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO.*;

public sealed interface ReplyRequestDTO permits Create, Update {
    @Builder
    record Create(
            @NotBlank(message = "댓글 내용을 입력해주세요.")
            String content
    ) implements ReplyRequestDTO {
    }

    @Builder
    record Update(
            @NotBlank(message = "수정할 댓글 내용을 입력해주세요.")
            String content
    ) implements ReplyRequestDTO {
    }
}
