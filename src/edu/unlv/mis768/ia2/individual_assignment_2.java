package edu.unlv.mis768.ia2;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.DecimalFormat;


public class individual_assignment_2 {

    static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) throws IOException {

		Scanner kb = new Scanner(System.in);
		
		char insertCourse;
		int counter = 1;

		System.out.println("This program prints the transcript and calculates the GPA, based on the courses entered");
		System.out.println("Please enter the courses below.");
		
		ArrayList<Course> courses = new ArrayList<Course>();
		
		do {
			Course course = new Course();
			
			System.out.print("Number of course " + counter +  ":");
			course.setNumber(kb.next().toUpperCase());
			

			System.out.print("Credit Hours of course " + counter +  ":");
			course.setCredits(kb.nextInt());
			

			System.out.print("Letter grade of course " + counter +  ":");
			course.setGrade(kb.next().toUpperCase());
			
			courses.add(course);
			
			
			System.out.println("More courses? (Y/N)");
			insertCourse = kb.next().toUpperCase().charAt(0);
			
			counter++;
			
		} while(insertCourse == 'Y');
		
		double gpa = calculateGPA(courses);
		
		System.out.print("The GPA is " + df.format(gpa));
		
		char saveInFile;
		
		System.out.print("Would you like to save the result to a file (Y/N)");
		
		saveInFile = kb.next().toUpperCase().charAt(0);
		
		if(saveInFile == 'Y') {
			String fileName;
			System.out.print("Please enter the file name for the transcript:");
			fileName = kb.next();
			
			generateFileWithRecords(courses, fileName, gpa);
			
		}
		
		
		
	}
	
	private static void generateFileWithRecords(ArrayList<Course> courses, String fileName, double gpa) throws IOException  {
		PrintWriter outputFile = new PrintWriter(fileName);

		outputFile.println("COURSE\t\tCREDIT\t\tGRADE\t\tGRADE POINT");
		
		courses.forEach((course) -> outputFile.println(course.getNumber()+"\t\t\t"+course.getCredits()+"\t\t\t"+course.getGrade()+"\t\t\t"+course.getPoints()));
		
		outputFile.println("=========================");
		outputFile.println("GPA: " + df.format(gpa));
		outputFile.close();
		
	}
	
	private static double calculateGPA(ArrayList<Course> courses) {
		double sumOfPointsTimesCredits = 0.00;
		
		int totalCreditHours = 0;
		
		
		
		for(int i = 0; i < courses.size(); i++) {
			if(courses.get(i).getCredits() > 0) {
				totalCreditHours += courses.get(i).getCredits();
				sumOfPointsTimesCredits += courses.get(i).getPoints() * courses.get(i).getCredits();
			} 
		}
		
		if(totalCreditHours == 0) return 0.00;
		
		double gpa = sumOfPointsTimesCredits / totalCreditHours;
		
		return gpa;
		
	}

}
