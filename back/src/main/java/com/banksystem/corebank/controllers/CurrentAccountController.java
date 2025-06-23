package com.banksystem.corebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.corebank.model.CurrentAccount;
import com.banksystem.corebank.repository.CurrentAccountRepository;


@RestController
@RequestMapping("/api/accounts")
public class CurrentAccountController {

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    @PostMapping("/current")
    public CurrentAccount createCurrentAccount(@RequestBody CurrentAccount account) {
        return currentAccountRepository.save(account);
    }
}
