package com.banking.service;

import java.util.Collection;
import java.util.List;

import com.banking.entity.Account;
import com.banking.entity.Beneficiary;
import com.banking.entity.Customer;
import com.banking.entity.Transaction;

public interface BankingServices {
	
	void addCustomer (Customer customer);
	void addAccount (Account account);
	void addTransaction (Transaction transaction);
	void addBeneficiary (Beneficiary beneficiary);
	
	Customer findCustomerById(int id);
	Account findAccountById(int id);
	Transaction findTransactionById(int id);
	Beneficiary findBeneficiaryById(int id);
	
	Collection <Account> getAllAccounts();
	Collection <Transaction> getAllTransactions();
	Collection <Customer> getAllCustomers();
	Collection <Beneficiary> getAllBeneficiaries();
	
	List<Account> getAccountsByCustomerId (int customerID);
	List<Transaction> getTransactionsByAccountId (int accountID);
	List<Beneficiary> getBeneficiariesByCustomerId (int customerID);

}
