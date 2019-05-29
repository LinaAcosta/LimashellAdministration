package model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

class AssetsTest {

	private Assets a;
	private void setupScenary1() {
		a = new Assets("Caja", 1105);
	}
	@Test
	void testCompany() {
		setupScenary1();
		assertNotNull("The new object is null", a);
	}

}
