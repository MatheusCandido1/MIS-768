package edu.unlv.mis768.labwork13;

import java.io.Serializable;

/**
   The BankAccount class simulates a bank account.
*/

public class BankAccount implements Serializable {
   private double balance;      // Account balance

   /**
    * This constructor sets the starting balance at 0.0.
    */
   public BankAccount()   {
      balance = 0.0;
   }
   
   /**
    * This constructor sets the starting balance to the value passed as an argument.
    * @param startBalance The starting balance.
    * @exception throw expection if value is negative
    */
   public BankAccount(double startBalance) throws NegativeStartingBalance {      
	  if(startBalance < 0) 
		  throw new NegativeStartingBalance(startBalance);
      balance = startBalance;
   }

   /**
    * The deposit method makes a deposit into the account.
    * @param amount The amount to add to the balance field.
    */
   public void deposit(double amount) throws NegativeAmount  {
	  if(amount < 0)
		  throw new NegativeAmount();
      balance += amount;
   }

   /**
    * The withdraw method withdraws an amount from the account.
    * @param amount The amount to subtract from the balance field.
    */
   public void withdraw(double amount) throws NegativeAmount, Overdraft {
		  if(amount < 0)
			  throw new NegativeAmount();
		  
		  if(amount > balance) 
			  throw new Overdraft();
		  
	      balance += amount;
	   }
   
   /**
    * The getBalance method returns the account balance.
    * @return The value in the balance field.
    */
   public double getBalance() {
      return balance;
   }
}
