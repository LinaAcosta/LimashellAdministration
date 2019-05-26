package customExceptions;
/**
 *This class manages the necessary attributes and methods to creates exception objects of type IncorrectInformationException
 *@author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public class IncorrectInformationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	/**
	 * <b>IncorrectInformationException constructor</b><br>
	 * @param a the id that the user enter wrong asked information
	 * @param a the password that the user enter wrong asked information
	 */
	public IncorrectInformationException(String i, String p) {
		super("Incorrect information, try again");
		id = i;
		password = p;
	}
	/**
	 * This method returns the id with the wrong value
	 * @return A string with the id that contains the wrong value
	 */
	public String getID() {
		return id;
	}
	/**
	 * This method returns the password with the wrong value
	 * @return A string with the password that contains the wrong value
	 */
	public String getPassword() {
		return password;
	}

}
