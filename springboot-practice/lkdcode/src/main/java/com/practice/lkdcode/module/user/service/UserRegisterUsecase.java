package com.practice.lkdcode.module.user.service;

import com.practice.lkdcode.module.user.controller.dto.request.UserRequestDTO;
import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;

public interface UserRegisterUsecase {
    UserResponseDTO.UserSignupResponseDTO executeUserSignup(UserRequestDTO.UserSignupRequestDTO userSignupRequestDTO);

    UserResponseDTO.UserSignInJwtResponseDTO executeUserSignin(UserRequestDTO.UserSignInRequestDTO userSignInRequestDTO);
}
