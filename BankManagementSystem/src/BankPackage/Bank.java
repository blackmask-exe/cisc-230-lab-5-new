package BankPackage;
import java.util.ArrayList;

public class Bank {
	static ArrayList<BankAccount> bankAccountArray = new ArrayList<>();

	public void createAccount(String holderName, double balance, int type) {
	
		switch(type) {
			case 1:
				CheckingAccount checkingAccount = new CheckingAccount(holderName, balance);
				bankAccountArray.add(checkingAccount);
				break;
				
			case 2:
				SavingAccount savingAccount = new SavingAccount(holderName, balance);
				if (savingAccount.holderName == null) {
					break;
				}
				bankAccountArray.add(savingAccount);
				break;
				
			default:
				System.out.println("Invalid option, please create an account again with the proper inputs");
		}
				
		
	}
	
	public void deposit (int accountNumber, double amount) {
		for (BankAccount currentAccount : bankAccountArray) {
			if (currentAccount.getAccountNumber() == accountNumber) {
				currentAccount.deposit(amount);
			}
		}
	}
	
	public void withdraw (int accountNumber, double amount) {
		for (BankAccount currentAccount : bankAccountArray) {
			if (currentAccount.getAccountNumber() == accountNumber) {
				currentAccount.withdraw(amount);
			}
		}
	}
	
	public void transferFunds (int fromAccount, int toAccount, double amount) {
		BankAccount toAccountObject = null;
		BankAccount fromAccountObject = null;
		for (BankAccount currentAccount: bankAccountArray) {
			if (currentAccount.getAccountNumber() == fromAccount) {
				fromAccountObject = currentAccount;
			}else if (currentAccount.getAccountNumber() == toAccount) {
				toAccountObject = currentAccount;
			}
		}
		
		if (toAccountObject != null  && fromAccountObject != null) {
			fromAccountObject.withdraw(amount);
			toAccountObject.deposit(amount);
		}
	}
	
	public void viewTransactionHistory (int accountNumber) {
		for (BankAccount currentAccount: bankAccountArray) {
			if (currentAccount.getAccountNumber() == accountNumber) {
				for (String transactionLog: currentAccount.logHistory) {
					System.out.println(transactionLog);
				}
			}
		}
	}

	
	
	
	

}
