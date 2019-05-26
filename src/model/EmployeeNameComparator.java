package model;
/**
 * This class manage the necessary attributes and methods to manage the employees
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{
	@Override
	/**
	 * The method overrides the compare method of the interface comparator to compare and sort the name of the employees<br>
	 * @param f1 the first employee to compare 
	 * @param f2 the second employee to be compare with the first one
	 * @returns an Integer that represents if the name are the same, smallest or biggest than another one
	 */
	public int compare(Employee f1, Employee f2) {
		int comparation;
		String name1 = f1.getName();
		String name2 = f2.getName();
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
