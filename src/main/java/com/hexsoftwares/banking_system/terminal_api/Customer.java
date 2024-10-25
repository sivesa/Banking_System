package com.hexsoftwares.banking_system.terminal_api;

public class Customer {
    private String accountId;
    private String customer;
    private BankAccount account;

    public Customer(String accountId, String customer) {
        this.accountId = accountId;
        this.customer = customer;
        this.account = new BankAccount();
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public String getCustomer() {
        return customer;
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

