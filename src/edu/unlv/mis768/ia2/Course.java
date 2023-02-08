/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to create a class named Course that will be used in the Main class. This class
 * will have private fields for the course number, credits, grade, and points. It will also have a constructor, get and set
 * methods for the course number, credits, and grade. It will also have a method to convert the grade to points.
 * Date: 02/08/2023
 */

package edu.unlv.mis768.ia2;

// Create a class named Course
public class Course {
	// Create private fields for the course number, credits, grade, and points
	private String number;
	private int credits;
	private String grade;
	private double points;
	
	// Create a constructor
	public Course() {}

	// Create get methods for the course number
	public String getNumber() {
		return number;
	}
	// Create set methods for the course number
	public void setNumber(String number) {
		this.number = number;
	}
	// Create get methods for the credits
	public int getCredits() {
		return credits;
	}
	// Create set methods for the credits
	public void setCredits(int credits) {
		this.credits = credits;
	}
	// Create get methods for the grade
	public String getGrade() {
		return grade;
	}
	// Create set methods for the grade
	public void setGrade(String grade) {
		this.grade = grade;
		// Call the convertGradeToPoints method when the grade is set
		convertGradeToPoints(grade);
	}
	
	// Create a method to convert the grade to points
	private void convertGradeToPoints(String grade) {
		// Use if statements to convert the grade to points
		if(grade.equals("A") || grade.equals("A+")) {
			points = 4.0;
		} else if (grade.equals("A-")) {
			points = 3.7;
		} else if(grade.equals("B+")) {
			points = 3.3;
		} else if (grade.equals("B")) {
			points = 3.0;
		} else if (grade.equals("B-")) {
			points = 2.7;
		} else if (grade.equals("C+")) {
			points = 2.3;
		} else if (grade.equals("C")) {
			points = 2.0;
		} else if (grade.equals("C-")) {
			points = 1.7;
		} else if (grade.equals("D+")) {
			points = 1.3;
		} else if (grade.equals("D")) {
			points = 1.0;
		} else {
			points = 0.0;
		}
	}
	// Create a get method for the points
	public double getPoints() {
		return points;
	}
	

}
