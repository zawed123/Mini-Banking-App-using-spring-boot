package com.monocept.dto;

public class AccountDTO {
	private String name;
	private double balance;

	public AccountDTO(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
