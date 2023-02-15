package edu.unlv.mis768.ce3;

public class Test {
	private int numQuestion;
	private int numMissed;

	public Test(int numQ) {
		if(numQ < 0) {
			this.numQuestion = 0;
		}
		else {
			this.numQuestion = numQ;
		}
	}
	
	public int getNumQuestion() {
		return numQuestion;
	}

	public void setNumMissed(int numM) {
		if (numM < 0) {
			this.numMissed = 0;
		}
		else {
			this.numMissed = numM;
		}
	}

	public int getNumMissed() {
		return numMissed;
	}
	
	public double getPointsEach() {
		if(this.getNumQuestion() == 0) {
			return 0.00;
		}
		double pointsEach = 100 / (double) this.getNumQuestion();
		return Math.round(pointsEach * 100)/100d;
	}
	
	public double getScore() {
		if(this.getNumQuestion() == 0) {
			return 0.00;
		}
		double score = 100 - (this.getNumMissed() * getPointsEach());
		return Math.round(score * 100)/100d;
	}
	  
	
	
	
	
	
	

}
