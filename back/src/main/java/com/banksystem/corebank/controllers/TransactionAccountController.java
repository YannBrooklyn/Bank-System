package com.banksystem.corebank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.corebank.model.Transaction;
import com.banksystem.corebank.services.TransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transaction")
public class TransactionAccountController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/account/{id}")
    public List<Transaction> getTransactions(@PathVariable Long id){
        return transactionService.findAllTransactions(id);
    }

}
