package com.practice.lkdcode.module.post.controller.dto.response;

import lombok.Builder;

import static com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO.*;

public sealed interface PostResponseDTO permits Create, Update, Delete, Get {
    @Builder
    record Create(
            Long id,
            String title,
            String content
    ) implements PostResponseDTO {
    }

    @Builder
    record Update(
            Long id,
            String title,
            String content
    ) implements PostResponseDTO {
    }

    @Builder
    record Delete(
            Long id,
            String title,
            String content
    ) implements PostResponseDTO {
    }

    @Builder
    record Get(
            Long id,
            String title,
            String content
    ) implements PostResponseDTO {
    }

}
