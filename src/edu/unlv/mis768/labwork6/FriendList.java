package edu.unlv.mis768.labwork6;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendList {
	public static void main(String[] args) {
	      // Create an ArrayList to hold some names.
	      ArrayList<String> nameList = new ArrayList<String>();
	      
	      // Scanner object for keyboard input
	      Scanner keyboard = new Scanner(System.in);
	      
	      // variable for name to be entered by the user
	      String friendName="";
	      
	      // use a do-while loop to get the names
	      do {
	    	  // prompt and get the name string
	    	  System.out.print("Please enter a name (empty to end): ");
	    	  friendName = keyboard.nextLine();
	    	  
	    	  // add the name to the ArrayList
	    	  nameList.add(friendName);
	    	  
	      } while(!friendName.equals("")); // repeat if the name is not empty	      
	      
	      // remove the last element (i.e., the empty string)
	      nameList.remove("");
	      
	      // Display the size of the ArrayList.
	      System.out.println("The ArrayList has " +nameList.size()+ " objects stored in it.");

	      // Now display the items in nameList. This is printing the entire ArrayList object
	      //System.out.println(nameList);
	      
	      nameList.forEach((friend) -> System.out.println(friend));


	      
	}
}

