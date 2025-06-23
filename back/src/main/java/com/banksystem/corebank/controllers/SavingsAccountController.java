package com.banksystem.corebank.controllers;

import com.banksystem.corebank.model.SavingsAccount;
import com.banksystem.corebank.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // <--- Import des annotations REST

@RestController
@RequestMapping("/api/accounts")
public class SavingsAccountController {

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @PostMapping("/savings")
    public SavingsAccount createSavingsAccount(@RequestBody SavingsAccount account) {
        return savingsAccountRepository.save(account);
    }
}
