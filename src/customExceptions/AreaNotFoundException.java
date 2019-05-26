package customExceptions;

public class AreaNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String area;
	public AreaNotFoundException(String a) {
		super("Area not found, try again");
		area = a;
	}
	public String getArea() {
		return area;
	}

}