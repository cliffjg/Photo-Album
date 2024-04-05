package controller;


import model.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
import java.io.Serializable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AdminSubSystemController implements Initializable{
	
	/**
	 * All the fields in the AdminSubSystemController
	 */
    @FXML
    private Button clearButton;

    @FXML
    private Button createUserButton;

    @FXML
    private  Button deleteUserButton;

    @FXML
    private Label duplicateEntry;

    @FXML
    private Button logOutButton;

    @FXML
    private Button saveButton;

	@FXML
	private ListView<User> listView;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextField userNameText;
    
    Stage mainStage;
    
    Scene scene;
    
    static User user;
    
    static Model model = new Model();
    
    
    private static ObservableList<User> obsList = FXCollections.observableArrayList();
    
    
    
    /**
     * 
     * @param mainStage the current view the user sees
     * @throws IOException if stream to file cannot be written to or closed.
     * @throws ClassNotFoundException if class cannot be found
     */
    public static  void start(Stage mainStage) throws IOException, ClassNotFoundException {
    	
    
   
    }
    
    /**
     * Called to initialize AdminSubSystemController after its root element has been completely processed.
     * @param arg0 used to resolve relative paths for the root object, or null if the location is not known.
     * @param arg1 used to localize the root object, or null if the root object was not localized.
     */
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	
    	obsList = FXCollections.observableArrayList();
    	listView.setItems(null);
    	
    	
		try {
			
			ArrayList<User> arrayList = model.readFromFile();
			for(User user: arrayList) {
				obsList.add(user);

//				System.out.println("In admin from UserList: " + user.getName() + " " + user.getAlbums());
				
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
   
    	listView.setItems(obsList);
		
	}
    
    
    
    /**
     * 
     * clear text when button is pressed
     * @param event clear text when button is pressed
     */
    @FXML
    void clearButton(ActionEvent event) {
    	
    	userNameText.setText("");
    	deleteUserButton.setVisible(true);
    	userNameLabel.setVisible(false);
    	userNameText.setVisible(false);
    	saveButton.setVisible(false);
    	clearButton.setVisible(false);
    	duplicateEntry.setVisible(false);
    }

    /**
     * when press pops up user input field for creating new User
     * @param event pops up user input field for creating new User
     */
    @FXML
    void createUserButton(ActionEvent event) {
    	
    	deleteUserButton.setVisible(false);
    	userNameLabel.setVisible(true);
    	userNameText.setVisible(true);
    	saveButton.setVisible(true);
    	clearButton.setVisible(true);
    	
    	
    

    }
    
    /**
     * When pressed the user is deleted form the listView
     * @param event when pressed deletes user from the listView
     * @throws IOException if stream to file cannot be written to or closed.
     */
    @FXML
    void deleteUserButton(ActionEvent event) throws IOException {
    	
    	
    	
    	if (!(obsList.isEmpty())) {
    		try {
    			//listView.getSelectionModel().select(0);
        		int deleteIndex = listView.getSelectionModel().getSelectedIndex();
        		user = listView.getSelectionModel().getSelectedItem();
            	obsList.remove(deleteIndex);
            	model.removeModel(user.getName());
            	model.writeToFile();
    		}catch(IndexOutOfBoundsException e) {
    			
    		}
    		
        	
        	
        	
    	}else {
    		
    	}
  
    	
    }
    
    /**
     * When log out button is pressed, logs out to login screen so another user can enter credentials 
     * @param event when pressed, logs out to login screen so another user can enter credentials 
     *  @throws IOException if stream to file cannot be written to or closed.
     */
    @FXML
    void logOutButton(ActionEvent event) throws IOException {
    	
    	
		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
		
		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		//mainStage.setUserData(obsList);
		
		LoginController.startContinuation(mainStage);
		mainStage.setTitle("Photos Library");
		scene = new Scene(root);
		mainStage.setScene(scene);
		
		
		mainStage = (Stage) logOutButton.getScene().getWindow();
    }
    
    
   
    /**
     * Saves the user if and only if the user is not already in the list
     * @param event saves the user if and only if the user is not already in the list
     * @throws IOException if stream to file cannot be written to or closed.
     */
    @FXML
    void saveButton(ActionEvent event) throws IOException {
    	
    	duplicateEntry.setVisible(false);

    	if(!userNameText.getText().isEmpty()) {
    		
    		if(obsList.isEmpty()) {
    			add();
    		
    		}else if(!isDuplicate()){
    			
    			add();
    			

    		}else {
    			duplicateEntry.setVisible(true);
    		}
    		
    		
 	
    	}
 	
    	
    }
    
    /**
     * Checks is the enter user is a duplicate; if true that it doesn't allow it to be entered
     * @return returns true if user in list and false if not
     */
    public boolean isDuplicate() {

    	
    	for(User testingUser : obsList) {
			if(userNameText.getText().equals(testingUser.getName())) {

				return true;
			}
		}
    	
   
    	return false;
    }
    
    
    /**
     * Adds stock user albums and photos if admin types in stock 
     * Makes it easier to populate stock user if data is deleted on accident
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public  void add() throws IOException {

    		if(userNameText.getText().equals("stock")) {
    			User user = new User(userNameText.getText());
    			PhotoAlbum photoAlbum = new PhotoAlbum("stock");
    			user.addPhotoAlbum(photoAlbum);
				
    			//System.out.println("THIS IS THE FILE: " + "data" + File.separator +"TakingPhoto.jpeg" );
    			
    			//File file1 = new File("data" + File.separator +"TakingPhoto.jpeg");
    			
    			File file1 = new File("data/TakingPhoto.jpeg");
				File file2 = new File("data/Work.jpeg");
				File file3 = new File("data/Swimming.jpeg");
				File file4 = new File("data/Smile.jpeg");
				File file5 = new File("data/mountains.jpeg");
				File file6 = new File("data/landscape.jpeg");
				
				//System.out.println("THIS IS THE FILE Absolute Path: " + file1.getAbsolutePath() );
	
				String fileName1 = file1.getName();
				String fileName2 = file2.getName();
				String fileName3 = file3.getName();
				String fileName4 = file4.getName();
				String fileName5 = file5.getName();
				String fileName6 = file6.getName();
				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    	
//				Photo photo1 = new Photo(fileName1, sdf.format(file1.lastModified()), "Ballon Festival", file1.getAbsoluteFile());
				
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
		    	
		    	obsList.add(user);
            	
            	listView.setItems(obsList);
            	
            	
            	model.addUser(user);
            	
//            	model.printModel();
            	model.writeToFile();
            	
            	userNameText.setText("");
//            	System.out.println(user.getName());
    			
    		}else {
    			User user = new User(userNameText.getText());
            	obsList.add(user);
            	listView.setItems(obsList);
            	
            	
            	model.addUser(user);
            	
//            	model.printModel();
            	model.writeToFile();
            	
            	userNameText.setText("");
//            	System.out.println(user.getName());
    		}
			
			

		
    }
    
    


	

}
