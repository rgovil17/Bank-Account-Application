package bankaccountapp;

//This class inherits the Account class
public class Checking extends Account {
	
	// List properties specific to a Checking account
	private long debitCardNum;
	private int debitCardPIN;
	
	// Constructor to initialize checking account properties
	public Checking(String name, String ssn, double initDeposit) {
		
		// Calling the super constructor of the parent class
		super(name, ssn, initDeposit);
		
		// Completing the account number
		this.accNum = "2" + this.accNum;
		
		// Setting up the Debit Card features
		this.setDebitCard();
	}
	
	@Override
	// Implements the abstract method of the parent class
	public void setRate() {
		this.rate = getBaseRate() * 0.15;
	}

	// List any methods specific to the checking account
	private void setDebitCard() {
		this.debitCardNum = (long) (Math.random() * Math.pow(10, 12));
		this.debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println("Your Checking Account Features: "
				+ "\n  Debit Card Number: " + this.debitCardNum
				+ "\n  Debit Card PIN: " + this.debitCardPIN);
	}
	
	
}
