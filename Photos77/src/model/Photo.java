package model;



import java.io.File;
import java.util.ArrayList;

import javafx.util.Pair;


public class Photo extends PhotoAlbum{
	
	/**
	 * All the fields in the Photo
	 */
	private String photoName;
    private String date;
    File filePath;
    String caption;

    ArrayList<Pair<String, String>> TAGS = new ArrayList<Pair<String, String>>();

    /**
     * args constructor that sets the photoName
     * @param photoName sets name of photo
     */
    public Photo(String photoName) {
    	this.photoName = photoName;
    }
    
    /**
     * args constructor that set the photoName, date and filePath
     * @param photoName name of photo
     * @param date date of photo
     * @param filePath filePath of photo to be viewed in imageView
     */
    public Photo(String photoName,String date, File filePath){

        this.photoName = photoName;
        this.date = date;
        this.filePath = filePath;
        
    }
    
    
    /**
     * args constructor that set the photoName, date and filePath, tags_list 
     * @param photoName sets photoName of photo
     * @param date sets date of photo
     * @param filePath sets filePath of photo
     * @param tags_list sets the tags of the photo
     */
    public Photo(String photoName,String date, File filePath, ArrayList<Pair<String, String>> tags_list){

        this.photoName = photoName;
        this.date = date;
        this.filePath = filePath;
        this.TAGS = tags_list;
        
    }
    
    /**
     * args constructor that set the photoName, date, caption, filePath and tags_list 
     * @param photoName sets photoName of photo
     * @param date sets date of photo
     * @param caption sets the caption of the photo
     * @param filePath sets filePath of photo
     * @param tags_list sets the tags of the photo
     */
    public Photo(String photoName,String date, String caption, File filePath, ArrayList<Pair<String, String>> tags_list){

        this.photoName = photoName;
        this.date = date;
        this.filePath = filePath;
        this.caption = caption;
        this.TAGS = tags_list;
    }
    

    
    /**
     * args constructor that set the photoName, date, caption and filePath
     * @param photoName name of photo
     * @param date date of photo
     * @param caption sets the caption of the photo 
     * @param filePath filePath of photo to be viewed in imageView
     */
    public Photo(String photoName,String date, String caption, File filePath){

        this.photoName = photoName;
        this.date = date;
        this.filePath = filePath;
        this.caption = caption;
        
    }
    
    /**
     * checks to see if the tag exists true/false
     * @param x checks to see if the tags are in the photo
     * @return true/false if tags exist
     */
    public boolean tagExists(Pair<String, String> x) {
    	return TAGS.contains(x);
    }
    
    /**
     * adds tag to photo global tag array list
     * @param tag name of tag
     * @param value the value of the tag
     * @return true/false true if successfully added. false if not
     */
    public boolean addTag(String tag, String value) {
    	Pair<String, String> insert_tag = new Pair<>(tag, value);
    	boolean tagCheck = tagExists(insert_tag);
    	if(!tagCheck) TAGS.add(insert_tag);
    	return !tagCheck;
    }
    
    /**
     * remove tag to photo global tag array list
     * @param x pair
     * @return tagCheck true if removed. false if not
     */
    public boolean removeTag(Pair<String, String> x) {
    	boolean tagCheck = tagExists(x);
    	if(tagCheck) TAGS.remove(x);
    	return tagCheck;
    }
    
    /**
     * compare tags to formated tag string. deletes tag if tag exists
     * @param x string that shows list view
     * @return true/false true if tag removed. false if not
     */
    public boolean removeFormatTag(String x) {
    	for(Pair<String, String> pair: TAGS) {
    		String key = pair.getKey();
    		String value = pair.getValue();
    		String y = key + ": " + value;
    		if(x.compareTo(y) == 0) {
    			return removeTag(pair);
    		}
    	}
    	return false;
    }
    
    /**
     * gets formatted tags from global tag arraylist
     * @return formatted arraylist of formatted tag strings
     */
    public ArrayList<String> getFormatTags() {
    	ArrayList<String> formatted = new ArrayList<String>();
    	for(Pair<String, String> pair: TAGS) formatted.add(pair.getKey() + ": " + pair.getValue());
    	return formatted;
    }
    
    /**
     * get arraylist of tag names
     * @return names arraylist of strings 
     */
    public ArrayList<String> getTagNames() {
    	ArrayList<String> names = new ArrayList<String>();
    	for(Pair<String, String> pair: TAGS) names.add(pair.getKey());
    	return names;
    }
    
    /**
     * get arraylist of tag values
     * @return values arraylist of strings 
     */
    public ArrayList<String> getTagValues() {
    	ArrayList<String> values = new ArrayList<String>();
    	for(Pair<String, String> pair: TAGS) values.add(pair.getValue());
    	return values;
    }
    
    /**
     * returns global array of tag lists
     * @return TAGS array list of tags
     */
    public ArrayList<Pair<String, String>> getTAGS() {
    	return TAGS;
    }

    /**
     * gets photo name
     * @return photoName returns the photo name
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     * sets the photoName
     * @param photoName sets the photoName of the Photo object
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    /**
     * gets the date of the photo
     * @return date get the date of the photo
     */
    public String getDate() {
        return date;
    }

    /**
     * sets the date of the photo
     * @param date sets the date of the photo
     */
    public void setDate(String date) {
        this.date = date;
    } 
    
    /**
     * sets the caption of the photo
     * @param caption sets the caption of the photo
     */
    public void setCaption(String caption) {
    	this.caption = caption;
    }
    
    /**
     * gets the caption of the photo
     * @return caption gets the caption of the photo
     */
    public String getCaption() {
    	return caption;
    }
    
    /**
     * gets the filePath of the image of the photo object
     * @return filePath returns the filePath of the image of the photo object
     */
    public File getFilePath() {
    	return filePath;
    }
    
    /**
     * return the photoName to be used in obsList and listView
     * @return photoName returns the photo name to be displayed in obsList and listView
     */
    public String toString() {
    	return photoName;
    }

}
