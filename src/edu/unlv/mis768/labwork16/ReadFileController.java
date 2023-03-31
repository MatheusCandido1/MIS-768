package edu.unlv.mis768.labwork16;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

	public class ReadFileController {

	    @FXML
	    private Label fileNameLabel;

	    @FXML
	    private Button browseButton;

	    @FXML
	    private Button calculateButton;

	    @FXML
	    private Label resultLabel;
		
		// method for initializing the window
		public void initialize() {
    	
		}
	    
	    public void browseButtonListener() {
	    	// Instantiate the object of FileChoose
	    	FileChooser chooser = new FileChooser();
	    	// Set the title 
	    	chooser.setTitle("Open File");
	    	
	    	// The showOpenDialog() method need to know which window it belongs to
	    	File dataFile = chooser.showOpenDialog(browseButton.getScene().getWindow());
	    	
	    	// if a file is selected
	    	if(dataFile != null) {
	    		// get the file path
	    		String fileName = dataFile.getPath();
	    		// show the file path at the label
	    		fileNameLabel.setText(fileName);
	    		
	    	}
	    }
	    
	    public void calcButtonListener() {
	    	// Formatter definition
	    	DecimalFormat ft = new DecimalFormat("###,##0.00");
	    	
	    	// total sales
			double total=0;
			// average sales
			double avg=0;
			// count how many days
			int dayCount = 0;

			try {
			// file object for the scanner
				File file = new File(fileNameLabel.getText());
				// a Scanner object for reading the file
				Scanner inputFile = new Scanner(file);
				
				
					while(inputFile.hasNext()) {
						// read a number, add it to the total
						total += inputFile.nextDouble();
						dayCount++;
						// increase the day count
						
					}
					inputFile.close();
			}	
			catch(Exception e) {
				System.out.println(e.getMessage());
				fileNameLabel.setText("File not found.");
			}
			
			// if more than 0 days
			if(dayCount !=0)
				// calculate the average
				avg = total/dayCount;
			
			// display the result.
			resultLabel.setText("The avarage sales per day is $"+ft.format(avg));
			
	    }

	}

