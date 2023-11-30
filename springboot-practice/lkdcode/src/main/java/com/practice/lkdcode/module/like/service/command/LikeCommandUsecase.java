package com.practice.lkdcode.module.like.service.command;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.like.controller.dto.response.LikeResponseDTO;

public interface LikeCommandUsecase {
    LikeResponseDTO.UpdateResult executeToggleLike(Long postId, CustomUserDetails customUserDetails);
}
