package com.example.springbootstudy2023.account.dto;

import com.example.springbootstudy2023.account.entity.Account;
import com.example.springbootstudy2023.account.utils.JwtUtil;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

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
        public static LoginResponse of(Account account) {
            return new LoginResponse(JwtUtil.generateToken(account));
        }
    }

    record DetailResponse(
            Long id,
            String email,
            LocalDateTime createTime
    ) implements AccountDTO {
        public static DetailResponse of(Account account) {
            return new DetailResponse(account.getId(), account.getEmail(), account.getCreateTime());
        }
    }

}
