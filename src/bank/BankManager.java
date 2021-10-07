package bank;

public class BankManager {
	
	/**
	 * Allow login for any account number string and any 4 digit combination for pin
	 * with starting balance of 1000
	 * 
	 * @param accountNumber
	 * @param pin
	 * @return
	 */
	public BankAccount validateLogin(String accountNumber, String pin) {
		int length = (pin != null)? pin.length() : 0;
		if (length != 4) {
			System.out.println("Invalid pin");
		}
		else {
			int pinNumber = 0;
			try {
				pinNumber = Integer.parseInt(pin);
			}
			catch (Exception e) {
				System.out.println("Invalid pin");
			}
			if (pinNumber > 0) {
				return new BankAccount(accountNumber, 1000);
			}
		}
		return null;
	}
	
	
	/**
	 * Deposit / withdraw amount to the account. No need to maintain minimum balance.
	 * 
	 * @param account
	 * @param amount
	 * @return
	 */
	public String adjustBalance(BankAccount account, double amount) {
		String msg = null;
		if (account != null) {
			if (account.getBalance() + amount < 0) {
				msg = "Insufficient funds in the account. Please check balance.";
			}
			else {
				account.setBalance(account.getBalance() + amount);
			}
		}
		return msg;
	}

}
