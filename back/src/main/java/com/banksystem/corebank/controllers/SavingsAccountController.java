package com.banksystem.corebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.corebank.model.SavingsAccount;
import com.banksystem.corebank.services.SavingsAccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/accounts")
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService service;

    @PostMapping("/savings")
    public SavingsAccount createSavingsAccount(@RequestBody SavingsAccount account) {
        return service.create(account);
    }

    @GetMapping("/savings/{id}")
    public SavingsAccount getSavingsAccount(@PathVariable Long id) {
        return service.findAccountById(id);
    }

    @PutMapping("/savings/{id}")
    public SavingsAccount updateSavingsAccount(@PathVariable Long id, @RequestBody SavingsAccount updatedAccount) {
        SavingsAccount existing = service.findAccountById(id);
        existing.setBalance(updatedAccount.getBalance());

        return service.update(existing);
    }
}
