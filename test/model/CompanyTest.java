package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class CompanyTest {
	private Company company;
	private void setupScenary1() {
		company = new Company();
	}
	@Test
	void testCompany() {
		setupScenary1();
		assertNotNull("The new object is null", company);
	}
	@Test
	void testloadAssets() throws IOException {
		setupScenary1();
		company.loadAssets();
		assertTrue("The method it's wrong", company.getAssets().get(0).getName().contentEquals("Caja") == true);
		assertTrue("The method it's wrong", company.getAssets().get(company.getAssets().size()-1).getName().contentEquals("De otros activos") == true);
	}
	@Test
	void testloadLibialities() throws IOException {
		setupScenary1();
		company.loadLiabilities();
		assertTrue("The method it's wrong", company.getLiabilities().get(0).getName().contentEquals("Bancos nacionales") == true);
		assertTrue("The method it's wrong", company.getLiabilities().get(company.getLiabilities().size()-1).getName().contentEquals("Títulos pensionales") == true);
	}
}
