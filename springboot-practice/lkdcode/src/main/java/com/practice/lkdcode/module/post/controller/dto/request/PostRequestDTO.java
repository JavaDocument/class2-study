package com.practice.lkdcode.module.post.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import static com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO.Create;
import static com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO.Update;

public sealed interface PostRequestDTO permits Create, Update {
    @Builder
    record Create(
            @NotBlank(message = "제목을 입력해주세요")
            @Size(max = 100, message = "제목은 최대 100글자 이하입니다.")
            String title,

            @NotBlank(message = "내용을 입력해주세요")
            @Size(max = 1000, message = "내용은 최대 1,000글자 이하입니다.")
            String content
    ) implements PostRequestDTO {
    }

    @Builder
    record Update(
            @NotBlank(message = "수정할 제목을 입력해주세요")
            @Size(max = 100, message = "제목은 최대 100글자 이하입니다.")
            String title,
            @NotBlank(message = "수정할 내용을 입력해주세요")
            @Size(max = 1000, message = "내용은 최대 1,000글자 이하입니다.")
            String content
    ) implements PostRequestDTO {
    }

}
