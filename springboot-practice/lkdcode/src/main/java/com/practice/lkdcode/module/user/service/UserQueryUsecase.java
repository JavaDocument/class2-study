package com.practice.lkdcode.module.user.service;

import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;

public interface UserQueryUsecase {
    UserResponseDTO.UserInformationResponseDTO retrieveUserInformation(Long id);
}
