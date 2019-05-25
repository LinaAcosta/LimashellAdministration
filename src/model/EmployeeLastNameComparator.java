package model;

import java.util.Comparator;

public class EmployeeLastNameComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee f1, Employee f2) {
		int comparation;
		String lname1 = f1.getLastName();
		String lname2 = f2.getLastName();
		if(lname1.compareTo(lname2)<0) {
			comparation = -1;
		}else if(lname1.compareTo(lname2)>0) {
			comparation = 1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
}
