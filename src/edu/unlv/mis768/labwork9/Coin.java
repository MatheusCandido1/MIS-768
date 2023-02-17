package edu.unlv.mis768.labwork9;

import java.util.Random;

public class Coin {
	String sideUp;
	
	public Coin() {
		toss();
	}

	public String getSideUp() {
		return sideUp;
	}

	public void setSideUp(String sideUp) {
		this.sideUp = sideUp;
	}
	
	public void toss() {

		Random rand = new Random();
		if (rand.nextInt(2)==0) 
			sideUp = "Heads";
		else 
			sideUp = "Tails";
	}
	
}
