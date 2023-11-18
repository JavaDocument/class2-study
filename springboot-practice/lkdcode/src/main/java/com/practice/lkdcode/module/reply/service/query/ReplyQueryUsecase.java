package com.practice.lkdcode.module.reply.service.query;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;

public interface ReplyQueryUsecase {

    ReplyResponseDTO.GetResponseDTO execute2(CustomUserDetails customUserDetails);

}
