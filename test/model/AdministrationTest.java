package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import customExceptions.AreaNotFoundException;
import customExceptions.IncorrectInformationException;
import customExceptions.NotInformationException;

class AdministrationTest {
	private void setupScenary1() {
		
	}
	private Employee em1;
	private Employee em2;
	private Employee em3; 
	private Employee em4;
	private Administration admi;
	private Manager manager;
	private void setupScenary2() throws FileNotFoundException, ClassNotFoundException, IOException {
		admi = new Administration();
		manager = new Manager("1006217501","MarcelaHolguin14");
		admi.setManager(manager);
	}
	private void setupScenary3() throws FileNotFoundException, ClassNotFoundException, IOException {
		admi = new Administration();
		em1 = new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
		admi.setEmployeeMonth(em1);
	}
	private void setupScenary4() throws FileNotFoundException, ClassNotFoundException, IOException {
		admi = new Administration();
		em1 = new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
		em2 = new Employee("Maria","Ordoñez",1006216578,1500000,"PLANT",3,28);
		em3 = new Employee("Mishell","Arboleda",66930656,900000,"FINANCE",1,29);
		em4 = new Employee("Ana","Muñoz",1112345678,1300000,"ADMINISTRATION",4,28);
		admi.setFirst(em1);
		em1.setNext(em2);
		em2.setNext(em3);
		em3.setNext(em4);
	}
	private void setupScenary5() throws FileNotFoundException, ClassNotFoundException, IOException {
		admi = new Administration();
		em1 = new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
		em2 = new Employee("Maria","Ordoñez",1006216578,1500000,"PLANT",3,28);
		em3 = new Employee("Mishell","Arboleda",66930656,900000,"FINANCE",1,29);
		em4 = new Employee("Ana","Muñoz",1112345678,1300000,"ADMINISTRATION",4,28);
		em1.setLeft(em2);
		em2.setLeft(em3);
		em1.setRight(em4);
		admi.setRoot(em1);
		admi.setRoot(em1);
	}
	private void setupScenary6() throws FileNotFoundException, ClassNotFoundException, IOException {
		admi = new Administration();
		em1 = new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
		em2 = new Employee("Maria","Ordoñez",1006216578,1500000,"PLANT",3,28);
		em3 = new Employee("Mishell","Arboleda",66930656,900000,"FINANCE",1,29);
		em4 = new Employee("Ana","Muñoz",1112345678,1300000,"ADMINISTRATION",4,28);
		admi.getEmployees().add(em1);
		admi.getEmployees().add(em2);
		admi.getEmployees().add(em3);
		admi.getEmployees().add(em4);
	}
	private void setupScenary7() throws FileNotFoundException, ClassNotFoundException, IOException {
		admi = new Administration();
		em1 = new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
		em2 = new Employee("Maria","Ordoñez",1006216578,1500000,"PLANT",3,28);
		em3 = new Employee("Mishell","Arboleda",66930656,900000,"FINANCE",1,29);
		em4 = new Employee("Ana","Muñoz",1112345678,1300000,"ADMINISTRATION",4,28);
		admi.setFirst(em1);
		em1.setNext(em2);
		em2.setNext(em3);
		em3.setNext(em4);
		em1.setLeft(em2);
		em2.setLeft(em3);
		em1.setRight(em4);
		admi.setRoot(em1);
		admi.getEmployees().add(em1);
		admi.getEmployees().add(em2);
		admi.getEmployees().add(em3);
		admi.getEmployees().add(em4);
	}
	@Test
	void testAdministration() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary1();
		Administration ad = new Administration();
		assertNotNull("The administration is null", ad);
	}
	@Test
	void testLoadManagerInformation() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary2();
		Administration a = new Administration();
		a.loadManagerInformation("testData/managerTest");
		assertTrue("The manager have the wrong value", (a.getManager().getID().equals(admi.getManager().getID()) == true) && (a.getManager().getPassword().equals(admi.getManager().getPassword()) == true));
	}
	@Test
	void searchEmployeeMonth() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary3();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The employee have the wrong value",a.searchEmployeeMonth(1006217501).getID()  == admi.getEmployeeMonth().getID());
	}
	@Test
	void testLoadEmployees() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary7();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		Employee current = a.getFirst();
		Employee aux = admi.getFirst();
		while(current != null && aux != null) {
			assertTrue("The employee have the wrong value", current.getID() == aux.getID());
			current = current.getNext();
			aux = aux.getNext();
		}
		Employee l = admi.getRoot();
		Employee l1 = a.getRoot();
		while(l != null && l1 != null) {
			assertTrue("The employee have the wrong value", l.getID() == l1.getID());
			l = l.getLeft();
			l1 = l1.getLeft();
		}
		Employee r = admi.getRoot();
		Employee r1 = a.getRoot();
		while(l != null && l1 != null) {
			assertTrue("The employee have the wrong value", r.getID() == r1.getID());
			r = r.getRight();
			r1 = r1.getRight();
		}
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The element of the list have the wrong value", a.getEmployees().get(i).getID() == admi.getEmployees().get(i).getID());
		}
	}
	@Test
	void testSearchEmployee() throws FileNotFoundException, ClassNotFoundException, IOException, NotInformationException {
		setupScenary5();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The element searched have the wrong value", a.searchEmployee("1006217501").getID() == admi.getRoot().getID());
		assertTrue("The element searched have the wrong value", a.searchEmployee("1006216578").getID() == admi.getRoot().getLeft().getID());
		assertTrue("The element searched have the wrong value", a.searchEmployee("66930656").getID() == admi.getRoot().getLeft().getLeft().getID());
		assertTrue("The element searched have the wrong value", a.searchEmployee("1112345678").getID() == admi.getRoot().getRight().getID());
	}
	@Test
	void testCalculatePayrollEmployees() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary4();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The value found have it's wrong", a.calculatePayrollEmployees(a.getFirst()) == admi.calculatePayrollEmployees(admi.getFirst()));
	}
	@Test
	void testEnterSystem() throws FileNotFoundException, ClassNotFoundException, IOException, NotInformationException, IncorrectInformationException {
		setupScenary2();
		assertTrue("The entry to the system is wrong", admi.enterSystem(admi.getManager().getID(), admi.getManager().getPassword()) == "Welcome!");
	}
	@Test
	void testSortByLastName() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		a.sortByLastName();
		admi.sortByLastName();
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The sorting algorithm it's wrong", a.getEmployees().get(i).getLastName().equals(admi.getEmployees().get(i).getLastName()) == true);
		}
	}
	@Test
	void testSortByName() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		a.sortByName();
		admi.sortByName();
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The sorting algorithm it's wrong", a.getEmployees().get(i).getName().equals(admi.getEmployees().get(i).getName()) == true);
		}
	}
	@Test
	void testSortByID() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		a.sortByID();
		admi.sortByID();
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The sorting algorithm it's wrong", a.getEmployees().get(i).getID() == admi.getEmployees().get(i).getID());
		}
	}
	@Test
	void testSortByHours() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		a.sortByHours();
		admi.sortByHours();
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The sorting algorithm it's wrong", a.getEmployees().get(i).getExtraHours() == admi.getEmployees().get(i).getExtraHours());
		}
	}
	@Test
	void testSortBySalary() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		a.sortBySalary();
		admi.sortBySalary();
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The sorting algorithm it's wrong", a.getEmployees().get(i).getBaseSalary() == admi.getEmployees().get(i).getBaseSalary());
		}
	}
	@Test
	void testSortByArea() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		a.sortByArea();
		admi.sortByArea();
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The sorting algorithm it's wrong", a.getEmployees().get(i).getWorkArea().equals(admi.getEmployees().get(i).getWorkArea()) == true);
		}
	}
	@Test
	void testSortByDays() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		a.sortByDays();
		admi.sortByDays();
		for(int i = 0; i<a.getEmployees().size(); i++) {
			assertTrue("The sorting algorithm it's wrong", a.getEmployees().get(i).getWorkedDays() == admi.getEmployees().get(i).getWorkedDays());
		}
	}
	@Test
	void testSearchByID() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The employee searched it's wrong", a.searchByID(1006217501).getID() == admi.getEmployees().get(0).getID());
	}
	@Test
	void testSearchBySalary() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary6();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The employee searched it's wrong", a.searchByID(1200000).getID() == admi.getEmployees().get(0).getID());
	}
	@Test
	void testnumberEmployees() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary4();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The value found have it's wrong", a.numberEmployees(a.getFirst()) == admi.numberEmployees(admi.getFirst()));
	}
	@Test
	void testAdmiArea() throws FileNotFoundException, ClassNotFoundException, IOException, AreaNotFoundException {
		setupScenary6();
		assertTrue("The value found have it's wrong", admi.admiArea() != "");
	}
	@Test
	void testPlantArea() throws FileNotFoundException, ClassNotFoundException, IOException, AreaNotFoundException {
		setupScenary6();
		assertTrue("The value found have it's wrong", admi.PlantArea() != "");
	}
	@Test
	void testFinanceArea() throws FileNotFoundException, ClassNotFoundException, IOException, AreaNotFoundException {
		setupScenary6();
		assertTrue("The value found have it's wrong", admi.FinanceArea() != "");
	}
	@Test
	void testITArea() throws FileNotFoundException, ClassNotFoundException, IOException, AreaNotFoundException {
		setupScenary6();
		assertTrue("The value found have it's wrong", admi.ITArea() != "");
	}
	@Test
	void testAdversitingArea() throws FileNotFoundException, ClassNotFoundException, IOException, AreaNotFoundException {
		setupScenary6();
		try {
			admi.adverArea();
		}
		catch(AreaNotFoundException e) {
			
		}
	}
	@Test
	void testCalculateWorkedDays() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary4();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The value found have it's wrong", a.calculateWorkedDays(a.getFirst()) == admi.calculateWorkedDays(admi.getFirst()));
	}
	@Test
	void testCalculateExtraHoursWorked() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary4();
		Administration a = new Administration();
		a.loadEmployees("testData/employeesTest");
		assertTrue("The value found have it's wrong", a.calculateExtraHoursWorked(a.getFirst()) == admi.calculateExtraHoursWorked(admi.getFirst()));
	}
}
