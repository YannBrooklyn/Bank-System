package com.banksystem.corebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; // <--- Import des annotations REST
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.corebank.model.SavingsAccount;
import com.banksystem.corebank.repository.SavingsAccountRepository;

@CrossOrigin(origins = "http://localhost:4200")
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
