package com.practice.lkdcode.module.user.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.practice.lkdcode.module.user.controller.dto.response.UserResponseDTO.*;

public sealed interface UserResponseDTO permits UserInformationResponseDTO, UserSignInJwtResponseDTO, UserSignupResponseDTO {
    @Builder
    record UserSignupResponseDTO(
            String email,
            boolean success
    ) implements UserResponseDTO {
    }

    @Builder
    record UserSignInJwtResponseDTO(
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            String token
    ) implements UserResponseDTO {
    }

    @Builder
    record UserInformationResponseDTO(
            Long id,
            String email,
            LocalDateTime createdAt
    ) implements UserResponseDTO {
    }
}
