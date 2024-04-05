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



public class Model implements Serializable{
	
	/**
	 * All the fields in the Model
	 */
	private static ArrayList<User> arrayList = new ArrayList<User>();
	User currentUser;

	//private static ArrayList<User> arrayList;
	
	private static final long serialVersionUID = 1L;
	public static final String storeDir = "data";
	public static final String storeFile = "UserList.dat";
	
	
	/**
	 * Model no args constructor
	 */
	public Model() {
		//arrayList = new ArrayList<User>();
	}
	
	/**
	 * Set current user
	 * @param currentUser grabs passed argument and sets current user
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	/**
	 * gets currentUser
	 * @return currentUser gets currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}
	
	/**
	 * add user to global arraylist 
	 * @param user user is passed and added to global arrayList
	 */
	public void addUser(User user) {
		arrayList.add(user);
	}
	
	
	/**
	 * prints model data for testing
	 */
	public void printModel() {
		int i = 0;
		for(User user: arrayList) {
			//System.out.println("This is model: " + user);
			System.out.println("This is model: " + user + " " + user.getAlbums());
			
			
		
	    	
	    	i++;
		}
		
	}
	
	/**
	 * prints model data for testing
	 * @param location passed to print for testing 
	 */
	public void printModelLocation(String location) {
		int i = 0;
		for(User user: arrayList) {
			if(i == arrayList.size()) {
				break;
			}
			
			System.out.println("------------------------------------------------------------------------");
			System.out.println("This is printing at location: " + location);
			System.out.println("The index: " + i);
			
			System.out.println("This is User: " + user + "->" +"\t(Folders) ->" + user.getAlbums());
			

			
			
			
			if(!user.getAlbums().isEmpty()) {
				
				for(int j = 0; j < user.getAlbums().size(); j++) {
					System.out.println("\nAlbum Name is: " + user.getAlbums().get(j) );
					System.out.println("Photos: "+user.getAlbums().get(j).getPhoto()+ "\n");
				}
				//System.out.println("Photos: "+user.getAlbums().get(i).getPhoto()+ "\n\n");
			}else {
				System.out.println("\nAlbum Name is: [empty folder]" );
				System.out.println("Photos: [null]\n");
				
			}
			
			System.out.println("------------------------------------------------------------------------");
	    	
	    	i++;
		}
		
	}
	
	/**
	 * print for testing 
	 * @param sentence user sentence passed for testing purposes
	 */
	public void printList(String sentence) {
		for(int i = 0; i < arrayList.size(); i++) { 
			
			System.out.println(sentence + arrayList.get(i) + " " + arrayList.get(i).albums);
		}
	}
	
	
	/**
	 * remove user from the model by grabbing the name and matching it with the saved data
	 * @param name name passed for for matching and deleting user in model
	 */
	public void removeModel(String name) {

		Iterator<User> find = arrayList.iterator();

		while (find.hasNext()) {
		    User str = find.next();

		    if (str.name.equals(name))
		        find.remove();
		}
		
	}
	
	/**
	 * used to remove album from model by comparing user, name and albumName
	 * @param user individual user
	 * @param name  name passed for finding user in model
	 * @param albumName albumName passed for finding album in user in model
	 * @throws IOException if stream to file cannot be written to or closed.
	 */
	public void removeAlbum(User user,String name,  String albumName) throws IOException {

		Iterator<User> find = arrayList.iterator();
		
		while (find.hasNext()) {
		    User str = find.next();

		    if (str.name.equals(name)) {
//		    	System.out.println("Found Name: " + str.getName());
		    	//str.albums.get(i).getAlbumName();
		    	for(int i = 0; i < str.albums.size(); i++ ) {
		    		if(str.albums.get(i).getAlbumName().equals(albumName)) {
//		    			System.out.println("Found album: " + albumName);
		    			str.albums.remove(i);
		    		
		    		}
		    	}

		    }
		    	
		        
		}
		
		
//		FileOutputStream fileOut = new FileOutputStream(storeFile);
		FileOutputStream fileOut = new FileOutputStream(storeDir + File.separator + storeFile);
    	ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	
    	out.writeObject(arrayList);
    	out.close();
    	fileOut.close();
		
		
		
	}
	
	
	/**
	 * Used to rename album in model
	 * @param user user of the album
	 * @param name name of the user
	 * @param albumName album name to be compared to and changed
	 * @param newAlbumName the new album name to be changed in the model
	 * @throws IOException if stream to file cannot be written to or closed.
	 */
	public void renameAlbum(User user,String name,  String albumName,String newAlbumName) throws IOException {

		Iterator<User> find = arrayList.iterator();
		PhotoAlbum temp;
		
		while (find.hasNext()) {
		    User str = find.next();

		    if (str.name.equals(name)) {
//		    	System.out.println("Found Name: " + str.getName() );
		    	//str.albums.get(i).getAlbumName();
		    	for(int i = 0; i < str.albums.size()-1; i++ ) {
		    		if(str.albums.get(i).getAlbumName().equals(albumName)) {
//		    			System.out.println("Found album: " + albumName);

		    			
		    			str.setName(newAlbumName);
//		    			
//		    			System.out.println("THe array list: " + arrayList.get(i) );

		    		}
		    	}

		    }
		    	
		        
		}
		
		
//		FileOutputStream fileOut = new FileOutputStream(storeFile);
		FileOutputStream fileOut = new FileOutputStream(storeDir + File.separator + storeFile);
    	ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	
    	out.writeObject(arrayList);
    	out.close();
    	fileOut.close();
		
		
		
	}
	
	/**
	 * checks to see if file exists in directory. This is for testing purposes
	 * @return true/false  true if it exists and false otherwise
	 */
	public boolean fileExist() {
		File file = new File(storeFile);
		if(file.exists()) {
			return true;
		}
		
		return false;
	}
	

	/**
	 * Finds and updates the user name in the model
	 * @param user user to be found
	 * @param name name of album to be changed
	 * @throws IOException if stream to file cannot be written to or closed.
	 * @throws ClassNotFoundException if class is not found
	 */
	public void findAndUpdateModel(User user, String name ) throws IOException, ClassNotFoundException {
		
	
		
		Iterator<User> find = arrayList.iterator();
		ArrayList<User> temp = new ArrayList<User>();

//		System.out.println("This is arrayList.name " + arrayList.get(0).name);
		
		while (find.hasNext()) {
			
		    User str = find.next();
	
		    if (str.name.equals(name)) {

//		    	System.out.println("Found the name: " + str.name);
//		    	System.out.println("Found the photoAlbums: " + str.getAlbums());
		    	
		        find.remove();
		        
		        temp.add(user);
		    	continue;
		    }
		    temp.add(str);
		    
		}
		arrayList = null;
		arrayList = temp;
		

		//REMOVE FOR FINAL VERSION
		//printList("This is arrayList ");
	
//		FileOutputStream fileOut = new FileOutputStream(storeFile);
		FileOutputStream fileOut = new FileOutputStream(storeDir + File.separator + storeFile);
    	ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	
    	out.writeObject(arrayList);
    	out.close();
    	fileOut.close();
    	
 	
	}

	
	/**
	 * writes data to serializable. Saves data
	 * @throws IOException if stream to file cannot be written to or closed.
	 */
	public static void writeToFile() throws IOException {
//		FileOutputStream fileOut = new FileOutputStream(storeFile);
		FileOutputStream fileOut = new FileOutputStream(storeDir + File.separator + storeFile);
    	ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	

    	out.writeObject(arrayList);
    	out.close();
    	fileOut.close();

	}
	

	/**
	 * Reads the data from the directory 
	 * @return arrayList arrayList is returned with all the users and their data
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<User> readFromFile() throws IOException, ClassNotFoundException {
//		FileInputStream fileIn = new FileInputStream(storeFile);
		FileInputStream fileIn = new FileInputStream(storeDir + File.separator + storeFile);
    	ObjectInputStream in = new ObjectInputStream(fileIn);
    	arrayList = (ArrayList<User>) in.readObject();
    	
    	in.close();
    	fileIn.close();
    	//return user;
    	return arrayList;
    	
	}
	
	
	
}
