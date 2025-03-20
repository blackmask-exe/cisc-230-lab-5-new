package BankPackage;

import java.util.ArrayList;

abstract class BankAccount implements TransactionLogger {
	/*
	 * Attributes: o accountNumber (Unique identifier) o holderName (Customer's
	 * name) o balance (Current balance) • Methods: o deposit(double amount) o
	 * withdraw(double amount) o getBalance() o displayAccountInfo()
	 */
	static int accountTotal=0;
	protected int accountNumber;
	String holderName; // (Customer's name)
	double balance; // (Current balance)
	public ArrayList<String> logHistory = new ArrayList<>();
	public String accountType;

	public void deposit(double amount) {
		this.balance += amount;
		this.logTransaction("money deposited: +$" + amount);
		System.out.println("Deposit successful. New balance: $" + balance);
	}

	public abstract void withdraw(double amount);

	public void getBalance() {
		System.out.println("your balance is : $" + balance);
	}

	public void displayAccountInfo() {
		System.out.println("Account Details\nAccount number: " + this.accountNumber + "\nAccount holder: " + this.holderName
				+ "\nAccount Type: " + this.accountType + "\nBalance: $" + this.balance);
	}
	
	// getter method
	public int getAccountNumber () {
		return this.accountNumber;
	}
	
	@Override
	public void logTransaction(String message) {
		logHistory.add(message);
	}
}

