package model;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class ManagerTest {
    private void setupScenary1() {
		
	}

	@Test
    void testManager() {
		setupScenary1();
		String id = "1006217501";
		String password = "MarcelaHolguin14";
		Manager m = new Manager(id,password);
		assertNotNull("The new employee is null", m);
		assertTrue("The Manager's id have the wrong value", (id == m.getID()));
		assertTrue("The Manager's password have the wrong value", (password == m.getPassword()));
	}

}
