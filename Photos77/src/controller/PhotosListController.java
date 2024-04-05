package controller;


import model.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

import java.time.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;


public class PhotosListController implements Initializable {

	
	/**
	 * All the fields in the PhotosListController
	 */
	   @FXML
	    private Button addPhotoButton;
	   
	   @FXML
	    private Button addTagButton;

	    @FXML
	    private Label albumHeader;

	    @FXML
	    private Button backButton;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private Button captionRecaptionButton;

	    @FXML
	    private Button copyButton;

	    @FXML
	    private TextField dateTextField;

	    @FXML
	    private Button deleteAlbumButton;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button deleteTagButton;

	    @FXML
	    private TextField enterNewAlbum;

	    @FXML
	    private TextField imageNameTextField;

	    @FXML
	    private Button logOutButton;

	    @FXML
	    private Button moveButton;

	    @FXML
	    private Button renameCancelButton;

	    @FXML
	    private TextField renameNewAlbum;

	    @FXML
	    private Button renameSaveButton;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private Button slideShowButton;

	    @FXML
	    private TextArea tagsTextField;
	    
	    @FXML
	    private ImageView imageView;
	    
	    @FXML
	    private ListView<String> tagListView;
	    
	    @FXML
	    private ObservableList<String> obsTags = FXCollections.observableArrayList();
	    
	    @FXML
	    private Label duplicatePhoto;
	    
	    @FXML
	    private Button cancelCaptionButton;
	    
	    @FXML
	    private Button saveCaptionButton;
	    
	    @FXML
	    private Label dateLabel;
	    
	    @FXML
	    private Label tagsLabel;
	    
	    @FXML
	    private TextField captionTextField;
	    
	    @FXML
	    private Label captionLabel;
	    
	    @FXML
	    private Label listEmpty;
	    
	    

	    
	    static PhotoAlbum photoAlbum;
    
	    //Pass data between windows
	    PassUserData userData = PassUserData.getInstance();
    
	    static User user;
    
	    static Model model = new Model();
	    
	    Stage primaryStage;

	    
	    @FXML
	    private  ObservableList<Photo> obsList = FXCollections.observableArrayList();
	    
	    @FXML
	    private  ObservableList<ImageView> obsListImage = FXCollections.observableArrayList();
	    
	    @FXML
	    private  ListView<Photo> listview = new ListView<Photo>();
	    
//	    private ImageView imageView1 = new ImageView();
	    
	    
	    
	    
	    /**
	     * Called to initialize PhotosListController after its root element has been completely processed.
	     * populates all data in listView, imageView and TextFields
	     * @param arg0 used to resolve relative paths for the root object, or null if the location is not known.
	     * @param arg1 used to localize the root object, or null if the root object was not localized.
	     */
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			user = userData.getUserData();	
			String albumName = userData.getUserAlbum();
			
			int index = userData.getAlbumIndex();
			
			
//			System.out.println("THE INDEX IS: " + index);
			
			albumHeader.setText(albumName + " Album");

			ArrayList<User> arrayList;

		    	int sizeOfFolder = user.getAlbums().get(index).getPhoto().size();


		    
				for(int i = 0; i <  sizeOfFolder; i++) {
	        		

	    	    	
	    	    	File file = user.getAlbums().get(index).getPhoto().get(i).getFilePath();
	        		String fileName = user.getAlbums().get(index).getPhoto().get(i).getPhotoName();
	        		String caption = user.getAlbums().get(index).getPhoto().get(i).getCaption();
	        		ArrayList<Pair<String, String>> tags_list = user.getAlbums().get(index).getPhoto().get(i).getTAGS();
	        		//System.out.println("THE USER ALBUM File: " + file + "\nFileName: " + fileName);
	        		Photo photo;

	        		
	        		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	        		
	        		if(caption != null) {
	        			//Photo photo = new Photo(fileName, "10/24/22", caption, file);
	        			photo = new Photo(fileName, sdf.format(file.lastModified()), caption, file, tags_list);
	        		}else{
	        			//Photo photo = new Photo(fileName, "10/24/22", file);
	        			photo = new Photo(fileName, sdf.format(file.lastModified()), file, tags_list);
	        		}
	    	    	
	    	    	

	    	        
	 //////////////////////////////////////////////////////////////////////////////////////////////////
	  ///////TESTING THIS CODE OUT//////////////////////////////////////  	        
	    	        obsList.add(photo);
	    	    	listview.setItems(obsList);
	    	    	
	    	    	
//	    	    	Image image = new Image(file.toURI().toString());
	    	    	//imageView.setImage(image);
	    	    	
//	    	    	Image image1 = new Image(file.toURI().toString());
//	    	    	ImageView imageView1 = new ImageView();
//	    	    	Image image1 = new Image(file.toURI().toString());
	    	    	listview.setCellFactory(param -> new ListCell<Photo>() {	         
		    	    	private ImageView imageView1 = new ImageView();
		    	      
	    	            @Override
	    	            public void updateItem(Photo name, boolean empty) {
	    	                super.updateItem(name, empty);
	    	                if (empty) {
	    	                    setText(null);
	    	                    setGraphic(null);
	    	                } else {
	    	                	
    	                		Image image1 = new Image(name.getFilePath().toURI().toString());
    	                		imageView1.setImage(image1);
    	                        imageView1.setFitHeight(40);
    	                        imageView1.setFitWidth(40);
    	                        setText(name.getPhotoName());
    	                        
    	                        //This one is based on assignment criteria
    	                        //But it looks messy
    	                        //setText("Name: " + name.getPhotoName() + "\n" + "Caption: " + name.getCaption());
	    	                    setGraphic(imageView1);
	    	                	
	    	                }
	    	            }
	    	        });
	    	    	
	    	       
	    	        
	    	        Image image = new Image(file.toURI().toString());
	    	    	imageView.setImage(image);
	    	    	
	    	        
	    	        dateTextField.setText(photo.getDate());
	    	        imageNameTextField.setText(fileName);
	    	        ///////TESTING THIS CODE OUT////////////////////////////////////// 	        
	 /////////////////////////////////////////////////////////////////////////////////////////////////
	    	        
	    	  

	    		    //listview.getSelectionModel().select(photo);
	    	        
	    	        listview.getSelectionModel().select(0);
	    		    

	    	        
//	    	        if(obsList.isEmpty()) {
//	    	        	
//	    	        	
//	    	        }else {
	    	        	dateTextField.setText(user.albums.get(userData.getAlbumIndex()).photos.get(0).getDate());
				    	captionTextField.setText(user.albums.get(userData.getAlbumIndex()).photos.get(0).getCaption());
				    	imageNameTextField.setText(user.albums.get(userData.getAlbumIndex()).photos.get(0).getPhotoName());
				    	Image firstImage = new Image(user.albums.get(userData.getAlbumIndex()).photos.get(0).getFilePath().toURI().toString());
				    	imageView.setImage(firstImage);
//	    	        }
			    	
	    		    
			    	
				}
				
				if(listview.getSelectionModel().getSelectedItem() != null) {
					obsTags.addAll(listview.getSelectionModel().getSelectedItem().getFormatTags());
					tagListView.setItems(obsTags);
				}
				
//				System.out.println("\nInitialize Completed!");

			
		}
	    

	   
		/**
		 * Back button to go to the user's Album view
		 * @param event when pressed it goes back to the user's Album view
		 * @throws IOException if stream to file cannot be written to or closed.
		 * @throws ClassNotFoundException if class is not found
		 */
	    @FXML
	    void backButton(ActionEvent event) throws IOException, ClassNotFoundException {
	////////////////////////////////////////////////////////////////////////////////////////////////////////
			userData.setUserData(user);
			//obsList.clear();
			
			Stage stage = (Stage) backButton.getScene().getWindow();
			//Parent root = FXMLLoader.load((getClass().getResource("/view/UpdatedAlbum1.fxml")));
			Parent root = FXMLLoader.load((getClass().getResource("/view/Album.fxml")));
			stage.setTitle(user.getName() + "'s Photo Albums");
			stage.setScene(new Scene(root));
			
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	    	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
//	    	userData.setUserData(user);
//    		//obsList.clear();
//    		    	
//    		Stage stage = (Stage) backButton.getScene().getWindow();
//    		Parent root = FXMLLoader.load((getClass().getResource("/view/UpdatedAlbum.fxml")));
//    		stage.setTitle(user.getName() + "'s Photo Albums");
//    		stage.setScene(new Scene(root));
	    	
	////////////////////////////////////////////////////////////////////////////////////////////////////////

//    		userData.setUserData(user);
//    		//obsList.clear();
//    		    	
//    		Stage stage = (Stage) backButton.getScene().getWindow();
//    		Parent root = FXMLLoader.load((getClass().getResource("/view/Album.fxml")));
//    		stage.setTitle(user.getName() + "'s Photo Albums");
//    		stage.setScene(new Scene(root));

	    }
	    
	    /**
	     * Logs out to the login screen when button is pressed
	     * @param event logs out to the login screen when button is pressed
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
	     * used to compare if photo is already in the obsList if it is than it returns true otherwise false
	     * @param fileName used to compare with fileName in obsList
	     * @return returns true if fileName is in the obsList and false if not
	     */
	    public boolean isDuplicate(String fileName) {

	    	
	    	for(Photo testingUser : obsList) {
	    		
//	    		System.out.println("Photo: " + testingUser.getPhotoName());
				if(fileName.equals(testingUser.getPhotoName())) {
					
					return true;
				}
					
			}
			
	    	return false;
	    }

	    
	    /**
	     * add photo to the current user album
	     * @param event add button to add current user to album
		 * @throws IOException if stream to file cannot be written to or closed.
		 * @throws ClassNotFoundException if class is not found
	     */
	    @FXML
	    void addPhotoButton(ActionEvent event) throws IOException, ClassNotFoundException {
	    	
	    	listEmpty.setVisible(false);
	    	duplicatePhoto.setVisible(false);
	    	user = userData.getUserData();	
			String albumName = userData.getUserAlbum();
			int index = 0;
	    	
//	    	System.out.println("ALBUM NAME IS: " + albumName);
	    	
	    	
	    	//loops through list to find the index of the album name
	    	//so the index can be used to add the photo at the index
	    	for(int i = 0; i < user.albums.size()-1; i++) {
	    		if(user.albums.get(index).getAlbumName().equals(albumName) ) {
	    			break;
	    			
	    		}
	    		
	    		index++;
	    	}
	    	

	    	try {
	    	
		    	FileChooser file = new FileChooser();
		    	FileChooser.ExtensionFilter extFilter = 
	                    new FileChooser.ExtensionFilter("Image Files", "*.bmp", "*.BMP", "*.gif", "*.GIF",
	                    		"*.jpeg", "*.JPEG" ,"*.jpg", "*.JPG", "*.png", "*.PNG");
	            file.getExtensionFilters().add(extFilter);
	            
	            //System.out.println("THIS CHECKING THE FILE: " +file.toString());
	            
	           
	            	
            	//returns file Path
    	    	File filePath = file.showOpenDialog(null);
//    	    	System.out.println("FILEPATH IS: " + filePath);
    	    	//converts file path to just file name
    	    	String fileName = filePath.getName();
    	    	if(!isDuplicate(fileName)) {
    	    		
    	    		
    	    		//converts File filePath to a string 
        	    	String path = filePath.toString();
        	    	
        	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        	    	
        	    	Photo photo = new Photo(fileName, sdf.format(filePath.lastModified()), filePath);

        	    	user.getAlbums().get(index).addPhoto(photo);

        	    	obsList.add(photo);
        	    	listview.setItems(obsList);
   
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	    	
        	    	listview.setCellFactory(param -> new ListCell<Photo>() {	         
		    	    	private ImageView imageView1 = new ImageView();
		    	      
	    	            @Override
	    	            public void updateItem(Photo name, boolean empty) {
	    	                super.updateItem(name, empty);
	    	                if (empty) {
	    	                    setText(null);
	    	                    setGraphic(null);
	    	                } else {
	    	                	
    	                		Image image1 = new Image(name.getFilePath().toURI().toString());
    	                		imageView1.setImage(image1);
    	                        imageView1.setFitHeight(40);
    	                        imageView1.setFitWidth(40);
    	                        setText(name.getPhotoName());
    	                        
    	                        //This one is based on assignment criteria
    	                        //But it looks messy
    	                        //setText("Name: " + name.getPhotoName() + "\n" + "Caption: " + name.getCaption());
	    	                    setGraphic(imageView1);
	    	                	
	    	                }
	    	            }
	    	        });
        	    	
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	    	
        	    	
        	    	
        	    	Image image = new Image(filePath.toURI().toString());
        	    	
        	    	
        	    	imageView.setImage(image);
        	    	
        	        dateTextField.setText(photo.getDate());
        	        imageNameTextField.setText(fileName);
        	        
        	        obsTags.clear();
        	        tagListView.setItems(obsTags);
        	        
        	        

        	        model.findAndUpdateModel(user,user.getName());
        	        
        		    listview.getSelectionModel().select(photo);
        		   
        	    	

    			    
    			    duplicatePhoto.setVisible(false);
    	    	
    	    	}else{ 
    	    		duplicatePhoto.setVisible(true);
    	    	}
    	    	
    	    	
	                
	    	}catch(NullPointerException e) {
	    		
	    	}
	    	
	    	

	    }
	    
	    /**
	     * add tag button for adding tag to individual photos
	     * @param event when pressed adds tags to individual photo
	     */
	    @FXML
	    void addTagButton(ActionEvent event) {
	    	if(listview.getSelectionModel().getSelectedItem() == null) return;
		    if(!obsList.isEmpty()){
		    	
		    	Photo x = listview.getSelectionModel().getSelectedItem();
		    	
//		    	System.out.println("addTagButton activated");
	            Stage addTagWindow = new Stage();
	            
	            GridPane root = new GridPane();
	            Text tagName = new Text("Tag Name");
	            TextField insertName = new TextField();
	            Text tagValue = new Text("Tag Value");
	            TextField insertValue = new TextField();
	            Text warning = new Text("WARNING: names and values are case sensitive.");
	            Button saveTag = new Button("SAVE");
	            Button cancelTag = new Button("CANCEL");
	            
	            insertName.setPromptText("EG. People");
	            insertValue.setPromptText("EG. Me");
	            
	            root.setPadding(new Insets(10,10,10,10));
	            root.setHgap(10);
	            root.setVgap(10);
	            //insertTagName.setPrefColumnCount(5);
	            //insertTagValue.setPrefColumnCount(5);

	            root.add(tagName, 0, 0);
	            root.add(tagValue, 1, 0);
	            root.add(insertName, 0, 1);
	            root.add(insertValue, 1, 1);
	            root.add(saveTag, 0, 2);
	            root.add(cancelTag, 1, 2);
	            root.add(warning, 0, 3);
	            
	            GridPane.setValignment(tagName, VPos.CENTER);
	            GridPane.setValignment(tagValue, VPos.CENTER);
	            GridPane.setValignment(warning, VPos.CENTER);
	            
	            Text empty_name = new Text("Please write to the name text field.");
	            Text empty_value = new Text("Please write to the value text field.");
	            Text empty_tag = new Text("Please write to the name and value text fields.");
	            Text tag_exists = new Text("The TAG already exists.");
	            
	            root.add(empty_name, 1, 3);
	            root.add(empty_value, 1, 3);
	            root.add(empty_tag, 1, 3);
	            root.add(tag_exists, 1, 3);
	            
	            
	            empty_name.setVisible(false);
	            empty_value.setVisible(false);
	            empty_tag.setVisible(false);
	            tag_exists.setVisible(false);
	            
	            Scene UI = new Scene(root);
	            addTagWindow.setScene(UI);
	            addTagWindow.show();
	            
	            saveTag.setOnAction(new EventHandler<ActionEvent>() {
	            	public void handle(ActionEvent e) {
	            		
	                    empty_name.setVisible(false);
	                    empty_value.setVisible(false);
	                    empty_tag.setVisible(false);
	                    tag_exists.setVisible(false);
	            		
	            		String tag_name = insertName.getText();
	            		String tag_value = insertValue.getText();
	            		boolean empty_nameC = tag_name.compareTo("") == 0;
	            		boolean empty_valueC = tag_value.compareTo("") == 0;
	            		if(empty_nameC || empty_valueC) {
//	            			System.out.println("error happens");
	            			if((empty_nameC && empty_valueC)) {
	            				empty_tag.setVisible(true);
	            			} else {
		            			if(empty_nameC) {
		            				empty_name.setVisible(true);
		            			}
		            			if(empty_valueC) {
		            				empty_value.setVisible(true);
		            			}
	            			}
	            		} else {
	            			boolean addTag = listview.getSelectionModel().getSelectedItem().addTag(tag_name, tag_value);
	            			//int selectedIndex = listview.getSelectionModel().getSelectedIndex();
	            			
//	            			System.out.println("addTag is" + addTag);
	            			
	            			if(!addTag) tag_exists.setVisible(true);
	            			else {
	            				
	            				user = userData.getUserData();	/// ####
	            				
								obsTags.clear();

								obsTags.addAll();
								
//								int selectedIndex = listview.getSelectionModel().getSelectedIndex();
//								
//								listview.getSelectionModel().select(selectedIndex);
//								tagListView.setItems(obsTags);

								obsTags.addAll(listview.getSelectionModel().getSelectedItem().getFormatTags());
								tagListView.setItems(obsTags);
								tagListView.refresh();
								//listview.getSelectionModel().select(selectedIndex);
								//tagListView.setItems(obsTags);

								//tagListView.refresh();
								//listview.getSelectionModel().select(0);
								//listview.getSelectionModel().select(selectedIndex);
								
	            				//System.out.println("TESTING USER DATA: " + user.albums); // lbum list
	            				//System.out.println("TESTING USER DATA: " + user.albums.get(0)); // album per index
	            				//System.out.println("TESTING USER DATA: " + user.albums.get(0).photos); // list of photos
	            				//System.out.println("TESTING USER DATA: " + user.albums.get(0).photos.get(0)); // photo per index
	            				//System.out.println("TESTING USER DATA: " + user.albums.get(0).photos.get(0).getPhotoName()); // p name
	            				//System.out.println("TESTING USER DATA: " + user.albums.get(0).photos.get(0).getFormatTags()); // list of photos
	            				//System.out.println("TAG TEST: " + user.albums.get(0).photos.get(0));
	            				
	            				try {
	            					model.findAndUpdateModel(user, user.getName());
	            				} catch (ClassNotFoundException | IOException INaddTag) {
	            					// TODO Auto-generated catch block
	            					INaddTag.printStackTrace();
	            				}
	            				
	            				//listview.getSelectionModel().select(x);
	            				//listview.refresh();
	            				//tagListView.setItems(obsTags);
	            				
	            				
	            				addTagWindow.close();
	            				// (user, user.getName())
	            				//System.out.println("tag name is: " + tag_name + ", tag value is: " + tag_value);
//	                			System.out.println(user.getName());
	            			}
	            		}
	            	}
	            });
	            
	            cancelTag.setOnAction(new EventHandler<ActionEvent>() {
	            	public void handle(ActionEvent e) {
	            		addTagWindow.close();
	            	}
	            	
	            });

	            

				

	    	}else {
	    		listEmpty.setVisible(true);
	    	}

	    }
	    

	    /**
	     * adds caption or recaptions individual photo
	     * @param event when pressed, user is asked to to addd caption in TextField
	     */
	    @FXML
	    void captionRecaptionButton(ActionEvent event) {
	    	if(listview.getSelectionModel().getSelectedItem() == null) return;
	    	int captionIndex = listview.getSelectionModel().getSelectedIndex();
    		photoAlbum = listview.getSelectionModel().getSelectedItem();
    		

    		
    		captionTextField.setText(user.albums.get(userData.getAlbumIndex()).photos.get(captionIndex).getCaption());
    		
    		captionTextField.setDisable(false);
    		saveCaptionButton.setVisible(true);
    		cancelCaptionButton.setVisible(true);
    		dateLabel.setVisible(false);
    		dateTextField.setVisible(false);
    		tagListView.setVisible(false);
    		tagsLabel.setVisible(false);
    		listview.setDisable(true);
    		

	    }
	    
	    /**
	     * save button to save caption when user is done enter information
	     * @param event save button to save caption
		 * @throws IOException if stream to file cannot be written to or closed.
		 * @throws ClassNotFoundException if class is not found
	     */
	    @FXML
	    void saveCaptionButton(ActionEvent event) throws IOException, ClassNotFoundException {
	    	
	    	int captionIndex = listview.getSelectionModel().getSelectedIndex();
    		photoAlbum = listview.getSelectionModel().getSelectedItem();
	    	
	    	user.albums.get(userData.getAlbumIndex()).photos.get(captionIndex).setCaption(captionTextField.getText());
	    	
	    	captionTextField.setText(user.albums.get(userData.getAlbumIndex()).photos.get(captionIndex).getCaption());
	    	
	    	model.findAndUpdateModel(user,user.getName());
	    	
	    	//captionTextField.setText("");
	    	captionTextField.setDisable(true);
    		saveCaptionButton.setVisible(false);
    		cancelCaptionButton.setVisible(false);
    		dateLabel.setVisible(true);
    		dateTextField.setVisible(true);
    		tagListView.setVisible(true);
    		tagsLabel.setVisible(true);
    		listview.setDisable(false);
	    	

	    }
	    
	    /**
	     * used to cancel caption so the input is not saved to individual photo
	     * @param event cancel event to cancel user input
	     */
	    @FXML
	    void cancelCaptionButton(ActionEvent event) {
	    	captionTextField.setText("");
	    	captionTextField.setDisable(true);
    		saveCaptionButton.setVisible(false);
    		cancelCaptionButton.setVisible(false);
    		dateLabel.setVisible(true);
    		dateTextField.setVisible(true);
    		tagListView.setVisible(true);
    		tagsLabel.setVisible(true);
    		listview.setDisable(false);
	    }
	    

	    /**
	     * interates through all albums compares photos and returns album name
	     * @param x photo in album
	     * @param album_name target search
	     * @return exists a true/false if it exists
	     */
	    public boolean existsInAlbum(Photo x, String album_name) {
	    	boolean exists = false;
	    	int album_length = user.getAlbums().size();
	    	for(int album_index = 0; album_index < album_length; album_index++) {
	    		PhotoAlbum currentAlbum = user.getAlbums().get(album_index);
	    		String currentAlbum_name = currentAlbum.getAlbumName();
	    		int photos_length = currentAlbum.getPhoto().size();
	    		if(currentAlbum_name.compareTo(album_name) == 0) {
		    		for(int photo_index = 0; photo_index < photos_length; photo_index++) {
		    			if(currentAlbum.getPhoto().contains(x)) exists = true;
		    		}
	    		}
	    	}
	    	return exists;
	    }


		 /**
	     * copy from current album to one of users choosing 
	     * @param event copy from current album to one of users choosing 
	     */
	    @FXML
	    void copyButton(ActionEvent event) {
	    	
	    //	if(listview.getSelectionModel().getSelectedItem() == null) return;
	    	if(!obsList.isEmpty()){
//		    	System.out.println("copy in");
	            Stage mvPhotoWindow = new Stage();
	            
	            GridPane root = new GridPane();
	            Text instructions = new Text("Choose an album to copy to:");
	            Button moveTag = new Button("COPY");
	            Button cancelTag = new Button("CANCEL");
	            
	            ObservableList<PhotoAlbum> obs_album = FXCollections.observableArrayList();
	            ListView<PhotoAlbum> list_album = new ListView<PhotoAlbum>(); 
	            obs_album.addAll(user.albums);
	            list_album.setItems(obs_album);
	            
	            root.setPadding(new Insets(10,10,10,10));
	            root.setHgap(10);
	            root.setVgap(10);
	            //insertTagName.setPrefColumnCount(5);
	            //insertTagValue.setPrefColumnCount(5);
	            
	            Text error = new Text("Please select an album.");

	            root.add(instructions, 0, 0);
	            root.add(list_album, 0, 1);
	            root.add(error, 0, 2);
	            root.add(moveTag, 0, 3);
	            root.add(cancelTag, 0, 4);
	            
	            error.setVisible(false);
	            
	            GridPane.setValignment(list_album, VPos.CENTER);
	            GridPane.setValignment(moveTag, VPos.BOTTOM);
	            GridPane.setValignment(cancelTag, VPos.BOTTOM);
	            
	            Scene UI = new Scene(root);
	            mvPhotoWindow.setScene(UI);
	            mvPhotoWindow.show();
	            
	            moveTag.setOnAction(new EventHandler<ActionEvent>() {
	            	public void handle(ActionEvent e) {
	            		error.setVisible(false);
	            		if(list_album.getSelectionModel().getSelectedItem() == null) return;
	            		boolean same_album = (list_album.getSelectionModel().getSelectedItem().getAlbumName().compareTo(userData.getUserAlbum()) == 0);
	            		if(list_album.getSelectionModel().getSelectedItem() == null || same_album) {
	            			error.setVisible(true);
	            		} else {
		           			Photo copy = listview.getSelectionModel().getSelectedItem();
		           			if(!existsInAlbum(copy, list_album.getSelectionModel().getSelectedItem().getName())) {
			           			list_album.getSelectionModel().getSelectedItem().addPhoto(copy);
			           			
			       				try {
			       					model.findAndUpdateModel(user, user.getName());
			       				} catch (ClassNotFoundException | IOException INmoveTag) {
			        				// TODO Auto-generated catch block
			        				INmoveTag.printStackTrace();
			        			}
	            			} else {
	            				duplicatePhoto.setVisible(true);
	            			}
		           			mvPhotoWindow.close();
	            		}
	            	}
	            });
	            
	            cancelTag.setOnAction(new EventHandler<ActionEvent>() {
	            	public void handle(ActionEvent e) {
	            		mvPhotoWindow.close();
	            	}
	            });
	    	}else {
	    		listEmpty.setVisible(true);
	    	}
	    }
	    
	    
	    /**
	     * delete selected image in obsList and listview
	     * @param event delete selected image in obsList and listview
	     */
	    @FXML
	    void deleteAlbumButton(ActionEvent event) {
		    if(!obsList.isEmpty()){
//		    	System.out.println("deleteAlbumButton BUTTON ENTERED");
				
				user = userData.getUserData();			
				int album_index = userData.getAlbumIndex();
				//int album_length = user.albums.size();
				//for( ; album_index < album_length; album_index++) {
					//String current_album = user.albums.get(album_index).getAlbumName();
					//if(current_album.compareTo())
				//}
				
//				System.out.println("before loop");
				
				Photo selected = listview.getSelectionModel().getSelectedItem();
				if(selected != null && selected.getPhotoName() != null) {
					int photos_length = user.albums.get(album_index).photos.size();
					for(int current_photo = 0; current_photo < photos_length; current_photo++) {
//						System.out.println("IN LOOP " + current_photo);
						Photo current = user.albums.get(album_index).photos.get(current_photo);
						
						if(selected.getPhotoName().compareTo(current.getPhotoName()) == 0) {
							user.albums.get(album_index).photos.remove(current_photo);
//							System.out.println("photo deleted");
							break;
						}
						
					}
					
//					System.out.println("after loop");
					
			    	Photo delete = listview.getSelectionModel().getSelectedItem();
			    	obsList.remove(delete);
			    	int index = listview.getSelectionModel().getSelectedIndex();
					listview.getSelectionModel().clearSelection(index);
					obsTags.clear();
					try {
						model.findAndUpdateModel(user, user.getName());
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(obsList.isEmpty()) {
	
						
						dateTextField.setText("");
				    	captionTextField.setText("");
				    	imageNameTextField.setText("");
	//			    	Image firstImage = new Image("data/EmptyFolder.jpeg");
				    	imageView.setImage(null);
				    	//imageView.setImage(new Image("data/EmptyFolder.jpeg"));
				    	System.gc();
				    	
					}
					listview.getSelectionModel().select(0);
//					System.out.println("finished");
				}
	    	} else {
	    		listEmpty.setVisible(true);
	    	}
	    }
	    
	    
	    /**
	     * used to delete
	     * @param event used to delete
	     */
	    @FXML
	    void deleteButton(ActionEvent event) {

	    }
	    

	    /**
	     * delete tag from individual photo
	     * @param event delete tag from individual photo
	     */
	    @FXML
	    void deleteTagButton(ActionEvent event) {
	    	if(listview.getSelectionModel().getSelectedItem() == null) return;
	    	if(!obsList.isEmpty()){
	    		if(tagListView.getSelectionModel().getSelectedItem() != null) {
		    		String remove = tagListView.getSelectionModel().getSelectedItem();
		    		//System.out.println(remove);
		    		int index = tagListView.getSelectionModel().getSelectedIndex();
		    		//System.out.println("index: " + index);
		    		tagListView.getItems().remove(index);
		    		boolean deleted_check = listview.getSelectionModel().getSelectedItem().removeFormatTag(remove);
		    		
					try {
						model.findAndUpdateModel(user, user.getName());
					} catch (ClassNotFoundException | IOException INaddTag) {
						// TODO Auto-generated catch block
						INaddTag.printStackTrace();
					}
	    		} 
//	    		else System.out.println("TESTING: NO SELECTION IN TAG LIST");
	    	}else {
	    		listEmpty.setVisible(true);
	    	}
	    }
	    
	    

	    /**
	     * move photo from one album to another album of users choosing
	     * @param event button to move photo from one album to another
	     */
	    @FXML
	    void moveButton(ActionEvent event) {
	    	//if(listview.getSelectionModel().getSelectedItem() == null) return;
		    if(!obsList.isEmpty()){
//		    	System.out.println("move in");
	            Stage mvPhotoWindow = new Stage();
	            
	            GridPane root = new GridPane();
	            Text instructions = new Text("Choose an album to move to:");
	            Button moveTag = new Button("MOVE");
	            Button cancelTag = new Button("CANCEL");
	            
	            ObservableList<PhotoAlbum> obs_album = FXCollections.observableArrayList();
	            ListView<PhotoAlbum> list_album = new ListView<PhotoAlbum>(); 
	            obs_album.addAll(user.albums);
	            list_album.setItems(obs_album);
	            
	            root.setPadding(new Insets(10,10,10,10));
	            root.setHgap(10);
	            root.setVgap(10);
	            //insertTagName.setPrefColumnCount(5);
	            //insertTagValue.setPrefColumnCount(5);
	            
	            Text error = new Text("Please select an album.");

	            root.add(instructions, 0, 0);
	            root.add(list_album, 0, 1);
	            root.add(error, 0, 2);
	            root.add(moveTag, 0, 3);
	            root.add(cancelTag, 0, 4);
	            
	            error.setVisible(false);
	            
	            GridPane.setValignment(list_album, VPos.CENTER);
	            GridPane.setValignment(moveTag, VPos.BOTTOM);
	            GridPane.setValignment(cancelTag, VPos.BOTTOM);
	            
	            Scene UI = new Scene(root);
	            mvPhotoWindow.setScene(UI);
	            mvPhotoWindow.show();
	            
	            moveTag.setOnAction(new EventHandler<ActionEvent>() {
	            	public void handle(ActionEvent e) {
	            		error.setVisible(false);
	            		if(list_album.getSelectionModel().getSelectedItem() == null) return;
	            		boolean same_album = (list_album.getSelectionModel().getSelectedItem().getAlbumName().compareTo(userData.getUserAlbum()) == 0);
	            		if(list_album.getSelectionModel().getSelectedItem() == null || same_album) {
	            			error.setVisible(true);
	            		} else {
	            			
//	            			System.out.println("before loop");
	            			
	            			user = userData.getUserData();			
	            			int album_index = userData.getAlbumIndex();
	            			
	            			Photo selected = listview.getSelectionModel().getSelectedItem();
		           			if(!existsInAlbum(selected, list_album.getSelectionModel().getSelectedItem().getName())) {            			
		            			int photos_length = user.albums.get(album_index).photos.size();
		            			for(int current_photo = 0; current_photo < photos_length; current_photo++) {
//		            				System.out.println("IN LOOP " + current_photo);
		            				Photo current = user.albums.get(album_index).photos.get(current_photo);
		            				if(selected.getPhotoName().compareTo(current.getPhotoName()) == 0) {
		            					user.albums.get(album_index).photos.remove(current_photo);
//		            					System.out.println("photo deleted");
		            					break;
		            				}
		            				
		            			}
		            			
//		            			System.out.println("after loop");
		            			
		            			list_album.getSelectionModel().getSelectedItem().addPhoto(selected);
		            			obsList.remove(selected);
		            			int index = listview.getSelectionModel().getSelectedIndex();
		            			listview.getSelectionModel().clearSelection(index);
		            			obsTags.clear();
		            			
		        				try {
		        					model.findAndUpdateModel(user, user.getName());
		        				} catch (ClassNotFoundException | IOException INaddTag) {
		        					// TODO Auto-generated catch block
		        					INaddTag.printStackTrace();
		        				}
		           			} else {
		           				duplicatePhoto.setVisible(true);
		           			}
		           			mvPhotoWindow.close();
	            		}
	            	}
	            });
	            
	            cancelTag.setOnAction(new EventHandler<ActionEvent>() {
	            	public void handle(ActionEvent e) {
	            		mvPhotoWindow.close();
	            	}
	            });
	    	}else {
	    		listEmpty.setVisible(true);
	    	} 
	    }
	    
	    
	    
	    @FXML
	    void renameAlbumButton(ActionEvent event) {

	    }

	    @FXML
	    void renameCancel(ActionEvent event) {

	    }

	    @FXML
	    void renameSave(ActionEvent event) {

	    }

	    @FXML
	    void save(ActionEvent event) {

	    }
	    
	    
	    /**
	     * display to slide show view with the current selected item being passed to the view
	     * @param event trigger the slideshow view with selected image
		 * @throws IOException if stream to file cannot be written to or closed.
	     */
	    @FXML
	    void slideShowButton(ActionEvent event) throws IOException {
	    	
	    	if(!obsList.isEmpty()) {
	    		userData.setUserData(user);
		    	int index = listview.getSelectionModel().getSelectedIndex();
		    	userData.setPictureIndex(index);
				//photoAlbum = listview.getSelectionModel().getSelectedItem();
		    	
	    		Stage stage = (Stage) backButton.getScene().getWindow();
	    		Parent root = FXMLLoader.load((getClass().getResource("/view/SlideShowView.fxml")));
	    		stage.setTitle(user.getName() + "'s Photo Albums");
	    		stage.setScene(new Scene(root));
	    	}else {
	    		listEmpty.setVisible(true);
	    	}
	    	


	    }
	    
	    @FXML
	    void cancel(ActionEvent event) {

	    }
	    
	    /**
	     * watches if user clicks on the listView and populates the selected item into the details screen on the right
	     * of the PhotosListView
	     * @param event fills in the data into the details when user selects an individual photo
	     */
	    @FXML
	    void listviewClick(MouseEvent event) {
	    	
	    	if(!obsList.isEmpty()){
	    		
				if(listview.getSelectionModel().getSelectedItem() != null) {
					obsTags.clear();
					obsTags.addAll(listview.getSelectionModel().getSelectedItem().getFormatTags());
					tagListView.setItems(obsTags);
				}
	    		
	    		int deleteIndex = listview.getSelectionModel().getSelectedIndex();
		    	Photo photo =  listview.getSelectionModel().getSelectedItem();
		    	
		    	dateTextField.setText(photo.getDate());
		        imageNameTextField.setText(photo.getPhotoName());
		        Image image = new Image(photo.getFilePath().toURI().toString());
		    	imageView.setImage(image);
		    	
		    	captionTextField.setText(user.albums.get(userData.getAlbumIndex()).photos.get(deleteIndex).getCaption());
		    	
	    	}else {
	    		listEmpty.setVisible(true);
	    	}
	    	
	    }
	    
	    /**
	     * Watches if user clicks the tagslistView 
	     * @param event Watches if user clicks the tagslistView
	     */
	    @FXML
	    void taglistViewClick(MouseEvent event) {

	    }

}


