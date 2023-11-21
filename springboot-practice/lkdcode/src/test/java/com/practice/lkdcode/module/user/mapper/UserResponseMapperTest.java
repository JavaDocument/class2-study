package com.practice.lkdcode.module.user.mapper;

import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserResponseMapperTest {
    private static final String EMAIL = "test@test.com";
    private static final String PASSWORD = "password";
    private User user;

    @BeforeEach
    void setUser() {
        this.user = User.builder()
                .email(EMAIL)
                .userStatus(UserStatus.CREATED)
                .password(PASSWORD)
                .build();
    }

    @Test
    void User를_DTO로_변환_성공_테스트() {
        // given
        // when
        UserResponseDTO.UserSignupResponseDTO userSignupResponseDTO = UserResponseMapper.INSTANCE.userToUserSignupResponseDTO(user);

        // then
        assertThat(userSignupResponseDTO.email())
                .isEqualTo(EMAIL);
    }

    @Test
    void JWT_를_DTO로_변환_성공_테스트() {
        // given
        String jwt = "jwtTokenTest";

        // when
        UserResponseDTO.UserSignInJwtResponseDTO userSignInJwtResponseDTO = UserResponseMapper.INSTANCE.tokenToUserSignInJwtResponseDTO(jwt);

        // then
        assertThat(userSignInJwtResponseDTO.token())
                .isEqualTo(jwt);
    }

    @Test
    void UserResponseMapperTest() {
        // given
        // when
        UserResponseDTO.UserInformationResponseDTO userInformationResponseDTO = UserResponseMapper.INSTANCE.userToUserInformationResponseDTO(user);

        // then
        assertThat(userInformationResponseDTO.email())
                .isEqualTo(EMAIL);
    }
}