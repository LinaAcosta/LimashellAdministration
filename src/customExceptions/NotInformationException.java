package customExceptions;
/**
 *This class manages the necessary attributes and methods to creates exception objects of type NotInformationException
 *@author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public class NotInformationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	/**
	 * <b>NotInformationException constructor</b><br>
	 * @param a the id null
	 * @param a the password null
	 */
	public NotInformationException(String i, String p) {
		super("Empty information, try again");
		id = i;
		password = p;
	}
	/**
	 * This method returns the id with the null value
	 * @return A string with the id that contains the null value
	 */
	public String getID() {
		return id;
	}
	/**
	 * This method returns the password with the null value
	 * @return A string with the password that contains the null value
	 */
	public String getPassword() {
		return password;
	}

}
