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
	@Test
	void testloadPatrimonies() throws IOException {
		setupScenary1();
		company.loadPatrimonies();
		assertTrue("The method it's wrong", company.getPatrimonies().get(0).getName().contentEquals("Capital suscrito y pagado") == true);
		assertTrue("The method it's wrong", company.getPatrimonies().get(company.getPatrimonies().size()-1).getName().contentEquals("De otros activos") == true);
	}
	@Test
	void sortAssetsByCode() throws IOException {
		setupScenary1();
		company.loadAssets();
		company.sortAssetsByCode();
		assertTrue("The method it's wrong", company.getAssets().get(0).getName().contentEquals("Caja") == true);
		assertTrue("The method it's wrong", company.getAssets().get(company.getAssets().size()-1).getName().contentEquals("De otros activos") == true);
	}
	@Test
	void testsorLiabilitiesByCode() throws IOException {
		setupScenary1();
		company.loadLiabilities();
		company.sortLiabilitiesByCode();
		assertTrue("The method it's wrong", company.getLiabilities().get(0).getName().contentEquals("Bancos nacionales") == true);
		assertTrue("The method it's wrong", company.getLiabilities().get(company.getLiabilities().size()-1).getName().contentEquals("Títulos pensionales") == true);
	}
	@Test
	void testsortPatrimoniesByCode() throws IOException {
		setupScenary1();
		company.loadPatrimonies();
		company.sortPatrimoniesByCode();
		assertTrue("The method it's wrong", company.getPatrimonies().get(0).getName().contentEquals("Capital suscrito y pagado") == true);
		assertTrue("The method it's wrong", company.getPatrimonies().get(company.getPatrimonies().size()-1).getName().contentEquals("De otros activos") == true);
	}
	@Test
	void sortAssetsByName() throws IOException {
		setupScenary1();
		company.loadAssets();
		company.sortAssetsByName();
		assertTrue("The method it's wrong", company.getAssets().get(0).getName().contentEquals("Acciones") == true);
	}
	@Test
	void testsorLiabilitiesByName() throws IOException {
		setupScenary1();
		company.loadLiabilities();
		company.sortLiabilitiesByName();
		assertTrue("The method it's wrong", company.getLiabilities().get(0).getName().contentEquals("A casa matriz") == true);
	}
	@Test
	void testsortPatrimoniesByName() throws IOException {
		setupScenary1();
		company.loadPatrimonies();
		company.sortPatrimoniesByName();
		assertTrue("The method it's wrong", company.getPatrimonies().get(0).getName().contentEquals("Ajustes por inflación") == true);
	}
	@Test
	void testsearchAssetsByCode() throws IOException {
		setupScenary1();
		company.loadAssets();
		Assets found = company.searchAssetsByCode(1105);
		assertTrue("The method it's wrong", found.getName().contentEquals("Caja") == true);
	}
	@Test
	void testsearchLiabilitiesByCode() throws IOException {
		setupScenary1();
		company.loadLiabilities();
		Liabilities found = company.searchLiabilitiesByCode(2105);
		assertTrue("The method it's wrong", found.getName().contentEquals("Bancos nacionales") == true);
	}
	@Test
	void testsearchPatrimoniesByCode() throws IOException {
		setupScenary1();
		company.loadPatrimonies();
		Patrimonies found = company.searchPatrimoniesByCode(3105);
		assertTrue("The method it's wrong", found.getName().contentEquals("Capital suscrito y pagado") == true);
	}
	@Test
	void testtotalAssetsBalance() throws IOException {
		setupScenary1();
		company.loadAssets();
		assertTrue("The method it's wrong", company.totalAssetsBalance() == 0);
	}
	@Test
	void testtotalLiabilitiesBalance() throws IOException {
		setupScenary1();
		company.loadLiabilities();
		assertTrue("The method it's wrong", company.totalLiabilitiesBalance() == 0);
	}
	@Test
	void testtotalPAtrimoniesBalance() throws IOException {
		setupScenary1();
		company.loadPatrimonies();
		assertTrue("The method it's wrong", company.totalPatrimoniesBalance() == 0);
	}
	@Test
	void testassetsBalance() throws IOException {
		setupScenary1();
		company.loadAssets();
		company.assetsBalance();
		assertTrue("The method it's wrong", company.getAssets().get(0).calculateDebit() == 0);
	}
	@Test
	void testliabilitiesBalance() throws IOException {
		setupScenary1();
		company.loadLiabilities();
		company.liabilitiesBalance();
		assertTrue("The method it's wrong", company.getLiabilities().get(0).calculateDebit() == 0);
	}
	@Test
	void testpatrimoniesBalance() throws IOException {
		setupScenary1();
		company.loadPatrimonies();
		company.patrimoniesBalance();
		assertTrue("The method it's wrong", company.getPatrimonies().get(0).getCredit() == 0);
	}
}
