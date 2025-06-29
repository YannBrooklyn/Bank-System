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

import com.banksystem.corebank.model.CurrentAccount;
import com.banksystem.corebank.model.Transaction;
import com.banksystem.corebank.services.CurrentAccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/accounts")
public class CurrentAccountController {

    @Autowired
    private CurrentAccountService service;

    @PostMapping("/current")
    public CurrentAccount createCurrentAccount(@RequestBody CurrentAccount account) {
        return service.create(account);
    }

    @GetMapping("/current/{id}")
    public CurrentAccount getCurrentAccount(@PathVariable Long id) {
        return service.findAccountById(id);
    }

    @PutMapping("/current/{id}")
    public CurrentAccount updateCurrentAccount(@PathVariable Long id, @RequestBody CurrentAccount updatedAccount) {
        CurrentAccount existing = service.findAccountById(id);
        existing.setBalance(updatedAccount.getBalance());

        return service.update(existing);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody Transaction transfer) throws Exception{
        service.transferFunds(transfer.getSourceId(), transfer.getTargetId(), transfer.getAmount());
    }
}
