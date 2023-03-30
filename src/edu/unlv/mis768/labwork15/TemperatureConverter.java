package edu.unlv.mis768.labwork15;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;

public class TemperatureConverter extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// Load the FXML file
		//primaryStage.initStyle(StageStyle.UNDECORATED);
        
		Parent parent = FXMLLoader.load(getClass().getResource("TemperatureConverter.fxml"));
		
		// Build the scene
		Scene scene = new Scene(parent);
		// Set the window title
		primaryStage.setTitle("Temperature Convereter");
		// Set the scene to stage
		primaryStage.setScene(scene);
		// SHow the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
