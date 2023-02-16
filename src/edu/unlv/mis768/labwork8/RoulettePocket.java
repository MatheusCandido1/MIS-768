package edu.unlv.mis768.labwork8;

import java.util.Random;

public class RoulettePocket {
	private int number;
	
	public RoulettePocket() {
		Random rand = new Random();
		int num = rand.nextInt(37);
		number = num;
	}
	
	public RoulettePocket(int num) {
		number = num;
	}
	
	/*public void setNumber(String numStr) {
		number = Integer.parseInt(numStr);
	}*/
	
	public void setNumber(int num) {
		this.number = num;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getColor() {
		String color = "green";
		
		if((number >= 1 && number <= 10) || (number >= 19 && number <= 28))
			if(number % 2 == 0)
				color = "black";
			else
				color = "red";
		
		if((number >= 11 && number <= 18) || (number >= 29 && number <= 36))
			if(number % 2 != 0)
				color = "black";
			else
				color = "red";
		
		
		return color;
	}

}
