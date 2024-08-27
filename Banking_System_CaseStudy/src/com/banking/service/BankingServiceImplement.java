package com.banking.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.entity.Account;
import com.banking.entity.Beneficiary;
import com.banking.entity.Customer;
import com.banking.entity.Transaction;

public class BankingServiceImplement implements BankingServices{
	
	private Map<Integer, Customer> customers = new HashMap<>();
	private Map<Integer, Account>accounts = new HashMap<>();
	private Map<Integer, Transaction> transactions = new HashMap<>();
	private Map<Integer, Beneficiary> beneficiaries = new HashMap<>();

	
	
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customers.put(customer.getCustomerID(), customer);		
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		accounts.put(account.getAccountID(), account);
	}

	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		transactions.put(transaction.getTransactionID(), transaction);
		Account account = accounts.get(transaction.getAccountID());
		if (account !=null) {
			if(transaction.getType().equalsIgnoreCase("deposit")) {
				account.setBalance(account.getBalance() + transaction.getAmount());
			}
			else if(transaction.getType().equalsIgnoreCase("withdrawal")) {
				account.setBalance(account.getBalance() - transaction.getAmount());
			}
		}
	}

	@Override
	public void addBeneficiary(Beneficiary beneficiary) {
		// TODO Auto-generated method stub
		beneficiaries.put(beneficiary.getBeneficiaryID(), beneficiary);
	}


	@Override
	public List<Account> getAccountsByCustomerId(int customerID) {
		// TODO Auto-generated method stub
		List<Account> result = new ArrayList<>();
		for(Account account : accounts.values()) {
			if(account.getCustomerID()== customerID) {
				result.add(account);
			}
		}
		return result;
	}
		

	@Override
	public List<Transaction> getTransactionsByAccountId(int accountID) {
		// TODO Auto-generated method stub
		List<Transaction> result = new ArrayList<>();
		for(Transaction transaction : transactions.values()) {
			if(transaction.getAccountID()== accountID) {
				result.add(transaction);
			}
		}
		return result;
	}

	@Override
	public List<Beneficiary> getBeneficiariesByCustomerId(int customerID) {
		// TODO Auto-generated method stub
		List<Beneficiary> result = new ArrayList<>();
		for(Beneficiary beneficiary : beneficiaries.values()) {
			if(beneficiary.getCustomerID()== customerID) {
				result.add(beneficiary);
			}
		}
		return result;
	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction findTransactionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beneficiary findBeneficiaryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accounts.values();
	}

	@Override
	public Collection<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactions.values();
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customers.values();
	}

	@Override
	public Collection<Beneficiary> getAllBeneficiaries() {
		// TODO Auto-generated method stub
		return beneficiaries.values();
	}
}
