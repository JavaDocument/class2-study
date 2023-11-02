package com.practice.lkdcode.module.post.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import static com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO.*;

public sealed interface PostRequestDTO permits Create, Update {
    @Builder
    record Create(
            @NotBlank(message = "제목을 입력해주세요")
            String title,
            @NotBlank(message = "내용을 입력해주세요")
            String content
    ) implements PostRequestDTO {
    }

    @Builder
    record Update(
            @NotBlank(message = "수정할 제목을 입력해주세요")
            String title,
            @NotBlank(message = "수정할 내용을 입력해주세요")
            String content
    ) implements PostRequestDTO {
    }

}
