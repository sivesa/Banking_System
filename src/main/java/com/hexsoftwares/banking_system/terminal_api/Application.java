package com.hexsoftwares.banking_system.terminal_api;

import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);

	}
}
