package com.example.springbootstudy2023.account.entity;

import com.example.springbootstudy2023.account.dto.AccountDTO;
import com.example.springbootstudy2023.global.entity.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "account")
public class Account extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    private Account(AccountDTO dto) {
        // instanceof 연산자를 사용함과 동시에 새 변수에 대입할 수 있다.
        // Java 16 부터 가능한 pattern matching for instanceof
        if (dto instanceof AccountDTO.CreateRequest createRequest) {
            this.email = createRequest.email();
            this.password = createRequest.password();
        }
    }

    public static Account of(AccountDTO dto) {
        return new Account(dto);
    }

}
