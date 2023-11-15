package com.example.springbootstudy2023.account.service;

import com.example.springbootstudy2023.account.dto.AccountDTO;
import com.example.springbootstudy2023.account.entity.Account;
import com.example.springbootstudy2023.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountDTO.CreateResponse signUp(AccountDTO.CreateRequest reqeuestDto) {
        Account saved = accountRepository.save(Account.of(reqeuestDto));
        return AccountDTO.CreateResponse.of(saved);
    }
}
