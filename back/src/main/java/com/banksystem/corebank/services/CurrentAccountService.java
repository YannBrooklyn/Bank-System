package com.banksystem.corebank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.corebank.model.CurrentAccount;
import com.banksystem.corebank.repository.CurrentAccountRepository;

@Service
public class CurrentAccountService {
    
    @Autowired
    private CurrentAccountRepository repo;

    public CurrentAccount create(CurrentAccount account) {
        return repo.save(account);
    }

    public CurrentAccount getCurrentAccount(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'id : " + id));
    }

    public CurrentAccount updateCurrentAccount(Long id,CurrentAccount updatedAccount) {
        CurrentAccount existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'id : " + id));

        existing.setBalance(updatedAccount.getBalance());

        return repo.save(existing);
    }

    public CurrentAccount update(CurrentAccount account){
        return repo.save(account);
    }

    public CurrentAccount findAccountById(Long id){
        CurrentAccount account = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable avec l'id : " + id));

        return account;

    }

    public void transferFunds (Long sourceId, Long targetId, double amount) throws Exception{
        CurrentAccount source = findAccountById(sourceId);
        CurrentAccount target = findAccountById(targetId);
        if(source.getBalance()-amount<0){
           throw new Exception("Pas assez de fond pour un transfert");
        }
        source.setBalance(source.getBalance()-amount);
        target.setBalance(target.getBalance()+amount);
        update(source);
        update(target);
     }
}
