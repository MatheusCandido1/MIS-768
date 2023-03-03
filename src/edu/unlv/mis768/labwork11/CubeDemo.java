package edu.unlv.mis768.labwork11;

import java.util.Scanner;

public class CubeDemo {

	public static void main(String[] args) {
	      double length;  // The cube's length
	      double width;   // The cube's width
	      double height;  // The cube's height

	      // Create a Scanner object for keyboard input.
	      Scanner keyboard = new Scanner(System.in);
	      
	      // Get cube's length.
	      System.out.println("Enter the dimensions of a cube:");
	      System.out.print("Length: ");
	      length = keyboard.nextDouble();
	      
	      // Get the cube's width.
	      System.out.print("Width: ");
	      width = keyboard.nextDouble();
	      
	      // Get the cube's height.
	      System.out.print("Height: ");
	      height = keyboard.nextDouble();
		
	      // Create a Cube object and pass the dimensions to the constructor
	      Cube c = new Cube(length, width, height);
	      
	      // Display the cube's properties
	      System.out.println("Length: " + c.getLength());
	      System.out.println("Width: " + c.getWidth());
	      System.out.println("Height: " + c.getHeight());
	      System.out.println("Volume: " +c.getVolume());
	}

}
