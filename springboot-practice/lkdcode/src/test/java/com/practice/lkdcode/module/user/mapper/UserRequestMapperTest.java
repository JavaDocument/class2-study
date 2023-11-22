package com.practice.lkdcode.module.user.mapper;

import com.practice.lkdcode.module.user.controller.dto.request.UserRequestDTO;
import com.practice.lkdcode.module.user.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRequestMapperTest {

    @Test
    void 회원가입_DTO_를_User_Entity_로_변환_성공_테스트() {
        // given
        String email = "email@email.com";
        String password = "password";

        UserRequestDTO.UserSignupRequestDTO userSignupRequestDTO = UserRequestDTO.UserSignupRequestDTO.builder()
                .email(email)
                .password(password)
                .build();

        // when
        User user = UserRequestMapper.INSTANCE.signupDTOToUser(userSignupRequestDTO);

        // then
        assertThat(user.getEmail())
                .isEqualTo(userSignupRequestDTO.email());
    }

}