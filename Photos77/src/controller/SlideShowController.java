package controller;



import model.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class SlideShowController implements Initializable{

	/**
	 * All the fields in the SlideShowController
	 */
    @FXML
    private Label albumHeader;

    @FXML
    private Button backButton;

    @FXML
    private Button backwardSlideButton;

    @FXML
    private Button forwardSlideButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Button logOutButton;

    @FXML
    private Label photoLabelName;
    
    @FXML
    private Label beginningOfAlbum;

    @FXML
    private Label endOfAlbum;
    
    @FXML
    private Label captionLabelName;
    
    //Pass data between windows
    PassUserData userData = PassUserData.getInstance();

    static User user;

    static Model model = new Model();
    
    @FXML
    private  ObservableList<Photo> obsList = FXCollections.observableArrayList();
    
    @FXML
    private  ObservableList<ImageView> obsListImage = FXCollections.observableArrayList();
    
    @FXML
    private  ListView<Photo> listview = new ListView<Photo>();
    
    private static int incrementSlide;
    
    private static int decrementSlide;
    
    private  int albumIndex;
    
    private  int pictureIndex;
    
    

    /**
     * Called to initialize SlideShowController after its root element has been completely processed.
     * populates all data in imageView and photo information such as photoName, Caption and Image
     * @param arg0 used to resolve relative paths for the root object, or null if the location is not known.
     * @param arg1 used to localize the root object, or null if the root object was not localized.
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		
		user = userData.getUserData();	
		String albumName = userData.getUserAlbum();
		
		albumHeader.setText(albumName + " Album"); 
		
//		int albumIndex = userData.getAlbumIndex();
//		int pictureIndex = userData.getPictureIndex();

		albumIndex = userData.getAlbumIndex();
		pictureIndex = userData.getPictureIndex();

//		System.out.println("albumIndex: " + albumIndex);
//		System.out.println("pictureIndex: " + pictureIndex);

    	obsList.add(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex ));
    	listview.setItems(obsList);
    	
    	File filePath = user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex ).getFilePath();
    	
    	Image image = new Image(filePath.toURI().toString());
    	
    	imageView.setImage(image);
    	
    	
    	photoLabelName.setText(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getPhotoName());
    	captionLabelName.setText(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getCaption());
		

    	if(pictureIndex == 0) {
    		backwardSlideButton.setDisable(true);
    	}
    	
    	if(pictureIndex == user.albums.get(albumIndex).photos.size()-1) {
    		forwardSlideButton.setDisable(true);
    	}

    	
    	
    	
    	
		
	}
	
	
	/**
	 * User presses button to go back to the PhotoListView.fxml
	 * @param event used to go back to the PhotoListView.fxml
	 * @throws IOException if stream to file cannot be written to or closed.
	 */
    @FXML
    void backButton(ActionEvent event) throws IOException {
    	userData.setUserData(user);
    	
		Stage stage = (Stage) backButton.getScene().getWindow();
		Parent root = FXMLLoader.load((getClass().getResource("/view/PhotosListView.fxml")));
		stage.setTitle(user.getName() + "'s Photo Albums");
		stage.setScene(new Scene(root));
    }
    
    
    /**
     * User presses to complete logout of their personel album. Goes  back to login screen
     * @param event used to logout and go back to Login Screen
     * @throws IOException if stream to file cannot be written to or closed.
     */
    @FXML
    void logOut(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
		
		Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	
		LoginController.startContinuation(mainStage);
		mainStage.setTitle("Photos Library");
		Scene scene = new Scene(root);
		mainStage.setScene(scene);
		
		
		mainStage = (Stage) logOutButton.getScene().getWindow();

    }
    
    
    /**
     * Moves the photo from current photo to previous photo in list. 
     * @param event when pressed the index is subtracted by one to populate previous data
     */
    @FXML
    void backwardSlideButton(ActionEvent event) {
    	
    	try {
    		

        	
    		
    		forwardSlideButton.setDisable(false);
    		//forwardSlideButton.setText("Forward");
    		//endOfAlbum.setVisible(false);
        	user = userData.getUserData();	
    		String albumName = userData.getUserAlbum();
    		
    		albumHeader.setText(albumName + " Album"); 
    		

    		
    		pictureIndex = pictureIndex - 1;

        	obsList.add(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex));
        	listview.setItems(obsList);
        	
        	File filePath = user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getFilePath();
        	
        	Image image = new Image(filePath.toURI().toString());
        	
        	imageView.setImage(image);
        	
        	
        	photoLabelName.setText(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getPhotoName());
        	captionLabelName.setText(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getCaption());
        	

        	if(pictureIndex == 0) {
        		backwardSlideButton.setDisable(true);
        	}
        	
        	
        	
//        	System.out.println("This is the size: " + user.albums.get(albumIndex).photos.size());
        	
    		
    	}catch(IndexOutOfBoundsException e) {
    		pictureIndex = pictureIndex + 1;
    		//beginningOfAlbum.setVisible(true);
    		//backwardSlideButton.setText("End");
    		backwardSlideButton.setDisable(true);
    	}
    	

    	
    	
    }

    /**
     * Moves the photo from current photo to next photo in list. 
     * @param event when pressed the index is added by one to populate next data
     */
    @FXML
    void forwardSlideButton(ActionEvent event) {
    	
    	try {
    		
    		backwardSlideButton.setDisable(false);

        	user = userData.getUserData();	
    		String albumName = userData.getUserAlbum();
    		
    		albumHeader.setText(albumName + " Album"); 
    		

    		
    		pictureIndex = pictureIndex + 1;


        	obsList.add(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex));
        	listview.setItems(obsList);
        	
        	File filePath = user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getFilePath();
        	
        	Image image = new Image(filePath.toURI().toString());
        	
        	imageView.setImage(image);
        	
        	
        	photoLabelName.setText(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getPhotoName());
        	captionLabelName.setText(user.getAlbums().get(albumIndex).getPhoto().get(pictureIndex).getCaption());
        	
        	if(pictureIndex == user.albums.get(albumIndex).photos.size()-1) {
        		forwardSlideButton.setDisable(true);
        	}
        	
    	}catch(IndexOutOfBoundsException e) {
    		pictureIndex = pictureIndex - 1;

    		forwardSlideButton.setDisable(true);
    	}
    	
    	

    }
    
    

   


}
