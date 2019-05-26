package customExceptions;
/**
 *This class manages the necessary attributes and methods to creates exception objects of type AreaNotFoundException
 *@author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public class AreaNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String area;
	/**
	 * <b>AreaNotFoundException constructor</b><br>
	 * @param a the area that the can not be found
	 */
	public AreaNotFoundException(String a) {
		super("Area not found, try again");
		area = a;
	}
	/**
	 * This method returns the area that can not be found
	 * @return A string with the area that can not be found
	 */
	public String getArea() {
		return area;
	}

}