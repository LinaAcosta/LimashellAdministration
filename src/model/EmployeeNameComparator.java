package model;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{
	@Override
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
