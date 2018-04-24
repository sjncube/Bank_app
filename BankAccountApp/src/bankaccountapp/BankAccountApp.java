package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

/**
 * created by Sizwe Ncube
 */
public class BankAccountApp {
	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		//UNIT TESTING
		/*Checking checkingAcc = new Checking("Sizwe Ncube", "378541268", 1200.00);
		Savings savingsAcc = new Savings("Duduzile Mahlangu", "412365478", 2800.00);
		
		savingsAcc.compound();
		
		System.out.println("----------------------------");
		checkingAcc.showInfo();
		System.out.println("----------------------------");
		savingsAcc.showInfo();
		System.out.println("----------------------------");
		*/
		
		//read a .csv file then create new accounts with the information on the file
		String file = "src/utilities/NewBankAccounts.csv";
		List<String[]> newaccounts = utilities.CSA.read(file);
		for (String[] accountHolder : newaccounts){
			
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			//System.out.println(name + " "+ sSN + " "+ accountType + " R" + initDeposit);
			if (accountType.equals("Savings")){
				accounts.add(new Savings(name, sSN, initDeposit));
			}else if (accountType.equals("Checking")){
				accounts.add(new Checking(name, sSN, initDeposit));
			}else {
				System.out.println("Error opening account");
			}
		}
		for (Account acc : accounts) {
			System.out.println("----------------------------");
			acc.showInfo();
		}
	}
}