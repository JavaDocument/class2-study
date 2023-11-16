package com.practice.lkdcode.module.post.service;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;

public interface PostCommandUsecase {
    PostResponseDTO.Create executeSave(final PostRequestDTO.Create request, CustomUserDetails customUserDetails);

    PostResponseDTO.Update executeUpdate(final Long id, final PostRequestDTO.Update request, CustomUserDetails customUserDetails);

    PostResponseDTO.Delete executeDelete(final Long id, CustomUserDetails customUserDetails);
}
