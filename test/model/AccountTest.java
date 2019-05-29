package model;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class AccountTest {
	private Account account;
	private void setupScenary1() {
		account = new Assets("Pat",3120);
	}
	@Test
	void testCompareTo() {
		setupScenary1();
		Account a = new Assets("Pat2",2134);
		assertTrue("The method to compare accounts is wrong",account.compareTo(a) == 1);
	}

}
