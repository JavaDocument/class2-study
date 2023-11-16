package com.practice.lkdcode.module.user.service.impl;

import com.practice.lkdcode.global.config.jwt.JWTProvider;
import com.practice.lkdcode.module.user.controller.dto.UserDTO;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import com.practice.lkdcode.module.user.service.UserRegisterUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUsecase {
    private final UserRepository userRepository;
    private final JWTProvider jwtProvider;

    @Override
    public UserDTO.UserSignupResponseDTO executeUserSignup(UserDTO.UserSignupRequestDTO userSignupRequestDTO) {
        User saved = userRepository.save(
                User.builder()
                        .email(userSignupRequestDTO.email())
                        .password(userSignupRequestDTO.password())
                        .userStatus(UserStatus.CREATED)
                        .build()
        );

        return UserDTO.UserSignupResponseDTO.builder()
                .email(saved.getEmail())
                .success(Boolean.TRUE)
                .build();
    }

    @Override
    public UserDTO.UserSignInResponseDTO executeUserSignin(UserDTO.UserSignInRequestDTO userSignInRequestDTO) {
        User user = loadUserFrom(userSignInRequestDTO.email());

        String jwt = jwtProvider.generateToken(user);

        return new UserDTO.UserSignInResponseDTO(jwt);
    }

    private User loadUserFrom(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다. : " + email));
    }
}
