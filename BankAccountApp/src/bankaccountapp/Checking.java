package bankaccountapp;

public class Checking extends Account{
	private	int debitCardNumber;
	private	int debitCardPin;
	
	//constructor for name SSN(Social Security number) and the initial deposit
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accNumber = "2" + accNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		intRate = getBaseRate() * 0.15;
	}
	
	private void setDebitCard() {
		debitCardNumber = (int)(Math.random()*Math.pow(10, 13));
		debitCardPin = (int)(Math.random()*Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("Account Type: Check");
		super.showInfo();
		System.out.println("Debit Card Number: "+debitCardNumber+
				"\nDebit Card Pin: " + debitCardPin);
	}

	public double getBaseRate() {
		return 2.5;
	}
}