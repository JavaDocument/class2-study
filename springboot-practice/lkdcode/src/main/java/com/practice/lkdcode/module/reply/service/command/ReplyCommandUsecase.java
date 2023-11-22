package com.practice.lkdcode.module.reply.service.command;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;

public interface ReplyCommandUsecase {

    ReplyResponseDTO.Create executeSave(Long postId, ReplyRequestDTO.Create dto, CustomUserDetails customUserDetails);

    ReplyResponseDTO.Update executeUpdate(Long postId, ReplyRequestDTO.Update dto, CustomUserDetails customUserDetails);


}
