package com.practice.lkdcode.module.user.service;

import com.practice.lkdcode.module.user.controller.dto.UserDTO;

public interface UserQueryUsecase {
    UserDTO.UserInformationDTO retrieveUserInformation(Long id);
}
