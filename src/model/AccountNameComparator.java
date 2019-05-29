package model;
/**
 * This class manage the necessary attributes and methods to manage the balance
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.util.Comparator;

public class AccountNameComparator implements Comparator<Account>{
	
	@Override
	/**
	 * The method overrides the compare method of the interface comparator to compare and sort the name of the accounts<br>
	 * @param account1 the first account to compare 
	 * @param account2 the second account to be compare with the first one
	 * @returns an Integer that represents if the name are the same, smallest or biggest than another one
	 */
	public int compare(Account account1, Account account2) {
		int comparation;
		String name1 = account1.getName();
		String name2 = account2.getName();
		
		if(name1.compareTo(name2)<0) {
			comparation = -1;
		}else if(name1.compareTo(name2)>0) {
			comparation = 1;
		}else {
			comparation = 0;
		}
			
		return comparation;
	}
}