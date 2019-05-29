package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class AccountNameComparatorTest {
    private void setupScenary1( ) {
		
	}
    @Test
	void testAccountNameComparator() {
		setupScenary1();
		AccountNameComparator e = new AccountNameComparator();
		assertNotNull("The new object is null", e);
	}
    @Test
	void testCompare() {
		setupScenary1();
		AccountNameComparator e = new AccountNameComparator();
		Account em1 = new Assets("Par",2130);
		Account em2 = new Assets("One",3120);
		int value = e.compare(em1, em2);
		assertTrue("The method returns have the wrong value", (value == 1));
		int value2 = e.compare(em2, em1);
		assertTrue("The method returns have the wrong value", (value2 == -1));
		int value3 = e.compare(em2, em2);
		assertTrue("The method returns have the wrong value", (value3 == 0));
	}
}
