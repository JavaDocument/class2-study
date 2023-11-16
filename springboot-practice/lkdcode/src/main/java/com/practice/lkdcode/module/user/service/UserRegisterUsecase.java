package com.practice.lkdcode.module.user.service;

import com.practice.lkdcode.module.user.controller.dto.UserDTO;

public interface UserRegisterUsecase {
    UserDTO.UserSignupResponseDTO executeUserSignup(UserDTO.UserSignupRequestDTO userSignupRequestDTO);

    UserDTO.UserSignInResponseDTO executeUserSignin(UserDTO.UserSignInRequestDTO userSignInRequestDTO);
}
