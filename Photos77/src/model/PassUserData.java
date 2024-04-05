package model;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;



public class PassUserData {

	/**
	 * All the fields in the PassUserData
	 */
	public static final PassUserData instance = new PassUserData();
	
	public User user;
	
	
	String album;
	int albumIndex;
	int pictureIndex;
	
	
	/**
	 * PassUserData no args constructor
	 */
	public PassUserData() {
		
	}
	
	/**
	 * gets instance of the user
	 * @return instance instance of the user
	 */
	public static PassUserData getInstance() {
		return instance;
	}
	
	/**
	 * get the userdata from the instance
	 * @return user returns user and all other attributes extended to it
	 */
	public User getUserData() {
		return user;
	}
	
	/**
	 * set the userData between views
	 * @param user sets the user data
	 */
	public void setUserData(User user) {
		this.user = user;
	}
	
	/**
	 * get the user album that was passed between scenes
	 * @return album the user album and its attributes is returned
	 */
	public String getUserAlbum() {
		return album;
	}
	
	/**
	 * sets the album index so that it can be retrieved in another scene
	 * @param albumIndex sets album index
	 */
	public void setAlbumIndex(int albumIndex) {
		this.albumIndex = albumIndex;
	}
	
	/**
	 * gets the albumIndex to be used when accessing album information i.e. photos
	 * @return albumIndex the index of the album when in PhotoListViewController.java
	 */
	public int getAlbumIndex() {
		return albumIndex;
	}
	
	/**
	 * sets pictureIndex to be used when going through slides in SlideShowController
	 * @param pictureIndex index of the picture in the album array
	 */
	public void setPictureIndex(int pictureIndex) {
		this.pictureIndex = pictureIndex;
	}
	
	/**
	 * gets pictureIndex to be used when going through slides in SlideShowController
	 * @return pictureIndex index of the picture in the album array
	 */
	public int getPictureIndex() {
		return pictureIndex;
	}
	
	
	/**
	 * sets user data and album for use between scenes
	 * @param user the user and all its data are set
	 * @param album name is set
	 */
	public void setUserDataAndAlbum(User user, String album) {
		this.user = user;
		this.album = album;
	}
	
	
}




