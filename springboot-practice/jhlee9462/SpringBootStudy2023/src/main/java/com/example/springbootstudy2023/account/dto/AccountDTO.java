package com.example.springbootstudy2023.account.dto;

import com.example.springbootstudy2023.account.entity.Account;

import javax.validation.constraints.*;

public interface AccountDTO {

    record CreateResponse(boolean isCreated) implements AccountDTO {
        public static CreateResponse of(Account account) {
            return new CreateResponse(account != null);
        }
    }

    record CreateRequest(
            @NotBlank
            @Email
            @Pattern(regexp = "\\S+")
            String email,
            @NotBlank
            @Size(min = 8, max = 15)
            @Pattern(regexp = "\\S+")
            String password
    ) implements AccountDTO {
    }

    record LoginRequest(
            String email,
            String password
    ) implements AccountDTO {
    }

    record LoginResponse(
            String accessToken
    ) implements AccountDTO {
        public static LoginResponse of(String accessToken) {
            return new LoginResponse(accessToken);
        }
    }

}
