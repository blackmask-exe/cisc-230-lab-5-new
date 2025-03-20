package BankPackage;

public class SavingAccount extends BankAccount  {
//	String holderName;
	
	public SavingAccount (String holderName, double balance) {
		if (balance < 100) {
			System.out.println("Account cannot be created, min balance not met");
		} else {
			this.accountNumber = accountTotal;
			accountTotal += 1;
			this.balance = balance;
			this.holderName = holderName;
			this.accountType = "Saving";
			System.out.println("Savings account created with a balance of $" + this.balance);
			this.logTransaction("initial deposit: +$" + this.balance);
			this.applyInterest();

			

			
		}
	}
	
	public void applyInterest () {
		double oldBalance = this.balance;
		this.balance = 1.01 * this.balance; // applying an interest of 1%
		this.logTransaction("interest: +$" + oldBalance * 0.01);
	}
	
	public void withdraw (double amount) {
		if (amount > this.balance) {
			System.out.println("Insufficient funds!");
		} else {
			this.balance = this.balance - amount;
			this.logTransaction("withdraw: -$" + amount);
			System.out.println("Withdrawn $" + amount + ", Remaining: $" + this.balance)
;		}
	}
	

	
}
