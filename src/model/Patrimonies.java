package model;
/**
 * This class manage the necessary attributes and methods to manage the Patrimonies Accounts
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public class Patrimonies extends Account {
	//Constructor method
		/**
		 * <b>Patrimonies Constructor</b><br>
		 * @param name the name of the patrimonies
	     * @param code the code of the patrimonies
		 */
	public Patrimonies(String name, int code) {
		super(name, code);
	}
	/**
	 * this method allows to compare two patrimonies by code
	 * <b>Pre:</b> the patrimonie exists<br>
	 * @param patrimonies a Patrimonie which will compare the current
	 * @return comparation a int that represents the value of the comparation
	 */
	public int compareTo(Patrimonies patrimonies) {
		int comparation;
		int code1 = this.getCode();
		int code2 = patrimonies.getCode();
		if(code1 < code2) {
			comparation = -1;
		}else if(code1 > code2) {
			comparation = 1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
	
	
}