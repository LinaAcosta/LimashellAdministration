package model;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class BalanceAccountTest {
	private Account a;
	public final static String CREDIT_BALANCE = "Credit Balance";
	private void setupScenary1() {
		a = new Assets("Pat",3122);
	}
	@Test
	void testCalculateBalance() {
		setupScenary1();
		a.setCredit(1200000);
		a.setDebit(1000000);
		assertTrue("The method to calculate the balance type is wrong",(CREDIT_BALANCE.equals("Credit Balance")) == true);
	}
	@Test
	void testCalculateBalanceAccount() {
		setupScenary1();
		a.setCredit(1200000);
		a.setDebit(1000000);
		assertTrue("The method to calculate the balance value is wrong",(a.getCredit() - a.getDebit()) == 200000);
	}

}
