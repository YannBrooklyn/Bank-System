package com.banksystem.corebank.model;

import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(String accountHolderName, double initialBalance, double interestRate) {
        super(accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
