package edu.unlv.mis768.labwork8;

import java.util.Random;

public class RoulettePocketDemo {
	   public static void main(String [] args)   {
	
		   for(int i = 0; i<10; i++) {
			   // set the number
			   RoulettePocket pocket = new RoulettePocket();
			   System.out.println("The color of the pocket " + pocket.getNumber() +" is: " + pocket.getColor());
		   }
		   // print out the number and color for testing
		   
	   }
}
