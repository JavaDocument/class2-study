package com.practice.lkdcode.module.user.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import javax.validation.constraints.*;

import java.time.LocalDateTime;

import static com.practice.lkdcode.module.user.controller.dto.UserDTO.*;

public sealed interface UserDTO permits UserSignupRequestDTO, UserSignupResponseDTO, UserSignInRequestDTO, UserSignInResponseDTO, UserInformation {
    @Builder
    record UserSignupRequestDTO(
            @NotBlank(message = "이메일을 입력해주세요.")
            @Email(message = "이메일 형식에 맞지 않습니다.")
            String email,
            @NotBlank(message = "비밀번호를 입력해주세요.")
            @Size(min = 8, max = 15, message = "비밀번호는 8자 이상 15자 이하여야합니다.")
            String password
    ) implements UserDTO {
    }

    @Builder
    record UserSignupResponseDTO(
            String email,
            boolean success
    ) implements UserDTO {
    }

    @Builder
    record UserSignInRequestDTO(
            @NotBlank(message = "이메일을 입력해주세요.")
            @Email(message = "이메일 형식에 맞지 않습니다.")
            String email,
            @NotBlank(message = "비밀번호를 입력해주세요.")
            @Size(min = 8, max = 15, message = "비밀번호는 8자 이상 15자 이하여야합니다.")
            String password
    ) implements UserDTO {
    }

    @Builder
    record UserSignInResponseDTO(
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            String token
    ) implements UserDTO {
    }

    @Builder
    record UserInformation(
            Long id,
            String email,
            LocalDateTime createdAt
    ) implements UserDTO {
    }
}
