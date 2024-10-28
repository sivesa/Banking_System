package com.hexsoftwares.banking_system.terminal_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexsoftwares.banking_system.terminal_api.XMLUtil;

public class DatabaseManager {

    public static void setupDatabase() {
        try (Connection conn = DriverManager.getConnection(XMLUtil.getUrl(), XMLUtil.getUsername(), XMLUtil.getPassword());
             Statement stmt = conn.createStatement()) {
            // Create users table
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INT PRIMARY KEY AUTO_INCREMENT," +
                         "account_id INT," +
                         "FOREIGN KEY (account_id) REFERENCES accounts(account_id)," +
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
                         
			String createAccountsTable = "CREATE TABLE IF NOT EXISTS accounts ("
                    + "account_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "balance DECIMAL(15, 2) DEFAULT 0.0)";
            stmt.execute(sql);
            stmt.execute(createAccountsTable);
            System.out.println("Database setup completed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // TODO Get a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(XMLUtil.getUrl(), XMLUtil.getUsername(), XMLUtil.getPassword());
    }

    // TODO Close the connection to release resources (optional if using try-with-resources)
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Failed to close connection.");
                e.printStackTrace();
            }
        }
    }
}




