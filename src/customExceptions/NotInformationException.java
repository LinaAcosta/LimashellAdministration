package customExceptions;

public class NotInformationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	public NotInformationException(String i, String p) {
		super("Empty information, try again");
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
