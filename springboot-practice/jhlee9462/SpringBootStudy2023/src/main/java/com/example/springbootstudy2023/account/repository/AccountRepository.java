package com.example.springbootstudy2023.account.repository;

import com.example.springbootstudy2023.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
