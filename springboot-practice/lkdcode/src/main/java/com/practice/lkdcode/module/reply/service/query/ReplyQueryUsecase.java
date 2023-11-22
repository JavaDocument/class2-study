package com.practice.lkdcode.module.reply.service.query;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.reply.controller.dto.response.ReplyResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyQueryUsecase {
    Page<ReplyResponseDTO.Get> retrieveFindAllByUserId(final CustomUserDetails customUserDetails);

    Page<ReplyResponseDTO.Get> retrieveFindAllByPostId(final Pageable pageable, final Long postId);
}
