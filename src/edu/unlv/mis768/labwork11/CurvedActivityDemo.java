package edu.unlv.mis768.labwork11;
import java.util.Scanner;

public class CurvedActivityDemo {

	public static void main(String[] args) {
	      double score;         // Raw score
	      double curvePercent;  // Curve percentage

	      // Create a Scanner object to read keyboard input.
	      Scanner keyboard = new Scanner(System.in);

	      // Get the unadjusted exam score.
	      System.out.print("Enter the student's raw numeric score: ");
	      score = keyboard.nextDouble();

	      // Get the curve percentage.
	      System.out.print("Enter the curve percentage: ");
	      curvePercent = keyboard.nextDouble();

	      // Create a CurvedActivity object
	      CurvedActivity curvedActivity = new CurvedActivity(curvePercent);
	      
	      // Set the exam score
	      curvedActivity.setScore(score);
	      
	      // Display the raw score
	      System.out.println("The original score is " + curvedActivity.getRawScore());
	      
	      // Display the curved score
	      System.out.println("The curved score is " + curvedActivity.getScore());
	      
	      // Display the exam grade
	      System.out.println("The curved grade is " + curvedActivity.getGrade());
	      
	}

}
