package bankaccountapp;

import java.util.ArrayList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<Account>();
		
		//Read a CSV File, then create new accounts based on that data
		String file = "C:\\Users\\ragha\\Desktop\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, ssn, initDeposit));
			}
			else if (accountType.equals("Checking")){
				accounts.add(new Checking(name, ssn, initDeposit));
			}
			else {
				System.out.println("EROR READING ACCOUNT TYPE");
			}
		}
		
		for (Account acc : accounts) {
			System.out.println("\n**********************");
			acc.showInfo();
		}
	}

}
