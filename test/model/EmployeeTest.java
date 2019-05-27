package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;


class EmployeeTest {
    private void setupScenary1() {
		
	}
    private Administration admi;
    private Employee em1;
    private void setupScenary3() throws FileNotFoundException, ClassNotFoundException, IOException {
    	admi = new Administration();
    	em1 = new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
    	admi.setEmployeeMonth(em1);
    }
    @Test
    void testEmployee(){
    	setupScenary1();
    	String name = "Lina";
    	String lastName =  "Acosta";
    	int id= 1006217501;
    	double baseSalary = 1200000;
    	String workArea =  "IT";
    	int extraHours =  2;
    	int workedDays = 30;
    	Employee e = new Employee(name,lastName,id,baseSalary,workArea,extraHours,workedDays);
    	assertNotNull("The new employee is null", e);
		assertTrue("The Employee's name have the wrong value", (name == e.getName()));
		assertTrue("The Employee's  last name have the wrong value", (lastName == e.getLastName()));
		assertTrue("The Employee's id have the wrong value", (id == e.getID()));
		assertTrue("The Employee's salary have the wrong value", (baseSalary == e.getBaseSalary()));
		assertTrue("The Employee's work area have the wrong value", (workArea == e.getWorkArea()));
		assertTrue("The Employee's extra hours have the wrong value", (extraHours == e.getExtraHours()));
		assertTrue("The Employee's worked days have the wrong value", (workedDays == e.getWorkedDays()));
    }
    @Test
    void testCalculePayroll() throws FileNotFoundException, ClassNotFoundException, IOException {
    	setupScenary3();
    	Employee e =  new Employee("Lina","Acosta",1006217501,1200000,"IT",2,30);
    	assertTrue("The Employee's payroll have the wrong value", e.calculatePayroll() == admi.getEmployeeMonth().calculatePayroll());
    }
}
