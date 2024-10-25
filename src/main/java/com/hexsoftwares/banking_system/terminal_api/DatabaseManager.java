package com.hexsoftwares.banking_system.terminal_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/banking_system"; // Update with your database name
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "root"; // Your MySQL password

    public static void setupDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            // Create users table
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INT PRIMARY KEY AUTO_INCREMENT," +
                         "first_name VARCHAR(100) NOT NULL," +
                         "last_name VARCHAR(100) NOT NULL," +
                         "dob DATE NOT NULL," +
                         "gender VARCHAR(10) NOT NULL," +
                         "email VARCHAR(100) NOT NULL UNIQUE," +
                         "marital_status VARCHAR(10) NOT NULL," +
                         "address VARCHAR(255) NOT NULL," +
                         "city VARCHAR(100) NOT NULL," +
                         "zip_code VARCHAR(20) NOT NULL," +
                         "state VARCHAR(100) NOT NULL," +
                         "religion VARCHAR(20) NOT NULL," +
                         "category VARCHAR(20) NOT NULL," +
                         "income VARCHAR(50) NOT NULL," +
                         "occupation VARCHAR(100) NOT NULL," +
                         "account_type VARCHAR(50) NOT NULL," +
                         "card_number VARCHAR(16) NOT NULL UNIQUE," +
                         "pin VARCHAR(4) NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

