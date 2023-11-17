package com.practice.lkdcode.module.user.service.command;

import com.practice.lkdcode.global.config.jwt.JWTProvider;
import com.practice.lkdcode.module.user.controller.dto.UserDTO;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.repository.UserRepository;
import com.practice.lkdcode.module.user.exception.custom.UserEmailDuplicationException;
import com.practice.lkdcode.module.user.exception.custom.UserLoginFailException;
import com.practice.lkdcode.module.user.exception.custom.enums.UserErrorCode;
import com.practice.lkdcode.module.user.mapper.UserMapper;
import com.practice.lkdcode.module.user.service.UserRegisterUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUsecase {
    private static final UserMapper userMapper = UserMapper.INSTANCE;
    private final UserRepository userRepository;
    private final JWTProvider jwtProvider;


    @Override
    public UserDTO.UserSignupResponseDTO executeUserSignup(UserDTO.UserSignupRequestDTO userSignupRequestDTO) {
        if (isExistsByEmail(userSignupRequestDTO.email())) {
            throw new UserEmailDuplicationException(UserErrorCode.USER_EMAIL_DUPLICATION_ERROR);
        }

        User user = userMapper.signupDTOToUser(userSignupRequestDTO);
        User saved = userRepository.save(user);

        return userMapper.userToUserSignupDTO(saved);
    }

    @Override
    public UserDTO.UserSignInResponseDTO executeUserSignin(UserDTO.UserSignInRequestDTO userSignInRequestDTO) {
        User user = loadUserFrom(userSignInRequestDTO.email());

        if (user.getPassword().equals(userSignInRequestDTO.password())) {
            String jwt = jwtProvider.generateToken(user);
            return new UserDTO.UserSignInResponseDTO(jwt);
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
