package com.banksystem.corebank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.corebank.model.SavingsAccount;
import com.banksystem.corebank.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {
    
    @Autowired
    private SavingsAccountRepository repo;

    public SavingsAccount create(SavingsAccount account) {
        return repo.save(account);
    }

    public SavingsAccount getSavingsAccount(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'id : " + id));
    }

    public SavingsAccount update(SavingsAccount account){
        return repo.save(account);
    }

    public SavingsAccount findAccountById(Long id){
        SavingsAccount account = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'id : " + id));

        return account;

    }
}
