package com.practice.lkdcode.module.reply.controller.command;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import com.practice.lkdcode.module.reply.service.command.ReplyCommandUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/replies")
@RequiredArgsConstructor
public class ReplyCommandApi {
    private final ReplyCommandUsecase replyCommandUsecase;

    @PostMapping("/{postId}")
    public ReplyResponseDTO.Create create(
            @PathVariable(name = "postId") Long postId,
            @Valid @RequestBody ReplyRequestDTO.Create dto,
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    ) {
        return replyCommandUsecase.executeSave(postId, dto, customUserDetails);
    }

    @PatchMapping
    public void update(

    ) {
    }

    @DeleteMapping
    public void delete(

    ) {
    }
}
