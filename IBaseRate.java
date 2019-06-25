package bankaccountapp;

public interface IBaseRate {
	
	// Return the base rate
	default double getBaseRate() {
		return 2.5;
	}
	
}
