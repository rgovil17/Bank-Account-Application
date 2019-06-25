package bankaccountapp;

// The parent class for both the Savings & Checking accounts
// This class is defined as abstract as we'll not create objects of this class
// Also, it implements the interface IBaseRate to access the base rate
public abstract class Account implements IBaseRate {
	
	private static int index = 10000;

	// List common properties for both savings and checking accounts
	private String name;
	private String ssn;
	private double balance;

	protected String accNum;
	protected double rate;

	// Constructor to set base properties and initialize the account
	public Account(String name, String ssn, double initDeposit) {
		this.index++;
		this.name = name;
		this.ssn = ssn;
		this.balance = initDeposit;
		
		//Set account number
		this.accNum = this.setAccountNum();
		
		// Set the base rate
		this.setRate();
	}

	// Generating the account number
	private String setAccountNum() {
		String lastTwoSsn = ssn.substring(ssn.length() - 2);
		int uniqueFive = index;
		int randThree = (int) (Math.random() * 1000);
		return lastTwoSsn + uniqueFive + randThree;
	}

	// An abstract method to set the base rate depending upon the account type
	public abstract void setRate();

	// List common methods
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("Depositing $" + amount);
		this.printBalance();
	}

	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.println("Withdrawing $" + amount);
		this.printBalance();
	}

	public void transfer(String toWhere, double amount) {
		this.balance -= amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		this.printBalance();
	}
	
	public void compound() {
		double accruedInterest = this.balance * (this.rate / 100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $"+accruedInterest);
		this.printBalance();
	}

	public void printBalance() {
		System.out.println("Your Balance: " + this.balance);
	}
	
	public void showInfo() {
		System.out.println("NAME: " + this.name + "\nACCOUNT NUMBER: " + this.accNum + "\nBALANCE: " + this.balance
				+ "\nRATE: " + this.rate + "%");
	}
}
