package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class EmployeeNameComparatorTest {

    private void setupScenary1( ) {
		
	}
	@Test
	void testEmployeeNameComparator() {
		setupScenary1();
		EmployeeNameComparator e = new EmployeeNameComparator();
		assertNotNull("The new object is null", e);
	}
	@Test
	void testCompare() {
		setupScenary1();
		EmployeeNameComparator e = new EmployeeNameComparator();
		Employee em1 = new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
		Employee em2 = new Employee("Maria","Ordoñez",1006216578,1500000,"PLANT",3,28);
		int value = e.compare(em1, em2);
		assertTrue("The method returns have the wrong value", (value == -1));
		int value2 = e.compare(em2, em1);
		assertTrue("The method returns have the wrong value", (value2 == 1));
		int value3 = e.compare(em2, em2);
		assertTrue("The method returns have the wrong value", (value3 == 0));
	}

}
