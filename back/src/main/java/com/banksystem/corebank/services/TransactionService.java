package com.banksystem.corebank.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.corebank.model.CurrentAccount;
import com.banksystem.corebank.model.Transaction;
import com.banksystem.corebank.repository.CurrentAccountRepository;
import com.banksystem.corebank.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void transferFunds(Long sourceId, Long targetId, double amount) throws Exception {
        CurrentAccount source = currentAccountRepository.findById(sourceId)
                .orElseThrow(() -> new Exception("Source account not found"));

        CurrentAccount target = currentAccountRepository.findById(targetId)
                .orElseThrow(() -> new Exception("Target account not found"));

        if (source.getBalance() < amount) {
            throw new Exception("Insufficient funds");
        }

        // Débit/crédit
        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        // Création de la transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        transaction.setType("TRANSFER");
        transaction.setSourceId(sourceId);
        transaction.setTargetId(targetId);

        // Sauvegarder les entités
        System.out.println("📝 Transaction créée : src=" + transaction.getSourceId() + ", tgt=" + transaction.getTargetId() + ", montant=" + transaction.getAmount());

        currentAccountRepository.save(source);
        currentAccountRepository.save(target);

        transactionRepository.save(transaction);
    }

    public List<Transaction> findAllTransactions(Long id){
        return transactionRepository.findBySourceIdOrTargetId(id,id);
    }
}
