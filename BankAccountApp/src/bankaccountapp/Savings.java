package bankaccountapp;

public class Savings extends Account {
	private	int safetyDepositBoxID;
	private	int safetyDepositBoxKey;
	
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accNumber = "1"+ accNumber;
		setSafetyDepositBox();
	}
	
	@Override
	public void setRate() {
		intRate = getBaseRate() - 0.25;
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int)(Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey = (int)(Math.random()*Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("Account Type: Savings");
		super.showInfo();
		System.out.println("Safety Deposit Box ID: "+safetyDepositBoxID+
				"\nSafety Deposit Box PIN: "+safetyDepositBoxKey);
	}

	public double getBaseRate() {
		return 2.5;
	}

	
}