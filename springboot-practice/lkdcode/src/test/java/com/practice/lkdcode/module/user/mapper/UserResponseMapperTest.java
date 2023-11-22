package com.practice.lkdcode.module.user.mapper;

import com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.support.base.BaseRepositoryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserResponseMapperTest extends BaseRepositoryList {
    private User user;

    @BeforeEach
    void setUser() {
        this.user = super.userRepository.findById(1L).orElseThrow();
    }

    @Test
    void User_를_sign_up_DTO_로_변환_성공_테스트() {
        // given
        // when
        UserResponseDTO.UserSignupResponseDTO userSignupResponseDTO = UserResponseMapper.INSTANCE.userToUserSignupResponseDTO(user);

        // then
        assertThat(userSignupResponseDTO.email())
                .isEqualTo(USER_EMAIL);
    }

    @Test
    void JWT_를_DTO_로_변환_성공_테스트() {
        // given
        String jwt = "jwtTokenTest";

        // when
        UserResponseDTO.UserSignInJwtResponseDTO userSignInJwtResponseDTO = UserResponseMapper.INSTANCE.tokenToUserSignInJwtResponseDTO(jwt);

        // then
        assertThat(userSignInJwtResponseDTO.token())
                .isEqualTo(jwt);
    }

    @Test
    void User_를_UserInformation_DTO_변환_성공_테스트() {
        // given
        // when
        UserResponseDTO.UserInformationResponseDTO userInformationResponseDTO = UserResponseMapper.INSTANCE.userToUserInformationResponseDTO(user);

        // then
        assertThat(userInformationResponseDTO.email())
                .isEqualTo(USER_EMAIL);
    }
}