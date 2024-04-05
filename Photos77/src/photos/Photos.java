package photos;



import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import model.*;
import controller.*;


//import photos.LoginController;


public class Photos extends Application{
	
	/**
	 * start method that starts the program Photos application
	 * @param primaryStage displays the stage for the user
	 */
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(); 
	
		loader.setLocation(getClass().getResource("/view/LoginScreen.fxml")); 

		AnchorPane root = (AnchorPane)loader.load();
		
		LoginController list = loader.getController();
		
		list.start();

		Scene scene = new Scene(root);
		primaryStage.setTitle("Photos Library");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene); 
	
		primaryStage.show();
		
	}

	/**
	 * Main method to run program
	 * @param args sequence of characters (Strings) that are passed to the "main" function to run the application
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
