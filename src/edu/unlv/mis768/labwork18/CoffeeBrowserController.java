package edu.unlv.mis768.labwork18;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CoffeeBrowserController {

    @FXML
    private Button nextButton;

    @FXML
    private Button lastButton;

    @FXML
    private Button previousButton;

    @FXML
    private Label descLabel;

    @FXML
    private Label numLabel;
    
    @FXML
    private Label currentRowLabel;
    
    @FXML
    private Label totalRowLabel;
    
    @FXML
    private Button firstButton;

    @FXML
    private Label priceLabel;
    
    // Declare the ResultSet object as a field of this class
    ResultSet result;    
    int resultSize;
    
    /**
     * This method accepts a ResultSet object to be displayed. 
     * @param The ResultSet generated ordered in the previous screen
     * @throws SQLException 
     */
    public void initData(ResultSet re) throws SQLException {
    	// assign the passed ResultSet object to the result variable in this class
    	result = re;
    	
    	try {
    		// Display the number of rows
    		result.last();		    		// Move to the last row
    		int numRows = result.getRow();
    		resultSize = result.getRow();// Get the current row number
    		result.first();		    		// Move back to the first row
    		totalRowLabel.setText("Total Rows: "+numRows);
    		
    		if(result.getRow() == 1) {
				previousButton.setDisable(true);
			} 

    		//Update the labels to show the content of the current row; i.e., the first row
    		showRowContent(result);
    	}
    	catch (Exception ex){
    		System.out.println("ERROR at initData(): " + ex.getMessage());
    	}
    }
	
	/**
	 * This function displays the content of the current row in a result set.
	 * Three labels are used to display the content of the ProdNum, Description, and price columns
	 * Another label is used to display the row number
	 * @param result A ResultSet
	 */
	public void showRowContent(ResultSet result) {
		try {
			//Display the content of the current row
			numLabel.setText(result.getString("prodNum"));
			descLabel.setText(result.getString("description"));
			priceLabel.setText(Double.toString(result.getDouble("price")));
			
		
			//Display the current row number
			currentRowLabel.setText("Current Row: "+result.getRow());
			
		} catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	/**
	 * ActionListener for the firstButton. Move the record cursor to the first record
	 */
	public void firstButtonListener()  {
		try{
			validateButtons();
			//Move to the first row
			result.first();
		
			//Update the labels to show the content of the current row
			showRowContent(result);
			
		} catch (Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	/**
	 * ActionListener for the lastButton. Move the record cursor to the last record
	 */
	public void lastButtonListener()  {
		try{
			validateButtons();
			//Move to the last row
			result.last();
		
			//Update the labels to show the content of the current row
			showRowContent(result);
			
		} catch (Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	/**
	 * ActionListener for the previousButton. Move the record cursor to the previous record
	 */	
	public void previousButtonListener()  {
		try{
			validateButtons();
			//Move to the last row
			result.previous();
		
			//Update the labels to show the content of the current row
			showRowContent(result);
			
		} catch (Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
 
	}
	public void validateButtons() throws SQLException {
		boolean nextButtonValue = false;
		boolean previousButtonValue = false;
		
		if((resultSize - 1) == result.getRow()) {
			nextButtonValue = true;
		} 
		
		if(result.getRow() == 1) {
			previousButtonValue = true;
		}
		
		previousButton.setDisable(nextButtonValue);
		nextButton.setDisable(previousButtonValue);
	}
	/**
	 * ActionListener for the nextButton. Move the record cursor to the next record
	 */	
	public void nextButtonListener()  {
		try{
			validateButtons();
			//Move to the last row
			result.next();
		
			//Update the labels to show the content of the current row
			showRowContent(result);
			
		} catch (Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}