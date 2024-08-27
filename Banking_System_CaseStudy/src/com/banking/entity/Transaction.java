package com.banking.entity;

public class Transaction {
	
	private int transactionID;
	private int accountID;
	private String type;
	private double amount;
	public Transaction(int transactionID, int accountID, String type, double amount) {
		super();
		this.transactionID = transactionID;
		this.accountID = accountID;
		this.type = type;
		this.amount = amount;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", accountID=" + accountID + ", type=" + type
				+ ", amount=" + amount + "]";
	}
	
	
	
}
