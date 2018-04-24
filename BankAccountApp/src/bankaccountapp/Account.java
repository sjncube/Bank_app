package bankaccountapp;

public abstract class Account implements IBaseRate{
	//common properties for savings and checking accounts
	private		String		name;
	private		String		sSN;
	private		double		balance;
	private		static	int index = 30000;
	protected	double	intRate;
	protected	String	accNumber;
	
	
	//Constructor to initialize and set base properties
	public Account(String name, String sSN, double initDeposit){
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		
		this.accNumber = setAccNumber();
		setRate();
	}
	
	private String setAccNumber() {
		index++;
		String lastTwoDigitsSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int random = (int)(Math.random()* Math.pow(10, 3));
		return lastTwoDigitsSSN + uniqueID + random;
	}
	
	
	
	public abstract void setRate();
	
	public void compound() {
		double accruedInterest = balance * (intRate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest is R"+ accruedInterest);
	}
	
	//common methods
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("R" + amount + " deposited in to account.");
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("R" + amount + " withdrawn from account.");
	}
	
	public void transfer(double amount, String toWhere) {
		balance = balance - amount;
		System.out.println("R" + amount + " transfered to "+ toWhere );
	}
	
	public void showInfo() {
		System.out.println("NAME: "+ name+
				"\nACCOUNT NUMBER: "+ accNumber+
				"\nBALANCE: R"+ balance+
				"\nRate: "+ intRate + "%");		
	}
}