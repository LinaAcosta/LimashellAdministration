package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the Employee's list User Interface.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Administration;
import model.Employee;

public class ListEmployeesController {
	private Administration admi;
	@FXML
    private TextField salary;

    @FXML
    private Label sortEmployees;

    @FXML
    private TextField id;

    @FXML
    private Label infoEmployee;
    public final static String PATH_FILE2 = "data/employees";

    @FXML
    /** this method allows to show the information of the employees sorting for work's area. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void sortByArea(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees(PATH_FILE2);
    	Employee[] em = admi.sortByArea();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    /** this method allows to show the information of the employees sorting by worked days. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void sortByDays(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees(PATH_FILE2);
    	Employee[] em = admi.sortByDays();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    /** this method allows to show the information of the employees sorting by extra hours worked. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void sortByHours(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees(PATH_FILE2);
    	Employee[] em = admi.sortByHours();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    /** this method allows to show the information of the employees sorting by id. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void sortByID(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees(PATH_FILE2);
    	Employee[] em = admi.sortByID();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    /** this method allows to show the information of the employees sorting by last name. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void sortByLastName(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees(PATH_FILE2);
    	Employee[] em = admi.sortByLastName();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);

    }

    @FXML
    /** this method allows to show the information of the employees sorting by name. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void sortByName(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees(PATH_FILE2);
    	Employee[] em = admi.sortByName();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    /** this method allows to show the information of the employees sorting by salary. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void sortBySalary(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees(PATH_FILE2);
    	Employee[] em = admi.sortBySalary();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }
    /**
     * This method handles a new event into the stage, showing the options of the employee's list
     * @throws IOException if the fxml file can't be correctly loaded. 
     */
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("list.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Sort and search");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }
    @FXML
    /** this method allows to search an employee by id. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void searchEmployee(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	if(id.getText().isEmpty() == true) {
    		infoEmployee.setText("Please enter the id");
    	}else {
    		if(admi.searchByID(Integer.parseInt(id.getText())) != null) {
    			infoEmployee.setText(admi.searchByID(Integer.parseInt(id.getText())).getMessage());
    		}else {
    			infoEmployee.setText("The id does not exist");
    			
    		}
    	}
    }
    @FXML
    /** this method allows to calculate the number of employees in the company. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void numberEmployees(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	admi.loadEmployees(PATH_FILE2);
    	double total = admi.numberEmployees(admi.getFirst());
    	infoEmployee.setText("Number of employees: " + total);
    }
    @FXML
    /** this method allows to search an employee by salary. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void searchSalary(ActionEvent event) throws NumberFormatException, IOException, ClassNotFoundException {
    	admi = new Administration();
    	if(salary.getText().isEmpty() == true) {
    		infoEmployee.setText("Please enter the salary");
    	}else {
    		if(admi.searchSalary(Double.parseDouble(salary.getText())) == null) {
    			infoEmployee.setText("The id does not exist");
    		}else {
    			infoEmployee.setText(admi.searchSalary(Double.parseDouble(salary.getText())).getMessage());
    		}
    	}
    }
    @FXML
    /** this method allows to calculate the promedium of days worked by the employees in the company. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void workedDays(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	admi.loadEmployees(PATH_FILE2);
    	double total = admi.calculateWorkedDays(admi.getFirst());
    	infoEmployee.setText("Promedium days worked: " + total/10);
    }
    @FXML
    /** this method allows to calculate the number of extra hours worked by the  employees in the company. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void extraHours(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
    	admi = new Administration();
    	admi.loadEmployees(PATH_FILE2);
    	double total = admi.calculateExtraHoursWorked(admi.getFirst());
    	infoEmployee.setText("Extra hours worked: " + total);
    }

}

