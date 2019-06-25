package bankaccountapp;

// This class inherits the Account class
public class Savings extends Account {
	
	//List properties specific to a Savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	//Constructor to initialize savings account properties
	public Savings(String name, String ssn, double initDeposit) {
		
		// Calling the super constructor of the parent class
		super(name, ssn, initDeposit);
		
		// Completing the account number
		this.accNum = "1" + this.accNum;
		
		// Setting up the Safety Deposit Box features
		this.setSafetyDepositBox();
	}
	
	@Override
	// Implements the abstract method of the parent class
	public void setRate() {
		this.rate = getBaseRate() - 0.25;
	}
		
	//List any methods specific to the savings account
	private void setSafetyDepositBox() {
		this.safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		this.safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println("Your Savings Account Features: "
				+ "\n  Safety Deposit Box ID: " + this.safetyDepositBoxID
				+ "\n  Safety Deposit Box Key: " + this.safetyDepositBoxKey);
	}
}
