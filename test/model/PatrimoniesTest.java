package model;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

class PatrimoniesTest {

	private Patrimonies p;
	private void setupScenary1() {
		p = new Patrimonies("Ajuste",3105);
	}
	@Test
	void testCompany() {
		setupScenary1();
		assertNotNull("The new object is null", p);
	}

}
