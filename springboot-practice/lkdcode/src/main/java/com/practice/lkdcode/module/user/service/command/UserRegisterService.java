package com.practice.lkdcode.module.user.service.command;

import com.practice.lkdcode.global.config.jwt.JWTProvider;
import com.practice.lkdcode.module.user.controller.dto.request.UserRequestDTO;
import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import com.practice.lkdcode.module.user.exception.custom.UserEmailDuplicationException;
import com.practice.lkdcode.module.user.exception.custom.UserLoginFailException;
import com.practice.lkdcode.module.user.exception.custom.enums.UserErrorCode;
import com.practice.lkdcode.module.user.mapper.UserRequestMapper;
import com.practice.lkdcode.module.user.mapper.UserResponseMapper;
import com.practice.lkdcode.module.user.service.UserRegisterUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUsecase {
    private final UserRepository userRepository;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO.UserSignupResponseDTO executeUserSignup(UserRequestDTO.UserSignupRequestDTO userSignupRequestDTO) {
        if (isExistsByEmail(userSignupRequestDTO.email())) {
            throw new UserEmailDuplicationException(UserErrorCode.USER_EMAIL_DUPLICATION_ERROR);
        }

        String password = passwordEncoder.encode(userSignupRequestDTO.password());

        User user = UserRequestMapper.INSTANCE.signupDTOToUser(userSignupRequestDTO, password);
        User saved = userRepository.save(user);

        return UserResponseMapper.INSTANCE.userToUserSignupResponseDTO(saved);
    }

    @Override
    public UserResponseDTO.UserSignInJwtResponseDTO executeUserSignin(UserRequestDTO.UserSignInRequestDTO userSignInRequestDTO) {
        User user = loadUserFrom(userSignInRequestDTO.email());

        if (passwordEncoder.matches(userSignInRequestDTO.password(), user.getPassword())) {
            String jwt = jwtProvider.generateToken(user);
            return UserResponseMapper.INSTANCE.tokenToUserSignInJwtResponseDTO(jwt);
        }

        throw new UserLoginFailException(UserErrorCode.LOGIN_FAIL_ERROR);
    }

    private User loadUserFrom(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserLoginFailException(UserErrorCode.LOGIN_FAIL_ERROR));
    }

    private boolean isExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
