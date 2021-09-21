package com.xinglian.contact;

public class Account {
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public double getBanlance() {
		return this.balance;
	}
	
	public void deposite(double number) {
		this.balance += number;
	}
	
	public void withdraw(double amt) {
		if(this.balance < amt) {
			System.out.print("剩余存款"+this.balance+"小于取款金额"+amt);
		}
		else {
			this.balance -= amt;
		}
	}
	
	
}
