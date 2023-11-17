package com.practice.lkdcode.module.user.controller.dto.request;

import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.practice.lkdcode.module.user.controller.dto.request.UserRequestDTO.*;

public sealed interface UserRequestDTO permits UserSignInRequestDTO, UserSignupRequestDTO {
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
    ) implements UserRequestDTO {
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
    ) implements UserRequestDTO {
    }
}
