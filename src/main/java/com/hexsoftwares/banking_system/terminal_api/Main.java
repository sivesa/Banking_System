package com.hexsoftwares.banking_system.terminal_api;

import java.util.Scanner;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.setupDatabase(); // Setup database
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);
        
        try {
		    while (true) {
		        System.out.println("Welcome to the Banking System");
		        System.out.println("1. Register");
		        System.out.println("2. Login");
		        System.out.println("3. Exit");
		        System.out.print("Select an option: ");
		        int choice = scanner.nextInt();
		        scanner.nextLine(); // Consume newline

		        switch (choice) {
		            case 1:
		                bankingSystem.registerUser();
		                break;
		            case 2:
		            	Customer customer = bankingSystem.loginUser();
		                if (customer != null) {
							manageCustomerAccount(customer);
		                } else {

		                }
		                break;
		            case 3:
		                System.out.println("Exiting the system.");
		                return;
		            default:
		                System.out.println("Invalid option. Please try again.");
		        }
		    }
		} finally {
            scanner.close(); // Close the Scanner to release resources
            AbandonedConnectionCleanupThread.checkedShutdown(); // Properly shutdown MySQL cleanup thread
            System.out.println("Resources cleaned up, system exited smoothly.");
        }
    }
    
    // Method to handle customer account actions
    private static void manageCustomerAccount(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome, " + customer.getCustomer());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    customer.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    customer.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful.");
                    break;
                case 3:
                    System.out.println("Current Balance: " + customer.checkBalance());
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return; // Exit customer menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

