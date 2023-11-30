package com.practice.lkdcode.module.like.controller.dto.response;

import lombok.Builder;

import static com.practice.lkdcode.module.like.controller.dto.response.LikeResponseDTO.*;

public sealed interface LikeResponseDTO permits UpdateResult {
    @Builder
    record UpdateResult(
            String message,
            boolean isLike
    ) implements LikeResponseDTO {
    }
}
