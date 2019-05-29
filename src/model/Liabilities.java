package model;
/**
 * This class manage the necessary attributes and methods to manage the Liabilities Accounts
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public class Liabilities extends Account{
	//Constructor method
	/**
	 * <b>Liabilities Constructor</b><br>
	 * @param name the name of the liabilities
     * @param code the code of the liabilities
	 */
	public Liabilities(String name, int code) {
		super(name, code);
	}
	/**
	 * this method allows to compare two liabilities by code
	 * <b>Pre:</b> the liabilitie exists<br>
	 * @param liabilities a Liabilitie which will compare the current
	 * @return comparation a int that represents the value of the comparation
	 */
	public int compareTo(Liabilities liabilities) {
		int comparation;
		int code1 = this.getCode();
		int code2 = liabilities.getCode();
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