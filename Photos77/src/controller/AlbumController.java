package controller;



import model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EventObject;
import java.util.ResourceBundle;

//import com.sun.glass.ui.Size;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;



public class AlbumController implements Initializable  {
		
	/**
	 * All the fields in the AlbumController
	 */
		@FXML
		private AnchorPane normalScreen;
	 	
		@FXML
	    private AnchorPane hiddenScreen;
		
	    @FXML
	    private Button cancelSearchScreen;

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////BEGINNING NORMAL SCREEN VARIABLES///////////////////////////////////////////////////////
	 	@FXML
	    private TextField enterNewAlbum;
	    
	    @FXML
	    private Label albumHeader;
	    
	    @FXML
	    private Button cancelButton;
	    
	    @FXML
	    private Button createNewAlbumButton;
	    
	    @FXML
	    private Button deleteAlbumButton;
	    
	    @FXML
	    private Button logOutButton;

	    @FXML
	    private Button openAlbumButton;

	    @FXML
	    private Button renameAlbumButton;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private TextField renameNewAlbum;

	    @FXML
	    private Button renameSaveButton;

	    @FXML
	    private Button renameCancelButton;
	    
	    @FXML
	    private Button searchButton;

	    @FXML
	    private Label duplicateAlbum;
	    
	    @FXML
	    private TableView<PhotoAlbum> listview;
	    
	    @FXML
	    private TableColumn<PhotoAlbum, String> albumName;
	    
	    @FXML
	    private TableColumn<PhotoAlbum, Integer> numberOfPhotos;
	    
	    @FXML
	    private TableColumn<PhotoAlbum, String> earliestDate;

	    @FXML
	    private TableColumn<PhotoAlbum, String> latestDate;

	    
	    @FXML
	    private Button searchAccept;
	    

	    @FXML
	    private Button cancelSearch;
	    

//	    @FXML
//	    private TextField searchTextField;
	    
//	    @FXML
//	    private ListView<?> searchListView;

	    static User user;

	    static PhotoAlbum photoAlbum;
	    
	    static Model model = new Model();
	   
	    @FXML
	    private  ObservableList<PhotoAlbum> obsList = FXCollections.observableArrayList();
	    
	    public ArrayList<String> searchAlbumStorage = new ArrayList<String>();
	    
//	    @FXML
//	    private  ObservableList<ImageView> obsListImage = FXCollections.observableArrayList();

	    

		private String name;
		
		//Pass data between windows
	    PassUserData userData = PassUserData.getInstance();
	
	
/////////////////////////////////END NORMAL SCREEN VARIABLES//////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////BEGINNING HIDDEN SCREEN VARIABLES///////////////////////////////////////////////////////
	    @FXML
	    private CheckBox searchByNameCheckBox;
	    
	    @FXML
	    private CheckBox searchByDateCheckBox;
  
	    @FXML
	    private CheckBox searchByTagCheckBox;
	    
	    @FXML
	    private TextField searchTextField;
	    
	    @FXML
	    private Button cancelSearchTextFieldButton;
	    
	    @FXML
	    private Button searchAcceptTextFieldButton;
	    
	    @FXML
	    private Label fromDateLabel;
	    
	    @FXML
	    private DatePicker fromDateSearchField;
	    
	    @FXML
	    private Label toDateLabel;
	    
	    @FXML
	    private DatePicker toDateSearchField;
	
	    @FXML
	    private Button searchDateSearchButton;
	    
	    @FXML
	    private Button cancelDateSearchButton;
	    
	    @FXML
	    private Button searchCreateNewAlbumButton;
	    
	    @FXML
	    private ListView<Photo> searchListView;
	    

	    @FXML
	    private Label searchNewAlbumLabel;

	    @FXML
	    private TextField searchNewAlbumTextField;

	    @FXML
	    private Button searchSaveNewAlbumButton;
	    
	    @FXML
	    private Button searchCancelNewAlbumButton;
	    
	    @FXML
	    private Label searchDateErrorMessage;
	    
	    @FXML
	    private  ObservableList<Photo> searchObsList = FXCollections.observableArrayList();
	    
	    @FXML
	    private CheckBox addConjuctionTag;
	    
	    @FXML
	    private CheckBox orDisjunctionTag;
	    
	    @FXML
	    private ComboBox tagOneName;
	    
	    @FXML
	    private ComboBox tagOneValue;

	    @FXML
	    private ComboBox tagTwoName;

	    @FXML
	    private ComboBox tagTwoValue;
	    
	    @FXML
	    private Button searchTagButton;
	    
	    @FXML
	    private Button cancelTagButton;
	    
	    @FXML
	    private Label tagOneLabel;
	    
	    @FXML
	    private Label tagTwoLabel;
	    
	    @FXML
	    private TextField searchNameTextField;
	    
	    @FXML
	    private TextField searchCaptionTextField;
	    
	    @FXML
	    private TextField searchDateTextField;
	    
	    @FXML
	    private TextField searchAlbumTextField;
	    
	    @FXML
	    private ListView<String> searchTagsListView;
	    
	    @FXML
	    private ObservableList<String> obsTags = FXCollections.observableArrayList();
	    
	    //public ArrayList<Photo> results = new ArrayList<Photo>();
	
/////////////////////////////////END HIDDEN SCREEN VARIABLES//////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//    @FXML
//    private Button searchAccept1;
//
//    
//
//    @FXML
//    private TextField searchTextField1;

   
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////NORMAL SCREEN///////////////////////////////////////////////////////////////////////////


	    /* - - - - - - - - - - - - - - */
	    /* SEARCH FUNCTIONALITY START */
	    /* - - - - - - - - - - - - - - */
	    /**
	     * gets the all the tags and store it in total_tags for later use in search
	     * @return total_tags array of all the tags for use in search combo box
	     */
	    public ArrayList<String> getAllTags() {
	    	ArrayList<String> total_tags = new ArrayList<String>();
	    	int numberOfAlbums = user.albums.size();
	    	for(int currentAlbumIndex = 0; currentAlbumIndex < numberOfAlbums; currentAlbumIndex++) {
	    		int numberOfPhotos = user.albums.get(currentAlbumIndex).photos.size();
	    		for(int currentPhotoIndex = 0; currentPhotoIndex < numberOfPhotos; currentPhotoIndex++) {
		    		Photo current_photo = user.albums.get(currentAlbumIndex).photos.get(currentPhotoIndex);
	    			ArrayList<String> TAGNAMES = current_photo.getTagNames();
	    			int TAGNAMES_LENGTH = TAGNAMES.size();
	    			for(int current_TAG = 0; current_TAG < TAGNAMES_LENGTH; current_TAG++) {
	    				if(!(total_tags.contains(TAGNAMES.get(current_TAG)))) total_tags.add(TAGNAMES.get(current_TAG));
	    			}
	    		}
	    	}
	    	return total_tags;
	    }
	    
	    /**
	     * gets all the values and store it in valsOf_list for later use in search
	     * @param tag_name tag name that is passed in
	     * @return valsOf_list gets all the values and stores it for later use in search
	     */
	    public ArrayList<String> getAllValsFromTags(String tag_name) {
	    	ArrayList<String> valsOf_list = new ArrayList<String>();
	    	int numberOfAlbums = user.albums.size();
	    	for(int currentAlbumIndex = 0; currentAlbumIndex < numberOfAlbums; currentAlbumIndex++) {
	    		int numberOfPhotos = user.albums.get(currentAlbumIndex).photos.size();
	    		for(int currentPhotoIndex = 0; currentPhotoIndex < numberOfPhotos; currentPhotoIndex++) {
		    		Photo current_photo = user.albums.get(currentAlbumIndex).photos.get(currentPhotoIndex);
		    		ArrayList<String> TAGNAMES = current_photo.getTagNames();
	    			ArrayList<String> TAGVALS = current_photo.getTagValues();
	    			int TAGNAMES_LENGTH = TAGNAMES.size();
	    			for(int current_TAG = 0; current_TAG < TAGNAMES_LENGTH; current_TAG++) {
	    				if(TAGNAMES.get(current_TAG).compareTo(tag_name) == 0 & !valsOf_list.contains(TAGVALS.get(current_TAG))) {
	    					valsOf_list.add(TAGVALS.get(current_TAG));
	    				}
	    			}
	    		}
	    	}
	    	return valsOf_list;
	    }
	    
	    /**
	     * creates tag list from first_name and first_value.
	     * creates tag list from second_name and second_value.
	     * combine all photos from both tag list and checks that they are in both lists
	     * @param first_name first name of tag
	     * @param first_value fist value of tag
	     * @param second_name second name of tag
	     * @param second_value second value of tag
	     * @return and returns photos that contain both tags
	     */
	    public ArrayList<Pair<Photo, String>> conjunctiveTag(String first_name, String first_value, String second_name, String second_value) {
	    	// System.out.println("");
	    	ArrayList<Pair<Photo, String>> and = new ArrayList<Pair<Photo, String>>();
	    	ArrayList<Pair<Photo, String>> first = grabByTag(first_name, first_value);
	    	ArrayList<Pair<Photo, String>> second = grabByTag(second_name, second_value);
	    	int first_length = first.size();
	    	int second_length = second.size();
	    	//System.out.println("");
	    	for(int first_currentIndex = 0; first_currentIndex < first_length; first_currentIndex++) {
	    		Pair<Photo, String> current_first = first.get(first_currentIndex);
				ArrayList<String> TAGNAMES = current_first.getKey().getTagNames();
				ArrayList<String> TAGVALUE = current_first.getKey().getTagValues();
				int TAGNAMES_LENGTH = TAGNAMES.size();
				for(int current_TAG = 0; current_TAG < TAGNAMES_LENGTH; current_TAG++) {
					if(TAGNAMES.get(current_TAG).compareTo(second_name) == 0) {
						if(TAGVALUE.get(current_TAG).compareTo(second_value) == 0) {
							if(!and.contains(current_first)) and.add(current_first);
							break;
						}
					}
				}
	    	}
	    	for(int second_currentIndex = 0; second_currentIndex < second_length; second_currentIndex++) {
	    		Pair<Photo, String> current_second = second.get(second_currentIndex);
				ArrayList<String> TAGNAMES = current_second.getKey().getTagNames();
				ArrayList<String> TAGVALUE = current_second.getKey().getTagValues();
				int TAGNAMES_LENGTH = TAGNAMES.size();
				for(int current_TAG = 0; current_TAG < TAGNAMES_LENGTH; current_TAG++) {
					if(TAGNAMES.get(current_TAG).compareTo(first_name) == 0) {
						if(TAGVALUE.get(current_TAG).compareTo(first_value) == 0) {
							if(!and.contains(current_second)) and.add(current_second);
							break;
						}
					}
				}
	    	}
	    	return and;
	    }
	    
	    
	    /**
	     * creates tag list from first_name and first_value.
	     * creates tag list from second_name and second_value.
	     * combines both list.
	     * @param first_name first name of tag
	     * @param first_value fist value of tag
	     * @param second_name second name of tag
	     * @param second_value second value of tag
	     * @return or returns combined list of both tags
	     */
	    public ArrayList<Pair<Photo, String>> disjunctiveTag(String first_name, String first_value, String second_name, String second_value) {
	    	ArrayList<Pair<Photo, String>> or = new ArrayList<Pair<Photo, String>>();
	    	or.addAll(grabByTag(first_name, first_value));
	    	ArrayList<Pair<Photo, String>> second = grabByTag(second_name, second_value);
	    	int second_size = second.size();
	    	for(int i = 0; i < second_size; i++) {
	    		if(!(or.contains(second.get(i)))) or.add(second.get(i));
	    	}
	    	return or;
	    }
	    
	    /**
	     * compares name and value to all photo tag pairs in User albums
	     * @param name target name search
	     * @param value the value of the tag
	     * @return tagList tagList of all photos that have the name and value as a tag
	     */
	    public ArrayList<Pair<Photo, String>> grabByTag(String name, String value) {
	    	ArrayList<Pair<Photo, String>> tagList = new ArrayList<Pair<Photo, String>>();
	    	
	    	int numberOfAlbums = user.albums.size();
	    	for(int currentAlbumIndex = 0; currentAlbumIndex < numberOfAlbums; currentAlbumIndex++) {
	    		int numberOfPhotos = user.albums.get(currentAlbumIndex).photos.size();
	    		for(int currentPhotoIndex = 0; currentPhotoIndex < numberOfPhotos; currentPhotoIndex++) {
	    			Photo currentPhoto = user.albums.get(currentAlbumIndex).photos.get(currentPhotoIndex);
	    			ArrayList<String> TAGNAMES = currentPhoto.getTagNames();
	    			ArrayList<String> TAGVALUE = currentPhoto.getTagValues();
	    			int TAGNAMES_LENGTH = TAGNAMES.size();
	    			boolean equalsTag = false;
	    			for(int CURRENT_TAG = 0; CURRENT_TAG < TAGNAMES_LENGTH; CURRENT_TAG++) {
	    				if(TAGNAMES.get(CURRENT_TAG).compareTo(name) == 0 & TAGVALUE.get(CURRENT_TAG).compareTo(value) == 0) {
	    					equalsTag = true;
	    					break;
	    				}
	    				
	    			}
	    			
	    			String current_album_name = user.albums.get(currentAlbumIndex).getAlbumName();
	    			Pair<Photo, String> photo_pair = new Pair<>(currentPhoto, current_album_name);
	    			if(equalsTag & !tagList.contains(photo_pair)) tagList.add(photo_pair);
	    		}
	    	}
	    	
	    	return tagList;
	    }
	    /*
	    public ArrayList<Photo> grabByTagName(String name) {
	    	return grabByTag(name, "\n\t");
	    }
	    public ArrayList<Photo> grabByTagValue(String value) {
	    	return grabByTag("\n\t", value);
	    }
	    */
	    
	    
	    /* - - - - - - - - - - - - - - */
	    /* SEARCH FUNCTIONALITY ENDING */
	    /* - - - - - - - - - - - - - - */

	    /**
	     * Called to initialize AlbumController after its root element has been completely processed.
	     * @param arg0 used to resolve relative paths for the root object, or null if the location is not known.
	     * @param arg1 used to localize the root object, or null if the root object was not localized.
	     */ 
	    public void initialize(URL arg0, ResourceBundle arg1) {

	       	

	       	user = userData.getUserData();	
	       	
	       	String name = user.getName();
	       	

	       	
//	       	System.out.println("THis is name: " + name);
				//System.out.println("THis is findUser.getName(): " + findUser.getName());
	       	
	       		
	   		
	         	ArrayList<User> arrayList;
	   		try {
	   			arrayList = model.readFromFile();
	   			int i = 0;
	           	for(User findUser: arrayList) {
	           		
	           		
//	           		System.out.println("i: "+ i);
	           		if(name.equals(findUser.getName())) {
	           			
	           			
	           			
	       /////////////////////////////////////////////////////////////////////////////////////////
	           			for(int index = 0; index < user.albums.size(); index++) {
//	           				System.out.println("user.albums: "+ user.albums.get(index) + "-> "+ user.albums.get(index).photos.size());
	           			
	           				albumName.setStyle("-fx-alignment: CENTER-LEFT;");
	               			numberOfPhotos.setStyle("-fx-alignment: CENTER;");
	               			earliestDate.setStyle("-fx-alignment: CENTER;");
	               			latestDate.setStyle("-fx-alignment: CENTER;");
	               			albumName.setMinWidth(150);
	               			

	               			albumName.setCellValueFactory(new PropertyValueFactory<PhotoAlbum, String>("name"));
	               		    numberOfPhotos.setCellValueFactory(new PropertyValueFactory<PhotoAlbum, Integer>("albumSize"));
	               		   	earliestDate.setCellValueFactory(new PropertyValueFactory<PhotoAlbum, String>("earliestDate"));
	               		   	latestDate.setCellValueFactory(new PropertyValueFactory<PhotoAlbum, String>("latestDate"));
	   
	               		 
//	               		 System.out.println("INDEX: "+ index);
	               		    //Sets to object so table can pull from its getMethod
	               		    if(findUser.albums.get(index) != null && findUser.albums.get(index).photos != null) {
	               		    	
	               		    	findUser.albums.get(index).setAlbumSize(findUser.albums.get(index).photos.size());
	          		    
	               		    	
	               		    	String earliest = null;
	               		    	String latest = null;
	               		    	
	               		    	//For loop goes through each picture and check if the date
	               		    	//is greater or less than and stores it in earliest or latest String
	               		    	for(int j = 0; j < findUser.albums.get(index).photos.size(); j++ ) {
	               		    		
	               		    		if(j == 0) {
	               		    			earliest = findUser.albums.get(index).photos.get(j).getDate();
	               		    			latest = findUser.albums.get(index).photos.get(j).getDate();
	               		    			
	               		    		}else if(earliest.compareTo(findUser.albums.get(index).photos.get(j).getDate()) > 0) {
	               		    			
	               		    			earliest = findUser.albums.get(index).photos.get(j).getDate();
	               		    			
	               		    		}else if(latest.compareTo(findUser.albums.get(index).photos.get(j).getDate()) < 0) {
	               		    			latest = findUser.albums.get(index).photos.get(j).getDate();
	               		    			
	               		    		}
	 
	               		    	
	               		    	
	               		    	}
	               		    	
	 
	               		    	if(earliest != null && latest != null) {
	               		    		findUser.albums.get(index).setEarliestDate(earliest.substring(0, 10));
		               		    	findUser.albums.get(index).setLatestDate(latest.substring(0, 10));
	               		    	}else {
	               		    		findUser.albums.get(index).setEarliestDate("empty folder");
	               		    		findUser.albums.get(index).setLatestDate("empty folder");
	               		    	}
	               		    	
	               		    	

	               		    }else {
	               		    	findUser.albums.get(index).photos.get(index).setAlbumSize(0);
	               		    	//findUser.albums.get(i).setAlbumSize(findUser.albums.get(i).photos.size());
	               		    }
	           			
	           			}
	       /////////////////////////////////////////////////////////////////////////////////////////

	           		    
	           			obsList.addAll(findUser.albums);

	           			listview.setItems(obsList);
	           	    	
	           	    	
	           	    	
	           			break;
	           		}
	           			
	           		i++;
	           	}
	           	
	           	listview.getSelectionModel().select(0);
	           	
	   		} catch (ClassNotFoundException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		} catch (IOException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}

	   		
	   	}
	    
	    /**
	     * Checkbox for conjunction search
	     * @param event Checkbox for conjunction search
	     */
	    @FXML
	    void addConjuctionTag(ActionEvent event) {
	    	boolean disabledOR = orDisjunctionTag.isDisabled();
	    	disabledOR = !disabledOR;
	    	orDisjunctionTag.setDisable(disabledOR);
	    	tagTwoName.setDisable(!disabledOR);
	    	tagTwoValue.setDisable(!disabledOR);
	    	tagTwoLabel.setDisable(!disabledOR);
	    }
	    
	    /**
	     * Checkbox for disjunction search
	     * @param event Checkbox for disjunction search
	     */
	    @FXML
	    void orDisjunctionTag(ActionEvent event) {
	    	boolean disabledAND = addConjuctionTag.isDisabled();
	    	disabledAND = !disabledAND;
	    	addConjuctionTag.setDisable(disabledAND);
	    	tagTwoName.setDisable(!disabledAND);
	    	tagTwoValue.setDisable(!disabledAND);
	    	tagTwoLabel.setDisable(!disabledAND);
	    }
	    

	    /**
	     * Combobox for firsts tag name. populates tag one value
	     * @param event Combobox for firsts tag name. populates tag one value
	     */
	    @FXML
	    void tagOneName(ActionEvent event) {
	    	if(tagOneName.getSelectionModel().getSelectedItem() != null) {
	    		tagOneValue.setDisable(true);
	    		String selected = tagOneName.getSelectionModel().getSelectedItem().toString();
		    	ObservableList<String> obsTotal_tags = FXCollections.observableArrayList();
		    	obsTotal_tags.addAll(getAllValsFromTags(selected));
		    	tagOneValue.setItems(obsTotal_tags);
		    	
		    	//System.out.println("INTERATION WITH SECOND TAG NAME: " + selected);
		    	tagOneValue.setDisable(false);
	    	}
	    }
	    
	    /**
	     * Combobox for second tag name. populates tag two value
	     * @param event Combobox for second tag name. populates tag two value
	     */
	    @FXML
	    void tagTwoName(ActionEvent event) {
	    	if(tagTwoName.getSelectionModel().getSelectedItem() != null) {
	    		tagTwoValue.setDisable(true);
	    		String selected = tagTwoName.getSelectionModel().getSelectedItem().toString();
	    	
	    		ObservableList<String> obsTotal_tags = FXCollections.observableArrayList();
	    		obsTotal_tags.addAll(getAllValsFromTags(selected));
	    		tagTwoValue.setItems(obsTotal_tags);
	    	
	    		//System.out.println("INTERATION WITH SECOND TAG NAME: " + selected);
	    		tagTwoValue.setDisable(false);
	    	}
	    }
	    
	    
	    /**
	     * populates list with photos that meet tag search parameters
	     * @param event populates list with photos that meet tag search parameters
	     */
	    @FXML
	    void searchTagButton(ActionEvent event) {
	    	
	    	ArrayList<Pair<Photo, String>> results = new ArrayList<Pair<Photo, String>>();
	    	
	    	String name_one = "";
	    	String value_one = "";
	    	String name_two = "";
	    	String value_two = "";
	    	
	    	if(tagOneName.getSelectionModel().getSelectedItem() != null) name_one += tagOneName.getSelectionModel().getSelectedItem().toString();
	    	if(tagOneValue.getSelectionModel().getSelectedItem() != null) value_one += tagOneValue.getSelectionModel().getSelectedItem().toString();
	    	if(tagTwoName.getSelectionModel().getSelectedItem() != null) name_two += tagTwoName.getSelectionModel().getSelectedItem().toString();
	    	if(tagTwoValue.getSelectionModel().getSelectedItem() != null) value_two += tagTwoValue.getSelectionModel().getSelectedItem().toString();
	    	
	    	boolean valid_firstname = name_one.compareTo("") != 0;
	    	boolean valid_firstvalue = value_one.compareTo("") != 0;
	    	boolean valid_first = valid_firstname & valid_firstvalue;
	    	
	    	boolean valid_secondname = name_two.compareTo("") != 0;
	    	boolean valid_secondvalue = value_two.compareTo("") != 0;
	    	boolean valid_second = valid_secondname & valid_secondvalue;
	    	
	    	boolean proceed = false;
	    	if(addConjuctionTag.isSelected()) {
	    		if(valid_first & valid_second) {
	    			results.addAll(conjunctiveTag(name_one, value_one, name_two, value_two));
	    			proceed = true;
	    		}
	    	} else if(orDisjunctionTag.isSelected()) {
	    		if(valid_first & valid_second) {
	    			results.addAll(disjunctiveTag(name_one, value_one, name_two, value_two));
	    			proceed = true;
	    		}
	    	} else {
	    		if(valid_first) {
	    			results.addAll(grabByTag(name_one, value_one));
	    			proceed = true;
	    		}
	    	}
	    	
	    	if(proceed) {
	    		int results_length = results.size();
	    		if(results_length != 0) {
	    			
	    			ArrayList<Photo> result_photos = new ArrayList<Photo>();
	    			ArrayList<String> result_albums = new ArrayList<String>();
	    			
	    			for(int current_result = 0; current_result < results_length; current_result++) {
	    				result_photos.add(results.get(current_result).getKey());
	    				result_albums.add(results.get(current_result).getValue());
	    			}
	    			
		    		//System.out.println(results);
		    		
		    		searchAlbumStorage.clear();
		    		searchObsList.clear();
			    	searchListView.setItems(null);
			    	
			    	searchAlbumStorage.addAll(result_albums);
			    	searchObsList.addAll(result_photos);
					searchListView.setItems(searchObsList);
					
					showPhotoThumbnail();
					
					searchCreateNewAlbumButton.setDisable(false);
	    		}
	    	} else /* CATCHES INVALID SELECTIONS */ {
	    		//ERROR MESSAGE ?
	    	}
	    	
	    	
	    }

	   /**
	    * displays a textField for user to create a photoAlbum
	    * @param event displays a textField for user to create a photoAlbum
	    */
	    @FXML
	    void createNewAlbumButton(ActionEvent event) {
	    	deleteAlbumButton.setDisable(true);
	    	openAlbumButton.setDisable(true);
	    	renameAlbumButton.setDisable(true);
	    	enterNewAlbum.setVisible(true);
	    	cancelButton.setVisible(true);
	    	saveButton.setVisible(true);

	    }
	    
	    /**
	     * save the new album when button is pressed 
	     * @param event saves the new album when button is pressed 
		 * @throws IOException if stream to file cannot be written to or closed.
		 * @throws ClassNotFoundException if class is not found
	     */
	    @FXML
	    void save(ActionEvent event) throws IOException, ClassNotFoundException {
	  

	    	if(!(enterNewAlbum.getText().trim().equals("")) && !isDuplicate(enterNewAlbum.getText())){
	    		
	    		
	    	        
	    	        photoAlbum = new PhotoAlbum(enterNewAlbum.getText());
	    	        
	    	    	user.addPhotoAlbum(photoAlbum);
	    	    	
	    	    	obsList.add(photoAlbum);
	    	    	listview.setItems(obsList);
	    	    	
	    	    	
	    	    	//pull data from dat file
	    	    	ArrayList<User> arrayList = model.readFromFile(); 

	    	    	
	    	    	//update the array list by with new folder
	    	    	 model.findAndUpdateModel(user, user.getName());
	    	    	
	    	    	enterNewAlbum.setText("");
	    	    	
	    	    	duplicateAlbum.setVisible(false);
	    	    	
////////////////////////////////////////////////////////////////////////////////////////////////////////
					userData.setUserData(user);
					//obsList.clear();
					
					Stage stage = (Stage) saveButton.getScene().getWindow();
//					Parent root = FXMLLoader.load((getClass().getResource("/view/UpdatedAlbum1.fxml")));
					Parent root = FXMLLoader.load((getClass().getResource("/view/Album.fxml")));
					stage.setTitle(user.getName() + "'s Photo Albums");
					stage.setScene(new Scene(root));

////////////////////////////////////////////////////////////////////////////////////////////////////////
	    	    	
	    	    	
	    	}else {
	    		duplicateAlbum.setVisible(true);
	    		enterNewAlbum.setText("");
	    	}


	    	
	    }
	    
	    /**
	     * checks to see if the album entered is not already in the list; no duplicates allowed
	     * @param albumName sees if albumName is already in the list false if not true if albumName is in the list
	     * @return true/false when depending if item is there or not
	     */
	    public boolean isDuplicate(String albumName) {

	    	
	    	for(PhotoAlbum testingUser : obsList) {
	    		
//	    		System.out.println("Photo: " + testingUser.getAlbumName());
				if(albumName.equals(testingUser.getAlbumName())) {
//					System.out.println("Duplicate: " + testingUser.getAlbumName());
					return true;
				}
					
			}
			
	    	return false;
	    }
	    

	    /**
	     * cancel the user create display and input
	     * @param event cancels the create user interface
	     */
	    @FXML
	    void cancel(ActionEvent event) {
	    	enterNewAlbum.setText("");
	    	deleteAlbumButton.setDisable(false);
	    	openAlbumButton.setDisable(false);
	    	renameAlbumButton.setDisable(false);
	    	enterNewAlbum.setVisible(false);
	    	cancelButton.setVisible(false);
	    	saveButton.setVisible(false);
	    	duplicateAlbum.setVisible(false);
	    }
	    
	    /**
	     * deletes the album when button is pressed
	     * @param event deletes the album when the button is pressed
		 * @throws IOException if stream to file cannot be written to or closed.
	     */
	    @FXML
	    void deleteAlbumButton(ActionEvent event) throws IOException {
	    	
	    	if (!(obsList.isEmpty())) {
	    		try {

	        		int deleteIndex = listview.getSelectionModel().getSelectedIndex();
	        		photoAlbum = listview.getSelectionModel().getSelectedItem();
	            	obsList.remove(deleteIndex);
	            	model.removeAlbum(user, user.getName(), photoAlbum.getName());
	            	user.albums.remove(deleteIndex);
	            	userData.setUserData(user);


	    		}catch(IndexOutOfBoundsException e) {
	    			
	    		}
	    		
	        	
	        	
	        	
	    	}else {
	    		
	    	}
	    	
	    	
	    }

	    /**
	     * logs out of album controller and goes to loginScreen
	     * @param event logs out and goes to login screen
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
	     * opens the album to display PhotoListView and all the data and images
	     * @param event opens album to display PhotoListView and all the data and images
	     * @throws ClassNotFoundException if class is not found
	     * @throws IOException if stream to file cannot be written to or closed.
	     */
	    @FXML
	    void openAlbumButton(ActionEvent event) throws ClassNotFoundException, IOException {
	    	
		
	    	try {
	    		
	    		int index = listview.getSelectionModel().getSelectedIndex();
	    		String album = listview.getSelectionModel().getSelectedItem().getAlbumName();
	    		
	        	userData.setUserDataAndAlbum(user, album);
	        	userData.setAlbumIndex(index);
	        	//userData.setUserData(user);
	        	
	    		Stage stage = (Stage) openAlbumButton.getScene().getWindow();
	    		Parent root = FXMLLoader.load((getClass().getResource("/view/PhotosListView.fxml")));
	    		stage.setTitle(user.getName() + "'s Photo Albums");
	    		stage.centerOnScreen();
	    		stage.setScene(new Scene(root));
	    	}catch(NullPointerException e) {
//	    		System.out.println("Please select an album!");
	    	}
	    	
	    	
	    }

		/**
		 * textField appears for user to enter a new name in field
		 * @param event textfield appears when button is pressed; rename album
		 */
	    @FXML
	    void renameAlbumButton(ActionEvent event) {
	    	
	    	renameNewAlbum.setVisible(true);
	        renameSaveButton.setVisible(true);
	        renameCancelButton.setVisible(true);
	       
	    	
	    	int deleteIndex = listview.getSelectionModel().getSelectedIndex();
			photoAlbum = listview.getSelectionModel().getSelectedItem();
			 renameNewAlbum.setText(photoAlbum.getAlbumName());
	    	
			listview.setDisable(true);
	    	createNewAlbumButton.setDisable(true);;
	        deleteAlbumButton.setDisable(true);;       
	        openAlbumButton.setDisable(true);

	        

	    }

	    /**
	     * save rename album button
	     * @param event when pressed the by user the name is saved and set to the obsList/listview
		 * @throws IOException if stream to file cannot be written to or closed.
		 * @throws ClassNotFoundException if class is not found
	     */
	    @FXML
	    void renameSave(ActionEvent event) throws IOException, ClassNotFoundException {
	    	if(!(renameNewAlbum.getText().trim().equals("")) && !isDuplicate(renameNewAlbum.getText().trim())){
	    		
	    		int deleteIndex = listview.getSelectionModel().getSelectedIndex();
	    		photoAlbum = listview.getSelectionModel().getSelectedItem();
	    		//PhotoAlbum tempPhotoAlbum = photoAlbum;
	    		
	    		
//	    		tempPhotoAlbum.setName(renameNewAlbum.getText());
//	    		obsList.set(deleteIndex, tempPhotoAlbum);
	    		
	    		photoAlbum.setName(renameNewAlbum.getText());
	    		//obsList.set(deleteIndex, tempPhotoAlbum);
	    		
	    		
//	    		System.out.println("This is the obsList for debugging: " +obsList);
	    		
	    		listview.setItems(obsList);
	    	    	
	    		//listview.getSelectionModel().select(tempPhotoAlbum);
	    		listview.getSelectionModel().select(photoAlbum);
	    		
	    		model.renameAlbum(user, user.getName(), photoAlbum.getName(), renameNewAlbum.getText());
	    		
	    		
	    		renameNewAlbum.setText("");
	    		
	    		
	        	deleteAlbumButton.setDisable(false);
	        	openAlbumButton.setDisable(false);
	        	createNewAlbumButton.setDisable(false);
	        	renameAlbumButton.setDisable(false);
	        	renameNewAlbum.setVisible(false);
	        	renameCancelButton.setVisible(false);
	        	renameSaveButton.setVisible(false);
	        	listview.setDisable(false);
	        	
	        	duplicateAlbum.setVisible(false);
	        	
////////////////////////////////////////////////////////////////////////////////////////////////////////
				userData.setUserData(user);
				//obsList.clear();
				
				Stage stage = (Stage) renameSaveButton.getScene().getWindow();
				//Parent root = FXMLLoader.load((getClass().getResource("/view/UpdatedAlbum1.fxml")));
				Parent root = FXMLLoader.load((getClass().getResource("/view/Album.fxml")));
				stage.setTitle(user.getName() + "'s Photo Albums");
				stage.setScene(new Scene(root));

////////////////////////////////////////////////////////////////////////////////////////////////////////
	    		
	    		
	    		
	    		
	    		
	    	}else {
	    		renameNewAlbum.setText("");
	    		duplicateAlbum.setVisible(true);
	    	}
	    }
	   
	    /**
	     * cancel rename 
	     * @param event cancel rename input
		 * @throws IOException if stream to file cannot be written to or closed.
		 * @throws ClassNotFoundException if class is not found
	     */
	    @FXML
	    void renameCancel(ActionEvent event) throws IOException, ClassNotFoundException {
	    	renameNewAlbum.setText("");
	    	deleteAlbumButton.setDisable(false);
	    	openAlbumButton.setDisable(false);
	    	createNewAlbumButton.setDisable(false);
	    	renameAlbumButton.setDisable(false);
	    	renameNewAlbum.setVisible(false);
	    	renameCancelButton.setVisible(false);
	    	renameSaveButton.setVisible(false);
	    	listview.setDisable(false);
	    	
	    	duplicateAlbum.setVisible(false);
	    	
	    	
	    	
	    }
	    

	    /**
	     * search button to go to user search interface
	     * @param event button to go to user search interface
	     */
	    @FXML
	    void searchButton(ActionEvent event) {
	    	
	    	normalScreen.setVisible(false);
	    	hiddenScreen.setVisible(true);
	    	
	    	cancelSearchScreen.setVisible(true);
	    	searchButton.setDisable(true);
	    	

	    	
	    }
	    

	    @FXML
	    void searchAccept(ActionEvent event) {
	    	

	    }
	    

	    /**
	     * cancel search interface and sets all input to null
	     * @param event cancel search interface
	     */
	    @FXML
	    void cancelSearch(ActionEvent event) {
	    	searchTextField.setText("");
	    	searchTextField.setVisible(false);
	    	searchAccept.setVisible(true);
	    	albumHeader.setVisible(true);
	    	searchButton.setVisible(true);
	    	cancelSearch.setVisible(false);
	    	searchAccept.setVisible(false);
	    	
	    	listview.setVisible(true);
	    	searchListView.setVisible(false);
	    	
	    	openAlbumButton.setVisible(true);
	    	createNewAlbumButton.setVisible(true);
	    	renameAlbumButton.setVisible(true);
	    	deleteAlbumButton.setVisible(true);
	    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////HIDDEN SCREEN///////////////////////////////////////////////////////////////////////////
	    /**
	     * cancel search interface and sets all input to null
	     * @param event cancel search interface
	     */
	    @FXML
	    void cancelSearchScreen(ActionEvent event) {
	    	hiddenScreen.setVisible(false);
	    	normalScreen.setVisible(true);
	    	
	    	
	    	searchButton.setDisable(false);
	    	cancelSearchScreen.setVisible(false);
	    	
	    	//set all fields to false when cancelled
	    	searchByNameCheckBox.setDisable(false);
	    	searchByDateCheckBox.setDisable(false);
	    	searchByTagCheckBox.setDisable(false);
	    	
	    	searchByNameCheckBox.setSelected(false);
	    	searchByDateCheckBox.setSelected(false);
	    	searchByTagCheckBox.setSelected(false);
	    	
	    	
	    	//hides SearchByName TextField and Buttons
	    	searchTextField.setText("");
	    	searchTextField.setVisible(false);
	        cancelSearchTextFieldButton.setVisible(false);
	        searchAcceptTextFieldButton.setVisible(false);
	        
	        //hides CreateNewAlbumButton TextField and Button
	        searchCreateNewAlbumButton.setDisable(true);
	        searchNewAlbumTextField.setText("");
	    	searchNewAlbumLabel.setVisible(false);
	    	searchNewAlbumTextField.setVisible(false);
	    	searchCancelNewAlbumButton.setVisible(false);
	    	searchSaveNewAlbumButton.setVisible(false);
	    	
	    	//hides datePicker and clears data in it
	    	fromDateSearchField.setValue(null);
	    	toDateSearchField.setValue(null);
	    	fromDateLabel.setVisible(false); 	    
	 	   	fromDateSearchField.setVisible(false);	 	    
	 	   	toDateLabel.setVisible(false);	 	    
	 	    toDateSearchField.setVisible(false);	 	
	 	    searchDateSearchButton.setVisible(false);	 	    
	 	    cancelDateSearchButton.setVisible(false);
	 	    searchDateErrorMessage.setVisible(false);
	 	    
	 	    //hides tags
	    	addConjuctionTag.setVisible(false);
		    orDisjunctionTag.setVisible(false);
		    tagOneName.setVisible(false);
		    tagOneValue.setVisible(false);
		    tagTwoName.setVisible(false);
		    tagTwoValue.setVisible(false);
		    tagOneLabel.setVisible(false);
		    tagTwoLabel.setVisible(false);
		    searchTagButton.setVisible(false);
		    cancelTagButton.setVisible(false);
		    
		    searchNameTextField.setText("");
	    	searchCaptionTextField.setText("");
	    	searchDateTextField.setText("");
	    	searchAlbumTextField.setText("");
	        
	        searchObsList.clear();
	        searchListView.setItems(null);

	        
	    }
	    
	    /**
	     * checkbox to bring up search by name/caption
	     * @param event check the box to bring up search by name/caption
	     */
	    @FXML
	    void searchByNameCheckBox(ActionEvent event) {
	    	searchByNameCheckBox.setDisable(true);
	    	searchByDateCheckBox.setDisable(true);
	    	searchByTagCheckBox.setDisable(true);
	    	
	        searchTextField.setVisible(true);
	        cancelSearchTextFieldButton.setVisible(true);
	        searchAcceptTextFieldButton.setVisible(true);
	    }
	    
	    /**
	     * cancel the search by name/caption interface
	     * @param event cancel the search by name/caption interface
	     */
	    @FXML
	    void cancelSearchTextFieldButton(ActionEvent event) {
	    	
	    	
	    	
	    	//set all fields to false when cancelled
	    	searchByNameCheckBox.setDisable(false);
	    	searchByDateCheckBox.setDisable(false);
	    	searchByTagCheckBox.setDisable(false);
	    	
	    	searchByNameCheckBox.setSelected(false);
	    	searchByDateCheckBox.setSelected(false);
	    	searchByTagCheckBox.setSelected(false);
	    	
	    	//hides SearchByName TextField and Buttons
	    	searchTextField.setText("");
	    	searchTextField.setVisible(false);
	        cancelSearchTextFieldButton.setVisible(false);
	        searchAcceptTextFieldButton.setVisible(false);
	        
	        //hides CreateNewAlbumButton TextField and Button
	        searchCreateNewAlbumButton.setDisable(true);
	        searchNewAlbumTextField.setText("");
	    	searchNewAlbumLabel.setVisible(false);
	    	searchNewAlbumTextField.setVisible(false);
	    	searchCancelNewAlbumButton.setVisible(false);
	    	searchSaveNewAlbumButton.setVisible(false);
	    	
	    	//blanks all the textfield text boxes
		    searchNameTextField.setText("");
	    	searchCaptionTextField.setText("");
	    	searchDateTextField.setText("");
	    	searchAlbumTextField.setText("");
	        
	        searchObsList.clear();
	        searchListView.setItems(null);
	        searchTagsListView.getItems().clear();
	    } 
	    

	    /**
	     * button to search after user inputs information in the field
	     * @param event button to search after user inputs information in the field
	     */
	    @FXML
	    void searchAcceptTextFieldButton(ActionEvent event) {
	    	
	    	searchObsList.clear();
	    	searchListView.setItems(null);
	    	searchAlbumStorage.clear();
	    	
	    	String search = searchTextField.getText();
	    	
//	    	 System.out.println("Search: " + search);
	    	
	    	for(int i = 0; i < user.albums.size(); i++ ) {
//	    		System.out.println("Album: " + user.albums.get(i).getAlbumName());
	    		for(int j = 0; j < user.albums.get(i).photos.size(); j++) {
	    			
	    			if(user.albums.get(i).photos.get(j).getPhotoName().toLowerCase().contains(search.toLowerCase()) 
	    					|| (user.albums.get(i).photos.get(j).getCaption() != null && user.albums.get(i).photos.get(j).getCaption().toLowerCase().contains(search.toLowerCase()))
	    					) {
	    				searchObsList.add(user.albums.get(i).photos.get(j));
	    				searchAlbumStorage.add(user.albums.get(i).getAlbumName());
	    				
	    				searchListView.setItems(searchObsList);
	    				
	    				
	    				showPhotoThumbnail();
	    				
	    				
	    				
	    				
	    				
	    			}
	    			
//	    			System.out.println("j: " + j);
	    		}
	    	}
	    	
	    	if(!searchObsList.isEmpty()) {
	    		searchCreateNewAlbumButton.setDisable(false);
	    	}

	    } 
	    
	   /**
	    * search by date checkbox. when clicked the date search interface pops up 
	    * @param event check the box to have date search interface show
	    */
	    @FXML
	    void searchByDateCheckBox(ActionEvent event) {
	    	searchByNameCheckBox.setDisable(true);
	    	searchByDateCheckBox.setDisable(true);
	    	searchByTagCheckBox.setDisable(true);
	    	
	    	
	    	fromDateLabel.setVisible(true); 	    
	 	   	fromDateSearchField.setVisible(true);	 	    
	 	   	toDateLabel.setVisible(true);	 	    
	 	    toDateSearchField.setVisible(true);	 	
	 	    searchDateSearchButton.setVisible(true);	 	    
	 	    cancelDateSearchButton.setVisible(true);
	 	    

	 	    fromDateSearchField.getEditor().setDisable(true);
	 	    toDateSearchField.getEditor().setDisable(true);

	    }
	    
	    /**
	     *search by tag checkbox. when clicked the date search interface pops up 
	     * @param event check the box to have tag search interface show
	     */
	    @FXML
	    void searchByTagCheckBox(ActionEvent event) {
	    	searchByNameCheckBox.setDisable(true);
	    	searchByDateCheckBox.setDisable(true);
	    	searchByTagCheckBox.setDisable(true);
	    	
	    	tagTwoName.setVisible(true);
			tagTwoValue.setVisible(true);
			tagTwoLabel.setVisible(true);
			
	    	tagTwoName.setDisable(true);
			tagTwoValue.setDisable(true);
			tagTwoLabel.setDisable(true);
	    	
	    	addConjuctionTag.setVisible(true);
		    orDisjunctionTag.setVisible(true);
	    	addConjuctionTag.setDisable(false);
		    orDisjunctionTag.setDisable(false);
		    tagOneName.setVisible(true);
		    tagOneValue.setVisible(true);
		    tagOneLabel.setVisible(true);
		    searchTagButton.setVisible(true);
		    cancelTagButton.setVisible(true);
		    
		    tagOneName.getSelectionModel().clearSelection();
		    tagOneValue.getSelectionModel().clearSelection();
	    	tagTwoName.getSelectionModel().clearSelection();
			tagTwoValue.getSelectionModel().clearSelection();
		   
		   ObservableList<String> obsTotal_tags = FXCollections.observableArrayList();
		   obsTotal_tags.addAll(getAllTags());
		   tagOneName.setItems(obsTotal_tags);
		   tagTwoName.setItems(obsTotal_tags);
	    }
	      
	    /**
	     * search button. when pressed, all the albums are searched for the date that is requested
	     * @param event when pressed, all the albums are searched for the date that is requested
	     */
	    @FXML
	    void searchDateSearchButton(ActionEvent event) {
	    	
	    	searchDateErrorMessage.setVisible(false);
	    	
	    	if(fromDateSearchField.getValue() != null && toDateSearchField.getValue() != null) {
		    	searchObsList.clear();
		    	searchAlbumStorage.clear();
		    	searchListView.setItems(null);
		    	
		    	LocalDate from = fromDateSearchField.getValue();
		    	LocalDate to = toDateSearchField.getValue();
		    	
		    	//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    	
		    	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		    	
		    	DateTimeFormatter sdf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		    	

		    	for(int i = 0; i < user.albums.size(); i++ ) {
//		    		System.out.println("Album: " + user.albums.get(i).getAlbumName());
		    		for(int j = 0; j < user.albums.get(i).photos.size(); j++) {
		    			
//		    			System.out.println("Date: " + user.albums.get(i).photos.get(j).getDate().substring(0,10));
		    			
		    			if((user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(from)) > 0 
		    					&& user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(to)) < 0) 
		    					||
		    					(user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(from)) == 0 
		    	    					&& user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(to)) == 0) 
		    					||
		    					(user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(from)) > 0 
		    	    					&& user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(to)) == 0) 
		    					||
		    					(user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(from)) == 0 
		    	    					&& user.albums.get(i).photos.get(j).getDate().substring(0,10).compareTo(sdf.format(to)) < 0) 	
		    					
		    					) {
		    				searchObsList.add(user.albums.get(i).photos.get(j));
		    				
		    				
		    				searchAlbumStorage.add(user.albums.get(i).getAlbumName());
		    				searchListView.setItems(searchObsList);
		
		    				showPhotoThumbnail();
		    				
	
		    				
		    				
		    			}
		    			
//		    			System.out.println("j: " + j);
		    		}
		    		
		    		
		    	}
		    	
		    	if(!searchObsList.isEmpty()) {
		    		searchCreateNewAlbumButton.setDisable(false);
		    	}
		    	
		    	
		    	
			} else {
				searchDateErrorMessage.setVisible(true);
			}
	    	

	    	

	    }
	    
	    /**
	     * cancel button to cancel search date interface and clear all fields
	     * @param event cancel button to cancel search date interface and clear all fields
	     */
	    @FXML
	    void cancelDateSearchButton(ActionEvent event) {
	    	
	    	//set all fields to false when cancelled
	    	searchByNameCheckBox.setDisable(false);
	    	searchByDateCheckBox.setDisable(false);
	    	searchByTagCheckBox.setDisable(false);
	    	
	    	searchByNameCheckBox.setSelected(false);
	    	searchByDateCheckBox.setSelected(false);
	    	searchByTagCheckBox.setSelected(false);
	    	
	    	//hides datePicker and clears data in it
	    	fromDateSearchField.setValue(null);
	    	toDateSearchField.setValue(null);
	    	fromDateLabel.setVisible(false); 	    
	 	   	fromDateSearchField.setVisible(false);	 	    
	 	   	toDateLabel.setVisible(false);	 	    
	 	    toDateSearchField.setVisible(false);	 	
	 	    searchDateSearchButton.setVisible(false);	 	    
	 	    cancelDateSearchButton.setVisible(false);
	 	    searchDateErrorMessage.setVisible(false);
	 	    
	 	 //hides CreateNewAlbumButton TextField and Button
	        searchCreateNewAlbumButton.setDisable(true);
	        searchNewAlbumTextField.setText("");
	    	searchNewAlbumLabel.setVisible(false);
	    	searchNewAlbumTextField.setVisible(false);
	    	searchCancelNewAlbumButton.setVisible(false);
	    	searchSaveNewAlbumButton.setVisible(false);
	    	
	    	//blanks all the textfield text boxes
		    searchNameTextField.setText("");
	    	searchCaptionTextField.setText("");
	    	searchDateTextField.setText("");
	    	searchAlbumTextField.setText("");
	    	
	    	searchObsList.clear();
	        searchListView.setItems(null);
	        searchTagsListView.getItems().clear();

	    }
	    
	    
	    /**
	     * button to display create album interface 
	     * @param event button to display create album interface
	     */
	    @FXML
	    void searchCreateNewAlbumButton(ActionEvent event) {
	    	
	    	searchNewAlbumLabel.setVisible(true);
	    	searchNewAlbumTextField.setVisible(true);
	    	searchCancelNewAlbumButton.setVisible(true);
	    	searchSaveNewAlbumButton.setVisible(true);

	    }
	    
	    /**
	     * cancel create album interface and nulls the textfield 
	     * @param event
	     */
	    @FXML
	    void searchCancelNewAlbumButton(ActionEvent event) {
	    	
	    	searchNewAlbumTextField.setText("");
	    	searchNewAlbumLabel.setVisible(false);
	    	searchNewAlbumTextField.setVisible(false);
	    	searchCancelNewAlbumButton.setVisible(false);
	    	searchSaveNewAlbumButton.setVisible(false);
	    }
	   
	    
	    /**
	     * save button when pressed it saves the album with the name user inputed into the album listview
	     * @param event save button to save create a new album
	     * @throws ClassNotFoundException if class is not found
	     * @throws IOException if stream to file cannot be written to or closed.
	     */
	    @FXML
	    void searchSaveNewAlbumButton(ActionEvent event) throws ClassNotFoundException, IOException {
	    	boolean isInList = false;
	    	
//	    	System.out.println("Creating New Album: " + searchNewAlbumTextField.getText());
	    	
	    	
	    	
	    	if(!(searchNewAlbumTextField.getText().trim().equals("")) && !isDuplicate(searchNewAlbumTextField.getText())){
	    		
	    		
    	        
    	        //PhotoAlbum photoAlbum = new PhotoAlbum(searchNewAlbumTextField.getText());
    	        
    	        photoAlbum = new PhotoAlbum(searchNewAlbumTextField.getText());
    	        
    	    	user.addPhotoAlbum(photoAlbum);
    	    	
    	    	
    	    	
    	    	obsList.add(photoAlbum);
    	    	
    	    	listview.setItems(obsList);
    	    	
    	    	
    	    	
    	    	
    	    	enterNewAlbum.setText("");
    	    	
    	    	String earliest = null;
   		    	String latest = null;
    	    	
//    	    	System.out.println("Album: " + user.albums.get(user.albums.size()-1));
    	    	for(int i = 0; i < searchObsList.size(); i++) {
    	    		

    	    		
//    	    		user.albums.get(user.albums.size()-1).addPhoto(searchObsList.get(i));
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   	    		
    	    		for(int j = 0; j < user.albums.get(user.albums.size()-1).photos.size(); j++) {
    	    			if(user.albums.get(user.albums.size()-1).photos.get(j).getPhotoName().equals(searchObsList.get(i).getPhotoName())) {
//    	    				System.out.println("Found Match: " + searchObsList.get(i).getPhotoName());

    	    				isInList = true;
    	    				break;
    	    			}
    	    		}
    	    		
    	    		if(!isInList) {
    	    			user.albums.get(user.albums.size()-1).addPhoto(searchObsList.get(i));
    	  	    		//user.albums.get(user.albums.size()-1).setAlbumSize(searchObsList.size());
    	  	    		user.albums.get(user.albums.size()-1).setAlbumSize(user.albums.get(user.albums.size()-1).photos.size());
        	    		
        	    		
        	    		
           		    	
           		    	//For loop goes through each picture and check if the date
           		    	//is greater or less than and stores it in earliest or latest String
           		    		if(i == 0) {
           		    			earliest = user.albums.get(user.albums.size()-1).photos.get(i).getDate();
           		    			latest = user.albums.get(user.albums.size()-1).photos.get(i).getDate();
           		    			
           		    		}else if(earliest.compareTo(user.albums.get(user.albums.size()-1).photos.get(i).getDate()) > 0) {
           		    			
           		    			earliest = user.albums.get(user.albums.size()-1).photos.get(i).getDate();
           		    			
           		    		}else if(latest.compareTo(user.albums.get(user.albums.size()-1).photos.get(i).getDate()) < 0) {
           		    			latest = user.albums.get(user.albums.size()-1).photos.get(i).getDate();
           		    			
           		    		}

    	    			
    	    		}

		
    	    	}
    	    	
    	    	
    	    	
//    	    	System.out.println("Photo: " + user.albums.get(user.albums.size()-1).photos);
    	    	
    	    	//duplicateAlbum.setVisible(false);
    	    	
    	    	user.albums.get(user.albums.size()-1).setEarliestDate(earliest.substring(0, 10));
    	    	user.albums.get(user.albums.size()-1).setLatestDate(latest.substring(0, 10));
    	    	
    	    	//pull data from dat file
    	    	//ArrayList<User> arrayList = model.readFromFile(); 

    	    	
    	    	//update the array list by with new folder
    	    	 model.findAndUpdateModel(user, user.getName());
    	    	
    	}
	    	
	    	
	    	
	    	
	    	
	    	hiddenScreen.setVisible(false);
	    	normalScreen.setVisible(true);
	    	
	    	
	    	searchButton.setDisable(false);
	    	cancelSearchScreen.setVisible(false);
	    	
	    	//set all fields to false when cancelled
	    	searchByNameCheckBox.setDisable(false);
	    	searchByDateCheckBox.setDisable(false);
	    	searchByTagCheckBox.setDisable(false);
	    	
	    	searchByNameCheckBox.setSelected(false);
	    	searchByDateCheckBox.setSelected(false);
	    	searchByTagCheckBox.setSelected(false);
	    	
	    	
	    	//hides SearchByName TextField and Buttons
	    	searchTextField.setText("");
	    	searchTextField.setVisible(false);
	        cancelSearchTextFieldButton.setVisible(false);
	        searchAcceptTextFieldButton.setVisible(false);
	        
	        //hides CreateNewAlbumButton TextField and Button
	        searchCreateNewAlbumButton.setDisable(true);
	        searchNewAlbumTextField.setText("");
	    	searchNewAlbumLabel.setVisible(false);
	    	searchNewAlbumTextField.setVisible(false);
	    	searchCancelNewAlbumButton.setVisible(false);
	    	searchSaveNewAlbumButton.setVisible(false);
	    	
	    	//hides datePicker and clears data in it
	    	fromDateSearchField.setValue(null);
	    	toDateSearchField.setValue(null);
	    	fromDateLabel.setVisible(false); 	    
	 	   	fromDateSearchField.setVisible(false);	 	    
	 	   	toDateLabel.setVisible(false);	 	    
	 	    toDateSearchField.setVisible(false);	 	
	 	    searchDateSearchButton.setVisible(false);	 	    
	 	    cancelDateSearchButton.setVisible(false);
	 	    searchDateErrorMessage.setVisible(false);
	        
	        searchObsList.clear();
	        searchListView.setItems(null);
	    	
	    	

	    }
	    
	    /**
	     * populates a 40 by 40 image and its name into the searchlistview
	     */
	    public void showPhotoThumbnail() {
	    	

			
			searchListView.setCellFactory(param -> new ListCell<Photo>() {	         
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
						//setText(name.getPhotoName() + "\tlocated in Album: " + user.getAlbumName());
						
						//This one is based on assignment criteria
						//But it looks messy
						//setText("Name: " + name.getPhotoName() + "\n" + "Caption: " + name.getCaption());
						setGraphic(imageView1);
			
					}
				}
			});


	    }
	    

	    
	    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    /**
	     * cancel tag search interface and 
	     * @param event cancel tag search interface
	     */
	    @FXML
	    void cancelTagButton(ActionEvent event) {
	    	
	    	//set all fields to false when cancelled
	    	searchByNameCheckBox.setDisable(false);
	    	searchByDateCheckBox.setDisable(false);
	    	searchByTagCheckBox.setDisable(false);
	    	
	    	searchByNameCheckBox.setSelected(false);
	    	searchByDateCheckBox.setSelected(false);
	    	searchByTagCheckBox.setSelected(false);
	    	
	    	 //hides tags
	    	addConjuctionTag.setSelected(false);
		    orDisjunctionTag.setSelected(false);
	    	addConjuctionTag.setVisible(false);
		    orDisjunctionTag.setVisible(false);
	    	addConjuctionTag.setDisable(true);
		    orDisjunctionTag.setDisable(true);
		    
		    tagOneName.setVisible(false);
		    tagOneValue.setVisible(false);
		    tagTwoName.setVisible(false);
		    tagTwoValue.setVisible(false);
		    tagOneLabel.setVisible(false);
		    tagTwoLabel.setVisible(false);
		    searchTagButton.setVisible(false);
		    cancelTagButton.setVisible(false);
		    
		    searchCreateNewAlbumButton.setDisable(true);
		    

		    tagOneName.getSelectionModel().clearSelection();
		    tagOneName.getEditor().setText("Name");
		    tagOneValue.getSelectionModel().clearSelection();
		    tagOneValue.getEditor().setText("Value");
	    	tagTwoName.getSelectionModel().clearSelection();
	    	tagTwoName.getEditor().setText("Name 2");
			tagTwoValue.getSelectionModel().clearSelection();
			tagTwoValue.getEditor().setText("Value 2");
		    
			searchNameTextField.clear();
			searchCaptionTextField.clear();
			searchDateTextField.clear();
			searchAlbumTextField.clear();
			searchTagsListView.getItems().clear();
	        
	        searchObsList.clear();
	        searchListView.setItems(null);
	    }
	    
	    /**
	     * searchListViewClick action for when user clicks on the view it populates the details view 
	     * with the all the data from the photo i.e. Name, Caption, Date, Album and Tags
	     * @param event
	     */
	    @FXML
	    void searchListViewClick(MouseEvent event) {
	    	
	    	if(!searchObsList.isEmpty()) {
	    		Photo photo = searchListView.getSelectionModel().getSelectedItem();
		    	int selectedIndex = searchListView.getSelectionModel().getSelectedIndex();
		    	
		    	
		    	
		    	searchNameTextField.setText(photo.getPhotoName());
		    	searchCaptionTextField.setText(photo.getCaption());
		    	searchDateTextField.setText(photo.getDate());
		    	
		    	searchAlbumTextField.setText(searchAlbumStorage.get(selectedIndex)); // ##
		    	
		    	obsTags.clear();
		    	obsTags.addAll(photo.getFormatTags());
		    	//setItems(searchObsList.get(selectedIndex).getTagNames());
		    	searchTagsListView.setItems(obsTags);
		    	
//		    	
//		    	System.out.println("Photo: " + photo);
//		    	
//		    	System.out.println("Index: " + selectedIndex);
	    	}
	    	
	    	
	    }
	
}
