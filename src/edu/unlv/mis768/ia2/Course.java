package edu.unlv.mis768.ia2;

public class Course {
	private String number;
	private int credits;
	private String grade;
	private double points;
	
	public Course() {}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
		convertGradeToPoints(grade);
	}
	
	private void convertGradeToPoints(String grade) {
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
	
	public double getPoints() {
		return points;
	}
	

}
