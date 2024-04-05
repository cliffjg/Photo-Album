package model;



import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.cell.PropertyValueFactory;


public class PhotoAlbum implements Serializable{
	
	
	/**
	 * All the fields in the PhotoAlbum
	 */
	public  ArrayList<Photo> photos = new ArrayList<Photo>();
	
	
	String name;
	int albumSize;
	String 	earliestDate;
	String latestDate;
	
	

	/**
	 * no args constructor for PhotoAlbum object
	 */
	public PhotoAlbum() {
		
	}
	
	/**
	 * args constructor that sets the name of the album
	 * @param name set the name of the album
	 */
	public PhotoAlbum(String name) {
		this.name = name;
		
	}
	
	/**
	 * sets the name of the album
	 * @param name sets the name of the album
	 */
	public void setName(String name) {
		this.name = name;
		
	}
	
	/**
	 * gets the name of the album
	 * @return name gets the name of the album
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets the name of the album
	 * @return name gets the name of the album
	 */
	public String getAlbumName() {
		return name;
	}
	
	/**
	 * sets the size of the album
	 * @param albumSize sets the album size to be used later
	 */
	public void setAlbumSize(int albumSize) {
		this.albumSize = albumSize;
	}
	
	/**
	 * gets album size
	 * @return albumSize gets the album size
	 */
	public int getAlbumSize() {
		return albumSize;
	}
	
	/**
	 * set earliestDate
	 * @param earliestDate sets the date of the oldest photo
	 */
	public void setEarliestDate(String earliestDate) {
		this.earliestDate = earliestDate;
	}
	
	/**
	 * sets latestDate
	 * @param latestDate sets the date of the most recent photo
	 */
	public void setLatestDate(String latestDate) {
		this.latestDate = latestDate;
	}
	
	/**
	 * gets earliest Date
	 * @return earliestDate returns the date of the oldest photo
	 */
	public String getEarliestDate() {
		return earliestDate;
	}
	
	/**
	 * gets the latest Date
	 * @return latestDate returns the date of the most recent photo choosen
	 */
	public String getLatestDate() {
		return latestDate;
	}

	/**
	 * prints the name of the photo album in obsList/listView in AlbumController
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * add photo to arraylist 
	 * @param photo photo that is passed by user
	 */
	public void addPhoto(Photo photo) {
		
		photos.add(photo);

	}
	
	/**
	 * gets the photo in the arraylist
	 * @return photos gets the photo and all of its data in array list
	 */
	public ArrayList<Photo> getPhoto() {
        return photos;
    }
	

}
