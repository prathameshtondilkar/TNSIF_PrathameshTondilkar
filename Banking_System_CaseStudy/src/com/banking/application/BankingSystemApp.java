package com.banking.application;
import java.util.List;
import java.util.Scanner;

import com.banking.entity.*;
import com.banking.service.*;


public class BankingSystemApp {
	
	public static void main ( String[] args) {
		
		BankingServices bankingService = new BankingServiceImplement();
		int transactionID;
		int accountID;
		int customerID;
		String type;
		double balance;
		int beneficiaryID;
		String name;
		String accountNumber;
		String address;
		String contact;
		String bankDetails;
		double amount;
		
		int ch;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Banking  System  ");
			System.out.println("1. Add Customers  ");
			System.out.println("2. Add Accounts  ");
			System.out.println("3. Add Beneficiaries  ");
			System.out.println("4. Add Transactions ");
			System.out.println("5. Find Customer by id ");
			System.out.println("6. List all Accounts of Specific Customer ");
			System.out.println("7. List all Transactions of Specific Account");
			System.out.println("8. List all Beneficiaries of Specific Customer ");
			System.out.println("9. List all Accounts ");
			System.out.println("10. Exit ");
			System.out.println("Enter your choice  :");
			ch=sc.nextInt();
			switch(ch) {
			
			case 1 :
				System.out.println("Enter Customer Details");
				System.out.println("Customer Id : ");
				customerID = sc.nextInt();
				sc.nextLine();
				System.out.println("Name : ");
				name = sc.nextLine();
				System.out.println("Address : ");
				address = sc.nextLine();
				System.out.println("Contact No. : ");
				contact = sc.nextLine();
				Customer c =new Customer(customerID,name,address,contact);
				bankingService.addCustomer(c);
				break;
			
			case 2:
				System.out.println("Enter Account Details");
				System.out.println("Account  Id : ");
				accountID = sc.nextInt();
				System.out.println("Customer Id : ");
				customerID = sc.nextInt();
				sc.nextLine();
				System.out.println("Account Type Saving / Current  : ");
				type = sc.nextLine();
				System.out.println("Balance : ");
				balance = sc.nextDouble();
				Account acc=new Account(accountID,customerID,type,balance);
				bankingService.addAccount(acc);
				break;
				
			case 3 :
				System.out.println("Enter Customer Details");
				System.out.println("Customer Id : ");
				customerID = sc.nextInt();
				sc.nextLine();
				System.out.println("Beneficiary Id : ");
				beneficiaryID = sc.nextInt();
				System.out.println("Beneficiary Name : ");
				name = sc.nextLine();
				System.out.println("Beneficiary Account No. : ");
				accountNumber = sc.nextLine();
				System.out.println("Beneficiary Bank Details : ");
				bankDetails= sc.nextLine();
				Beneficiary b =new Beneficiary(customerID,beneficiaryID,name,accountNumber,bankDetails);
				bankingService.addBeneficiary(b);
				break;
				
			case 4 :
				System.out.println("Enter Transaction Details");
				System.out.println("Transaction Id : ");
				transactionID = sc.nextInt();
				accountID = sc.nextInt();
				sc.nextLine();
				System.out.println(" Type Deposit / Withdrawal  : ");
				type = sc.nextLine();
				System.out.println("Account Amount : ");
				amount = sc.nextDouble();
				Transaction t=new Transaction(transactionID, accountID,type,amount);
				bankingService.addTransaction(t);
				break;
				
			case 5 :
				for(Customer customer :bankingService.getAllCustomers()) {
					System.out.println("Customer ID: "+ customer.getCustomerID());
				}
				System.out.println("Customer ID :");
				customerID = sc.nextInt();
				Customer foundCustomer = bankingService.findCustomerById(customerID);
				System.out.println("Customer: "+ foundCustomer.getName()+"Address: "+foundCustomer.getAddress()+"Contact:"+foundCustomer.getContact());
				break;
				
			case 6 :
				System.out.print("Customer Id: ");
				customerID =sc.nextInt();
				
				List<Account> customerAccounts = bankingService.getAccountsByCustomerId(customerID);
				System.out.println("Accounts for Customer ID:"+customerID);
				for(Account account : customerAccounts) {
					System.out.println("Account ID :"+account.getAccountID()+"Customer ID: "+account.getCustomerID()+"Type: "+account.getType()+"Balance: "+account.getBalance());
				}
				break;
				
			case 7 :
				System.out.print("Account Id: ");
				accountID =sc.nextInt();
				
				List<Transaction> accountTransactions = bankingService.getTransactionsByAccountId(accountID);
				System.out.println("Transactions for Account ID:"+accountID);
				for(Transaction transaction : accountTransactions) {
					System.out.println("Transaction ID :"+transaction.getTransactionID()+"Account ID :"+transaction.getAccountID()+"Type :"+
				transaction.getType()+"Amount :"+transaction.getAmount());
				}
				break;
				
			case 8 :
				for(Beneficiary beneficiary :bankingService.getAllBeneficiaries()) {
					System.out.println("Benefciary ID: "+ beneficiary.getBeneficiaryID());
				}
				System.out.print("Customer Id: ");
				customerID =sc.nextInt();
				
				List<Beneficiary> accountBeneficiaries = bankingService.getBeneficiariesByCustomerId(customerID);
				System.out.println("Beneficiaries for Customer ID:"+customerID);
				for(Beneficiary beneficiary: accountBeneficiaries) {
					System.out.println("Beneficiary ID :"+beneficiary.getBeneficiaryID()+"Customer ID :"+beneficiary.getCustomerID()+"Name:"+
							beneficiary.getName()+"Account No. :"+beneficiary.getAccountNumber());
				}
				break;
				
			case 9 :
				System.out.println("__________Accounts________ ");
				for(Account account:bankingService.getAllAccounts()) {
					System.out.println("Account ID: "+ account.getAccountID());
				}
				
				break;
				
			case 10 :
				System.out.println("__________Thank You________ ");
				
				break;
				
			default:
				System.out.println("__________Invalid Choice________ ");
				
				
					
				
			}
		
		}while(ch!=10);
	}

}
