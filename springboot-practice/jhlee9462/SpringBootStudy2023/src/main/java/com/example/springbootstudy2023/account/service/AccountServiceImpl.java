package com.example.springbootstudy2023.account.service;

import com.example.springbootstudy2023.account.dto.AccountDTO;
import com.example.springbootstudy2023.account.entity.Account;
import com.example.springbootstudy2023.account.repository.AccountRepository;
import com.example.springbootstudy2023.account.utils.JwtUtil;
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

    @Override
    public AccountDTO.LoginResponse login(AccountDTO.LoginRequest requestDto) {
        Account account = accountRepository.findByEmail(requestDto.email())
                .orElseThrow();
        return AccountDTO.LoginResponse.of(account);
    }

    @Override
    public AccountDTO.DetailResponse getAccountDetail(String token) {
        Long id = JwtUtil.extractClaims(token).get("sub", Long.class);
        return AccountDTO.DetailResponse.of(accountRepository.findById(id).orElseThrow());
    }
}
