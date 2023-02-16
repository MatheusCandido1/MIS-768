package edu.unlv.mis768.labwork8;

public class SavingsAccount {
	
	private double interestRate;
	private double balance;
	
	public SavingsAccount() {}
	
	public SavingsAccount(double bal, double ir) {
		this.setBalance(bal);
		this.setInterestRate(ir);
	}
	
	public SavingsAccount(String rateStr, String balStr) {
		this.setBalance(balStr);
		this.setInterestRate(rateStr);
	}

	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(String interestRate) {
		double iRate = Double.parseDouble(interestRate);
		setInterestRate(iRate);
	}
	
	public void setInterestRate(double interestRate) {
		if (interestRate < 0)
			this.interestRate = 0;
		if (interestRate > 0.01) 
			this.interestRate = interestRate / 100;
		else 
			this.interestRate = interestRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(String balStr) {
		double bal = Double.parseDouble(balStr);
		setBalance(bal);
	}
	
	private void setBalance(double balance) {
		if (balance < 0) 
			this.balance = balance;
		else
			this.balance = balance;
	}
	
	public void deposit(String strAmount) {
		double amount = Double.parseDouble(strAmount);
		deposit(amount);
	}
	
	public void deposit(double amount) {
		if(amount > 0)
			this.balance += amount;
	}
	
	public void withdraw(String strAmount) {
		double amount = Double.parseDouble(strAmount);
		withdraw(amount);
	}
	
	public void withdraw(double amount) {
		if(amount > 0)
			this.balance -= amount;
	}
	public void addInterest() {
		this.balance += this.balance * this.interestRate;
	}
}
