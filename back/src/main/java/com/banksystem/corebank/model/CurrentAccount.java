package com.banksystem.corebank.model;

import jakarta.persistence.Entity;

@Entity
public class CurrentAccount extends BankAccount {

    private double overdraftLimit;  // limite de découvert autorisé

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

}
