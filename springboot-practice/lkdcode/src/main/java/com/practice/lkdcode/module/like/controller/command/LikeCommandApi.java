package com.practice.lkdcode.module.like.controller.command;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.like.controller.dto.response.LikeResponseDTO;
import com.practice.lkdcode.module.like.service.command.LikeCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeCommandApi {
    private final LikeCommandUsecase likeCommandUsecase;

    @PostMapping("/toggle/{postId}")
    public LikeResponseDTO.UpdateResult getToggleLike(
            @PathVariable(name = "postId") Long postId,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return likeCommandUsecase.executeToggleLike(postId, customUserDetails);
    }
}
