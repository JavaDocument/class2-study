package com.example.springbootstudy2023.account.service;

import com.example.springbootstudy2023.account.dto.AccountDTO;

public interface AccountService {

    AccountDTO.CreateResponse signUp(AccountDTO.CreateRequest dto);

}
