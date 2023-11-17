package com.practice.lkdcode.module.user.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import javax.validation.constraints.*;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.practice.lkdcode.module.user.controller.dto.UserDTO.*;

public sealed interface UserDTO permits UserSignupRequestDTO, UserSignupResponseDTO, UserSignInRequestDTO, UserSignInResponseDTO, UserInformationDTO {
    @Builder
    record UserSignupRequestDTO(
            @NotBlank(message = "이메일을 입력해주세요.")
            @Email(message = "이메일 형식에 맞지 않습니다.")
            @Pattern(regexp = "\\S+", message = "이메일에 공백을 허용하지 않습니다.")
            String email,
            @NotBlank(message = "비밀번호를 입력해주세요.")
            @Size(min = 8, max = 15, message = "비밀번호는 8자 이상 15자 이하여야합니다.")
            @Pattern(regexp = "\\S+", message = "비밀번호에 공백을 허용하지 않습니다.")
            String password
    ) implements UserDTO {
    }

    @Builder
    record UserSignupResponseDTO(
            String email
    ) implements UserDTO {
    }

    @Builder
    record UserSignInRequestDTO(
            @NotBlank(message = "이메일을 입력해주세요.")
            @Email(message = "이메일 형식에 맞지 않습니다.")
            @Pattern(regexp = "\\S+", message = "이메일에 공백을 허용하지 않습니다.")
            String email,
            @NotBlank(message = "비밀번호를 입력해주세요.")
            @Size(min = 8, max = 15, message = "비밀번호는 8자 이상 15자 이하여야합니다.")
            @Pattern(regexp = "\\S+", message = "비밀번호에 공백을 허용하지 않습니다.")
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
    record UserInformationDTO(
            Long id,
            String email,
            @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
            LocalDateTime createdAt
    ) implements UserDTO {
    }
}
