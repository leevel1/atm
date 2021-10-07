package bank;

import java.util.Scanner;

/**
 * SimpleAtm class
 * 
 * @author Leena
 *
 */
public class SimpleAtm implements Atm {

	public void menu() {
		
		BankManager manager = new BankManager();
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome to Bank ATM!\n");
			
			System.out.print("Please enter your Account Number:");
			String accountNumber = scanner.next();
			BankAccount account = null;
			int loginAttempt = 0;
			while (loginAttempt < 3) {
				System.out.print("Please enter your pin:");
				String pin = scanner.next();
				account = manager.validateLogin(accountNumber, pin);
				if (account != null) {
					break;
				}
				loginAttempt++;
			}
			if (account == null) {
				System.out.println("Sorry, too many invalid attempts. Please contact customer care to reset pin.");
			}
			else {
				System.out.println("Hello Bank customer!");
				boolean done = false;
				do {
					System.out.println("\nEnter 1 for current balance.\nEnter 2 for deposit.\nEnter 3 for withdrawal.\nEnter 4 to exit.");
					String temp = scanner.next();
					int action = 0;
					try {
						action = Integer.parseInt(temp);
					}
					catch (Exception e) {
						System.out.println("Please enter a valid action number.");
						continue;
					}
					switch(action) {
						case 1: 
							System.out.printf("Current Balance: $%.2f \n",account.getBalance());
							break;
						case 2: 
						case 3: 
							{
								if (action == 2) {
									System.out.print("Enter Deposit Amount:");
								}
								else {
									System.out.print("Enter Amount to Withdraw:");
								}
								String amountStr = scanner.next();
								double amount = account.getBalance();
								boolean valid = false;
								try {
									amount = Double.parseDouble(amountStr);
									valid = true;
								}
								catch (Exception e) {
									System.out.println("Please enter a valid decimal amount.");
								}
								if (valid) {
									if (amount <= 0) {
										System.out.println("Please enter a valid positive decimal amount.");
									}
									else {
										double amt = (action == 2)? amount : -1.0*amount;
										String msg = manager.adjustBalance(account, amt);
										if (msg != null) {
											System.out.println(msg);
										}
										else {
											System.out.printf("Successful Transaction. Current Balance: $%.2f \n", account.getBalance());
										}
									}
								}
								break;
							}
						case 4:
						{
							System.out.println("Thank you for using the ATM. Have a nice day!");
							done = true;
							break;
						}	
						default:
							System.out.println("Please enter a valid action number.");
					}
			 	}
				while (!done);
			}
		}
	}
	
}
