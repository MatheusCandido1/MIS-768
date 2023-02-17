package edu.unlv.mis768.ce3;

import java.util.Scanner;

public class class_exercise_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		
		int numQuestions;
		int numMissed;
		 
		System.out.print("Please enter the number of questions for the first test: ");

		numQuestions = kb.nextInt();
		Test test1 = new Test(numQuestions);
		
		System.out.print("Please enter the number of quesitons missed for the first test: ");
		numMissed = kb.nextInt();
		
		test1.setNumMissed(numMissed);

		System.out.println(test1);

		System.out.print("Please enter the number of questions for the second test: ");
		numQuestions = kb.nextInt();
		
		Test test2 = new Test(numQuestions);
		System.out.print("Please enter the number of quesitons missed for the second test: ");
		numMissed = kb.nextInt();
		
		test2.setNumMissed(numMissed);
		
		System.out.println(test2);
		
		
		if(test1.equals(test2))
			System.out.print("The scores of the tests are the same");
		else
			System.out.print("The scores of the tests are not the same");
		
	}

}
