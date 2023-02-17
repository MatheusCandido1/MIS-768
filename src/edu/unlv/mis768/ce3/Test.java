/*
 * Author: Matheus Candido Carvalho
 * Purpose: The porpuse of this program is to create the Test Class and its methods.
 * Date: 02/16/2023
 */
package edu.unlv.mis768.ce3;

// Create the Test class
public class Test {
	// Create the private variables
	private int numQuestion;
	private int numMissed;

	// Create the constructor
	public Test(int numQ) {
		if(numQ < 0) {
			this.numQuestion = 0;
		}
		else {
			this.numQuestion = numQ;
		}
	}
	// Create the get numQuestion method
	public int getNumQuestion() {
		return numQuestion;
	}
	// Create setNumMissed method
	public void setNumMissed(int numM) {
		// Checking if value is negative, if it is, set it to 0
		if (numM < 0) {
			this.numMissed = 0;
		}
		else {
			this.numMissed = numM;
		}
	}
	// Create getNumMissed method
	public int getNumMissed() {
		return numMissed;
	}
	// Create the getPointsEach method
	public double getPointsEach() {
		// Checking if numQuestion is 0, if it is, return 0.00
		if(this.getNumQuestion() == 0) {
			return 0.00;
		}
		// Calculating the points each question is worth
		double pointsEach = 100 / (double) this.getNumQuestion();
		 // Returning the points each question is worth
		return Math.round(pointsEach * 100)/100d;
	}
	// Create the getScore method
	public double getScore() {
		// Check if numQuestion is 0, if it is, return 0.00
		if(this.getNumQuestion() == 0) {
			return 0.00;
		}
		// calculate the score
		double score = 100 - (this.getNumMissed() * getPointsEach());
		// Return the score
		return Math.round(score * 100)/100d;
	}
	
	// Override the toString method
	public String toString() {
		return "The test includes " + this.numQuestion + " question(s); each question is " + this.getPointsEach() + " points. \n"
				+ "The test-maker missed " + this.numMissed + " question(s) \n"
						+ "The score is " + this.getScore();
	}
	// Override the equals method
	public boolean equals(Test t2) {
		// Check if the scores are equal by checking the scores are equal.
		if(t2.getScore() == this.getScore()) 
			return true;
		return false;
	}
}
