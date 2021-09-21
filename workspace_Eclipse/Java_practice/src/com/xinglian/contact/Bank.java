package com.xinglian.contact;
import java.util.ArrayList;
import java.util.List;
public class Bank {
	private List<Customer> customers = new ArrayList<>();
//	private Customer[] customers;
	private int numberOfCustormer;
	
	public Bank() {
		
	}
	
	public void addCustomer(String firstName,String lastName) {
		this.customers.add(new Customer(firstName,lastName));
		this.numberOfCustormer += 1;
		
	}
	public int getNumOfCustomers() {
		return this.numberOfCustormer;
	}
	public Customer getCustomer(int index) {
		return this.customers.get(index);
	}
			
}
