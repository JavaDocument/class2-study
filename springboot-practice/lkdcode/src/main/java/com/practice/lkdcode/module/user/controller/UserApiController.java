package com.practice.lkdcode.module.user.controller;

import com.practice.lkdcode.module.user.controller.dto.UserDTO;
import com.practice.lkdcode.module.user.service.UserRegisterUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {
    private final UserRegisterUsecase userRegisterUsecase;

    @PostMapping("/sign-up")
    public UserDTO.UserSignupResponseDTO getSignup(@Valid @RequestBody UserDTO.UserSignupRequestDTO userSignupRequestDTO) {
        return userRegisterUsecase.executeUserSignup(userSignupRequestDTO);
    }

    @PostMapping("/sign-in")
    public UserDTO.UserSignInResponseDTO getSignin(@Valid @RequestBody UserDTO.UserSignInRequestDTO userSignInRequestDTO) {
        return userRegisterUsecase.executeUserSignin(userSignInRequestDTO);
    }
}
