package com.hexsoftwares.banking_system.terminal_api;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}

