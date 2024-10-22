package com.hexsoftwares.banking_system.terminal_api;

public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name) {
        this.name = name;
        this.account = new BankAccount();
    }
    
    public String getName() {
        return name;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public double checkBalance() {
        return account.getBalance();
    }
}

