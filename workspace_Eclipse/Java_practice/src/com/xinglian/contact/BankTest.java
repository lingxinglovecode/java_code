package com.xinglian.contact;

public class BankTest {
	public static void main(String[] args) {
		Bank mybank = new Bank();
		mybank.addCustomer("lianxing", "Wang");
		System.out.print(mybank.getNumOfCustomers());
		System.out.print(mybank.getCustomer(0).getFirstName());
		
		
		
		
		
		
	}
}
