package bank;

/**
 * BankAccount class
 * 
 * @author Leena
 *
 */
public class BankAccount {
	
	private String number;
	private String pin;
	private double balance;
	
	
	public BankAccount(String number, double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}
	
	public String getNumber() {
		return this.number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPin() {
		return this.pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}
