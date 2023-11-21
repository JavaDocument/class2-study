package com.practice.lkdcode.module.user.controller.command;

import com.practice.lkdcode.module.user.controller.dto.request.UserRequestDTO;
import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;
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
public class UserCommandApi {
    private final UserRegisterUsecase userRegisterUsecase;

    @PostMapping("/sign-up")
    public UserResponseDTO.UserSignupResponseDTO getSignup(@Valid @RequestBody final UserRequestDTO.UserSignupRequestDTO userSignupRequestDTO) {
        return userRegisterUsecase.executeUserSignup(userSignupRequestDTO);
    }

    @PostMapping("/sign-in")
    public UserResponseDTO.UserSignInJwtResponseDTO getSignin(@Valid @RequestBody UserRequestDTO.UserSignInRequestDTO userSignInRequestDTO) {
        return userRegisterUsecase.executeUserSignin(userSignInRequestDTO);
    }
}
