package edu.unlv.mis768.labwork13;

import java.util.Scanner;

public class BankAccountDemo2 {

	public static void main(String[] args) {
		// Scanner object for keyboard input
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter the starting balance of the account:");
		double balance = kb.nextDouble();
		
		try {
			BankAccount account = new BankAccount(balance);
			
			// get the amount for deposit
			System.out.println("Please enter the amount to deposit:");
			double amount =kb.nextDouble();
			try {
				account.deposit(amount);
			} catch (NegativeAmount e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			// get the amount with withdraw
			System.out.println("Please enter the amount to withdraw:");
			amount=kb.nextDouble();
			try {
				account.withdraw(amount);
			} catch (NegativeAmount | Overdraft e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		catch(NegativeStartingBalance e) {
			System.out.println(e.getMessage());
		}


	}

}
