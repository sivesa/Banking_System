package com.hexsoftwares.banking_system.terminal_api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccount {
    private double balance;
    private int accountId;

    // Constructor that initializes the BankAccount with an account ID and retrieves the balance from the database
    public BankAccount(int accountId) {
        this.accountId = accountId;
        this.balance = getBalanceFromDatabase(); // Fetch initial balance
    }

    // Method to deposit an amount and update in the database
    public void deposit(double amount) {
        this.balance += amount; // Add amount to the current balance
        updateBalanceInDatabase(); // Update the balance in the database
        System.out.println("Deposited: " + amount + ". New balance: " + this.balance);
    }

    // Method to withdraw an amount and update in the database
    public void withdraw(double amount) {
        if (amount <= balance) { // Check for sufficient funds
            this.balance -= amount; // Deduct amount from the current balance
            updateBalanceInDatabase(); // Update the balance in the database
            System.out.println("Withdrew: " + amount + ". New balance: " + this.balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Fetches balance from database
    public double getBalance() {
        this.balance = getBalanceFromDatabase(); // Fetch the latest balance from the database
        return this.balance;
    }

    // Helper method to retrieve the balance from the database for this account
    private double getBalanceFromDatabase() {
        try (Connection conn = DatabaseManager.getConnection()) {
            String query = "SELECT balance FROM accounts WHERE account_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, accountId); // Set the account ID in the query
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance"); // Retrieve balance
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; // Return default balance if not found
    }

    // Helper method to update the balance in the database for this account
    private void updateBalanceInDatabase() {
        try (Connection conn = DatabaseManager.getConnection()) {
            String update = "UPDATE accounts SET balance = ? WHERE account_id = ?";
            PreparedStatement stmt = conn.prepareStatement(update);
            stmt.setDouble(1, this.balance); // Set the current balance in the query
            stmt.setInt(2, accountId); // Set the account ID in the query
            stmt.executeUpdate(); // Execute the update
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

