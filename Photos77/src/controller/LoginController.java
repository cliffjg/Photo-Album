package controller;


import model.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




public class LoginController implements Initializable{

	/**
	 * All the fields in the LoginController
	 */
    @FXML
    private Label inputError;

    @FXML
    private Button clearButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField userName;
    
   
    private static ObservableList<User> obsList;
    
    static User user;
    Stage mainStage;
    
    Scene scene;
    
    static Model model = new Model();
    
    
    //Pass data between windows
     PassUserData userData = PassUserData.getInstance();
    
    
    /**
     * Start method when program is run to login to user if in obsList or admin
     * @throws ClassNotFoundException if class is not found 
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public static void start() throws ClassNotFoundException, IOException {
    	obsList = FXCollections.observableArrayList();
    	user = new User("admin");
    	
    	obsList.add(user);
    	

    	
    	try {
    		ArrayList<User> arrayList = model.readFromFile();
    		for(User user: arrayList) {
    		
//    			System.out.println("Starting program: " + user.getName() + " " + user.getAlbums());
    		}

        		
    	}catch(FileNotFoundException e) {
    		//if FileNotFoundException for dat file it caught
    		//A Stock user is created and saved in a new datFile
//    		System.out.println("File Not Found Exception");
    		User user = new User("stock");
			PhotoAlbum photoAlbum = new PhotoAlbum("stock");
			user.addPhotoAlbum(photoAlbum);
			
			
			
			File file1 = new File("data/TakingPhoto.jpeg");
			File file2 = new File("data/Work.jpeg");
			File file3 = new File("data/Swimming.jpeg");
			File file4 = new File("data/Smile.jpeg");
			File file5 = new File("data/mountains.jpeg");
			File file6 = new File("data/landscape.jpeg");

			String fileName1 = file1.getName();
			String fileName2 = file2.getName();
			String fileName3 = file3.getName();
			String fileName4 = file4.getName();
			String fileName5 = file5.getName();
			String fileName6 = file6.getName();

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    	
	    	Photo photo1 = new Photo(fileName1, sdf.format(file1.lastModified()), "Ballon Festival", file1);
	    	Photo photo2 = new Photo(fileName2, sdf.format(file2.lastModified()), "Phone Call", file2);
	    	Photo photo3 = new Photo(fileName3, sdf.format(file3.lastModified()), "Swimming in Work", file3);
	    	Photo photo4 = new Photo(fileName4, sdf.format(file4.lastModified()), "Colorful Smile", file4);
	    	Photo photo5 = new Photo(fileName5, sdf.format(file5.lastModified()), "Beutiful Nature", file5);
	    	Photo photo6 = new Photo(fileName6, sdf.format(file6.lastModified()), "Country Sunset",file6);

	    	user.albums.get(0).addPhoto(photo1);
	    	user.albums.get(0).addPhoto(photo2);
	    	user.albums.get(0).addPhoto(photo3);
	    	user.albums.get(0).addPhoto(photo4);
	    	user.albums.get(0).addPhoto(photo5);
	    	user.albums.get(0).addPhoto(photo6);

        	
        	model.addUser(user);
        	
//        	model.printModel();
        	
//        	System.out.println("BEFORE: " + "model.writeToFile()");
        	model.writeToFile();
//        	System.out.println("AFTER: " + "model.writeToFile()");
        	

        	
    	}catch (IOException e){
    		
    	}
    	
    	
    }
    
    
    /**
     * This is used when user already logged in and then logs out. 
     * @param mainStage the stage the user sees
     */
    public static void startContinuation(Stage mainStage) {
    	obsList = FXCollections.observableArrayList();
    	user = new User("admin");
    	obsList.add(user);
    	
    	
    }
    
    
    /**
     * Called to initialize LoginController after its root element has been completely processed.
     * @param arg0 used to resolve relative paths for the root object, or null if the location is not known.
     * @param arg1 used to localize the root object, or null if the root object was not localized.
     */
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	try {
    		
    		ArrayList<User> arrayList = model.readFromFile();
			for(User user: arrayList) {
				
				obsList.add(user);
				
				
//				System.out.println("The users from LoginScreen: " + user.getName() + " " + user.getAlbums() );
			}
    		
 
	    	
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		
	}
    

    /**
     * When button is pressed, checks to see if it is either admin or a user in the serialized Model.java
     * if user is in list, than logs into either AdminSubsystem or AlbumController
     * @param event When button is pressed, checks to see if it is either admin or a user in serializable file
     * @throws IOException if stream to file cannot be written to or closed.
     * @throws ClassNotFoundException if class is not found 
     */
    @FXML
    void loginButton(ActionEvent event) throws IOException, ClassNotFoundException {
    	if(userName.getText().equals("admin")) {
    		
    		inputError.setVisible(false);
    		
    		Parent root = FXMLLoader.load(getClass().getResource("/view/AdminSubsystem.fxml"));
    		
    		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		mainStage.setUserData(obsList);
    		
    		AdminSubSystemController.start(mainStage);
    		mainStage.setTitle("Admin Screen");
    		scene = new Scene(root);
    		mainStage.setScene(scene);
    		
    		
    		mainStage = (Stage) loginButton.getScene().getWindow();
    

    	}else {
//    		try {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    		//THE IS USED FOR FINAL VERSION
//    			ArrayList<User> arrayList = model.readFromFile();
//	    		if(arrayList.isEmpty()) {
//	    			inputError.setVisible(true);
//	    		}
//	    		
//				for(User user: arrayList) {
//					
//		    		if(user.getName().equals(userName.getText())) {
//		    		
//			    		userData.setUserData(user);	
//				    	
//			    		Stage stage = (Stage) loginButton.getScene().getWindow();
//			    		Parent root = FXMLLoader.load((getClass().getResource("/view/Album.fxml")));
//			    		stage.setTitle(user.getName() + "'s Photo Albums");
//			    		stage.centerOnScreen();
//			    		stage.setScene(new Scene(root));
//		    		
//		    		}else {
//		    			inputError.setVisible(true);
//		    		}
//					
//				}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    		
//    		//THE IS USED FOR NEW FINAL VERSION
//    		ArrayList<User> arrayList = model.readFromFile();
//    		if(arrayList.isEmpty()) {
//    			inputError.setVisible(true);
//    		}
//    		
//			for(User user: arrayList) {
//				
//	    		if(user.getName().equals(userName.getText())) {
//	    			
//	    			
//	    		
//		    		userData.setUserData(user);	
//			    	
//		    		Stage stage = (Stage) loginButton.getScene().getWindow();
//		    		
//		    		Parent root = FXMLLoader.load((getClass().getResource("/view/UpdatedAlbum.fxml")));
//		    		stage.setTitle(user.getName() + "'s Photo Albums");
//		    		stage.centerOnScreen();
//		    		stage.setScene(new Scene(root));
//	    		
//	    		}else {
//	    			inputError.setVisible(true);
//	    		}
//				
//			}

    		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    		
    		//Testing Version
    		ArrayList<User> arrayList = model.readFromFile();
    		if(arrayList.isEmpty()) {
    			inputError.setVisible(true);
    		}
    		
			for(User user: arrayList) {
				
	    		if(user.getName().equals(userName.getText())) {
	    			
	    			
	    		
		    		userData.setUserData(user);	
			    	
		    		Stage stage = (Stage) loginButton.getScene().getWindow();
		    		
		    		//Parent root = FXMLLoader.load((getClass().getResource("/view/UpdatedAlbum1.fxml")));
		    		Parent root = FXMLLoader.load((getClass().getResource("/view/Album.fxml")));
		    		stage.setTitle(user.getName() + "'s Photo Albums");
		    		stage.centerOnScreen();
		    		stage.setScene(new Scene(root));
	    		
	    		}else {
	    			inputError.setVisible(true);
	    		}
				
			} 		
    		
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   		
//	    	}catch(FileNotFoundException e) {
//	    		inputError.setVisible(true);
//	    		userName.setText("");
//	    	}catch (IOException e){
//	    		inputError.setVisible(true);
//	    		userName.setText("");
//	    	}
			
			
    		
    	}
    	
    	
    }

    /**
     * Clears text field so there is not data in the textfield
     * @param event button clears text field
     */
    @FXML
    void clearButton(ActionEvent event) {
    	userName.setText("");
    }

}
