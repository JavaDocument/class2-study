package com.example.springbootstudy2023.account.api;

import com.example.springbootstudy2023.account.dto.AccountDTO;
import com.example.springbootstudy2023.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTO.CreateResponse> signUp(@RequestBody @Valid AccountDTO.CreateRequest requestDto) {
        return ResponseEntity.ok(accountService.signUp(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountDTO.LoginRequest requestDto) {
        return ResponseEntity.ok().build();
    }

}
