package com.practice.lkdcode.module.reply.service.command;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.reply.controller.dto.request.ReplyRequestDTO;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;

public interface ReplyCommandUsecase {

    ReplyResponseDTO.CreateResponseDTO executeSave(Long postId, ReplyRequestDTO.CreateRequestDTO dto, CustomUserDetails customUserDetails);

    ReplyResponseDTO.UpdateResponseDTO executeUpdate(Long postId,ReplyRequestDTO.UpdateRequestDTO dto, CustomUserDetails customUserDetails);


}
