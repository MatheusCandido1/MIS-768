package edu.unlv.mis768.labwork13;

import java.io.*;

/**
   This program deserializes the objects in the Objects.dat
   file and stores them in an array.                        
*/

public class DeserializeObjects{
   public static void main(String[] args)throws Exception   {
      double balance;            // An account balance
      final int NUM_ITEMS = 3;   // Number of accounts
  
      // Create the stream objects.
      FileInputStream fstream = new FileInputStream("account.dat");
      ObjectInputStream objStream = new ObjectInputStream(fstream);
	  

      // Create a BankAccount array
      BankAccount[] accounts = new BankAccount[NUM_ITEMS];
      
      // Read the serialized objects from the file.
      for (int i = 0; i < accounts.length; i++)      {
         accounts[i] = (BankAccount) objStream.readObject();
      }
      
      // Close the file.
      objStream.close();
      
      // Display the objects.
      for (int i = 0; i < accounts.length; i++)      {
         System.out.println("Account " + (i + 1) + " $ " + accounts[i].getBalance());
      }
   }
}
