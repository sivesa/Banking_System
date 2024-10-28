package com.hexsoftwares.banking_system.terminal_api;

public class Customer {
    private int accountId;
    private String customer;
    private BankAccount account;

    public Customer(int accountId, String customer) {
        this.accountId = accountId;
        this.customer = customer;
        this.account = new BankAccount(accountId);
    }
    
    public int getAccountId() {
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

