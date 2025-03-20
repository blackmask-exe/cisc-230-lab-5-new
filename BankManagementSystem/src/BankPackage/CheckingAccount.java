package BankPackage;

public class CheckingAccount extends BankAccount  {
//	private String holderName;
	
	public CheckingAccount (String holderName, double balance) {
		this.accountNumber = accountTotal;
		accountTotal += 1;
		this.holderName = holderName;
		this.balance = balance;
		this.accountType = "Checking";
		System.out.println("Checking account created with a balance of $" + this.balance);
		this.logTransaction("initial deposit: +$" + this.balance);

		
	}
	
	public void chargeOverdraft () {
		this.balance = this.balance - 10; // charge $10 when overdraft is used
		this.logTransaction("overdraft: -$10");
	}
	
	public void withdraw (double amount) {
		if (this.balance - amount > 0) {
			this.balance = this.balance - amount;
			System.out.println("Successful without overdrafts");
			this.logTransaction("withdraw: -$" + amount);
			System.out.println("This block executed");
			
		} else if (this.balance - amount > -500) {
			this.balance = this.balance - amount;
			this.logTransaction("withdraw: -$" + amount);
			chargeOverdraft();
			System.out.println("Successfull with overdraft fee of $10");
		} else {
			System.out.println("No further overdraft, already past -$500");
		}
	}

	

	
}
