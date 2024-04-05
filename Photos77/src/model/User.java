package model;



import java.io.Serializable;
import java.util.ArrayList;


public class User extends PhotoAlbum implements Serializable{
	
	/**
	 * All the fields in the PhotoAlbum
	 */
	public  ArrayList<PhotoAlbum> albums = new ArrayList<PhotoAlbum>();
	String name;
	int albumSize;
	String size;
	
	/**
	 * args constructor that sets the User object to the name specified
	 * @param name sets name of the user 
	 */
	public User(String name) {
		this.name = name;
	}
	
	/**
	 * args constructor that sets the User object to the name and size of the album specified
	 * @param name sets the name of the object
	 * @param albumSize sets  the size of the album
	 */
	public User(String name, int albumSize) {
		this.albumSize = albumSize;
	}

	/**
	 * gets the name of the user
	 * @return name gets the name of the User
	 */
	public String getName() {
		return name;
	}

	/**
	 * toString to print the name of the User in obsList and listView
	 * @return name returns the name of the user
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * add album to albums arraylist
	 * @param album adds album to albums arraylist
	 */
	public void addPhotoAlbum(PhotoAlbum album) {
		
		albums.add(album);

	}
	
	/**
	 * increment folder size of the album
	 */
	public void incrementFolderSize() {
		albumSize = albumSize + 1;
	}
	
	/**
	 * decrement folder size of the album
	 */
	public void decrementalbumSize() {
		albumSize = albumSize -1;
	}
	
	
	/**
	 * sets the size 
	 */
	public void setSizeToString() {
		this.size = Integer.toString(albumSize);
	}
	
	/**
	 * get the size
	 * @return size gets the size
	 */
	public String getSizeToString() {
		return size;
	}
	
	/**
	 * get the albums in arrayList
	 * @return albums the name of the album and all of its content
	 */
	public ArrayList<PhotoAlbum> getAlbums() {
        return albums;

    }

	
}
