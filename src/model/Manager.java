package model;
/**
 * This class manage the necessary attributes and methods to manage the manager
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public class Manager {
	//Attributes & constants
	private String id;
	private String password;
	/**
	 * <b>Manager constructor</b>
	 * @param i the id of the manager
	 * @param p the password of the manager
	 */
	public Manager(String i, String p) {
		id = i;
		password = p;
	}
	/**
	 * this method allows to return the id of the manager
	 * <b>Pre:</b> the object Manager exists<br>
	 * @return id a String that represents the id of the manager
	 */
	public String getID() {
		return id;
	}
	/**
	 * this method allows to return the password of the manager
	 * <b>Pre:</b> the object Manager exists<br>
	 * @return password a String that represents the password of the manager
	 */
	public String getPassword() {
		return password;
	}

}
