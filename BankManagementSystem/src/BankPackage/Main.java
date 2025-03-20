package BankPackage;
import java.util.Scanner;

public class Main {
	
	public static void clearScreen() {
		for (int i=0; i<50; i++) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();
		
		Main.clearScreen();

		
		
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("What action would you like to take? (enter number)");
			System.out.println("1. Create an account");
			System.out.println("2. Make a deposit");
			System.out.println("3. Withdraw money");
			System.out.println("4. Transfer money");
			System.out.println("5. Get account info");
			System.out.println("6. Get transaction history");
			System.out.println("7. Nevermind");

			System.out.println();
			
			int action = 0;

			
			try {
				action = scanner.nextInt();

			} catch(java.util.InputMismatchException err) {
				System.out.println("Please enter a number");
				
			}
			scanner.nextLine();

			
			switch (action) {
			case 1:
				System.out.println("Hi, what's your name?");
				String name = scanner.nextLine();
				
				System.out.println("What type of bank account would you like to open?");
				System.out.println("Type 1 for Checking, 2 for Saving");
				int accountType = 0;
				try {
					accountType = scanner.nextInt();

				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				
				scanner.nextLine();
				System.out.println("");
				
				System.out.println("How much would you like to deposit initially?");
				double initialDeposit = 0;
				try {
					 initialDeposit = scanner.nextDouble();

				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				
				scanner.nextLine();
				
				bank.createAccount(name, initialDeposit, accountType);
				if (accountType == 2 && initialDeposit < 100) {
					break;
				}
				System.out.println("Your account number is " + (bank.bankAccountArray.size() - 1) + ", please remember it");
				break;
				
			case 2:
				System.out.println("What account number would you like to deposit into?");
				int depositAccountNumber = 0;
				try {
					 depositAccountNumber = scanner.nextInt();
					
				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				
				scanner.nextLine();
				
				System.out.println("How much would you like to deposit?");
				double depositAmount = 0.0;
				try {
					 depositAmount = scanner.nextDouble();

				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				if (depositAccountNumber > bank.bankAccountArray.size() - 1 || depositAccountNumber < 0) {
					System.out.println("Please enter valid account number");
					break;
				}
				
				bank.deposit(depositAccountNumber, depositAmount);
				break;
				
			case 3:
				System.out.println("What account number would you like to withdraw from?");
				int withdrawAccountNumber = 0;
				
				try {
					 withdrawAccountNumber = scanner.nextInt();
					
				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				System.out.println("How much would you like to withdraw?");
				double withdrawAmount = 0;
				try {
					 withdrawAmount = scanner.nextDouble();

				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				if (withdrawAccountNumber > bank.bankAccountArray.size() - 1 || withdrawAccountNumber < 0) {
					System.out.println("Please enter valid account number");
					break;
				}
				
				bank.withdraw(withdrawAccountNumber, withdrawAmount);
				break;
			
			case 4:
				System.out.println("What account number would you like to withdraw from?");
				int fromAccountNumber = 0;
				try {
					 fromAccountNumber = scanner.nextInt();
					
				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				System.out.println("What account number would you like to deposit into?");
				int toAccountNumber = 0;
				try {
					toAccountNumber = scanner.nextInt();
					
				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				System.out.println("How much would you like to transfer?");
				double transferAmount = 0;
				try {
					 transferAmount = scanner.nextDouble();

				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				if (fromAccountNumber > bank.bankAccountArray.size() - 1 || toAccountNumber > bank.bankAccountArray.size() - 1) {
					System.out.println("Please enter valid account numbers");
					break;
				}
				
				bank.transferFunds(fromAccountNumber, toAccountNumber, transferAmount);
				break;
				
			case 5:
				System.out.println("Enter your bank account number please");
				int infoAccountNumber = 0;
				try {
					infoAccountNumber = scanner.nextInt();

				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				if (infoAccountNumber > bank.bankAccountArray.size() - 1) {
					System.out.println("Please enter valid account number");
					break;
				}
				
				bank.bankAccountArray.get(infoAccountNumber).displayAccountInfo();
				break;
				
			case 6:
				System.out.println("Enter your bank account number please");
				int historyAccountNumber = 0;
				try {
					 historyAccountNumber = scanner.nextInt();

				} catch(java.util.InputMismatchException err) {
					System.out.println("Please enter a number");
					break;
					
				}
				scanner.nextLine();
				
				if (historyAccountNumber > bank.bankAccountArray.size() - 1) {
					System.out.println("Please enter valid account number");
					break;
				}
				
				bank.viewTransactionHistory(historyAccountNumber);
				break;
				
			case 7:
				keepGoing = false;
				break;
				
			default:
				System.out.println("Please enter a valid option from the above list");
				
				
				
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");

		}
		scanner.close();

	}

}
