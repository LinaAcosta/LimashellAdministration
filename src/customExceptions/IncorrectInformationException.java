package customExceptions;

public class IncorrectInformationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	public IncorrectInformationException(String i, String p) {
		super("Incorrect information, try again");
		id = i;
		password = p;
	}
	public String getID() {
		return id;
	}
	public String getPassword() {
		return password;
	}

}
