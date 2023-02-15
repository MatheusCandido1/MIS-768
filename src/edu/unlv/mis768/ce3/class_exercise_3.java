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
		
		System.out.print("Please enter the nunmber of quesitons missed for the first test: ");
		numMissed = kb.nextInt();
		
		test1.setNumMissed(numMissed);
		
		System.out.println("The test includes " + test1.getNumQuestion() + " question(s); Each question is " + test1.getPointsEach() + " points.");

		System.out.println("The test-maker missed " + test1.getNumMissed() + " question(s).");
		
		System.out.println("The score is " + test1.getScore()); 
		//System.out.println("The score of the test tests are not the same");
	}

}
