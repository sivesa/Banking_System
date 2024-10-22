package com.hexsoftwares.banking_system.terminal_api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer classUnderTest;
	
	@Before 
	public void setUp() {
		classUnderTest = new Customer("John Doe");
	}
	
	@Test
    public void testInitialBalance() {
        // Verify that the initial balance is zero
        assertEquals(0.0, classUnderTest.checkBalance(), 0.001);
    }
    
    @Test
    public void testDeposit() {
        classUnderTest.deposit(100.0);
        assertEquals(100.0, classUnderTest.checkBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        classUnderTest.deposit(200.0);
        classUnderTest.withdraw(50.0);
        assertEquals(150.0, classUnderTest.checkBalance(), 0.001);
    }
    
}

