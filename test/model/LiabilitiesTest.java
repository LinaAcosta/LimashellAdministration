package model;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

class LiabilitiesTest {

	private Liabilities l;
	private void setupScenary1() {
		l = new Liabilities("Bancos Nacionales",2105);
	}
	@Test
	void testCompany() {
		setupScenary1();
		assertNotNull("The new object is null", l);
	}

}
