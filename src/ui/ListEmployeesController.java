package ui;

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

    @FXML
    void sortByArea(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees();
    	Employee[] em = admi.sortByArea();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    void sortByDays(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees();
    	Employee[] em = admi.sortByDays();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    void sortByHours(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees();
    	Employee[] em = admi.sortByHours();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    void sortByID(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees();
    	Employee[] em = admi.sortByID();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    void sortByLastName(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees();
    	Employee[] em = admi.sortByLastName();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);

    }

    @FXML
    void sortByName(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees();
    	Employee[] em = admi.sortByName();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }

    @FXML
    void sortBySalary(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	String message = "";
    	admi.loadEmployees();
    	Employee[] em = admi.sortBySalary();
    	for(int i = 0; i < em.length; i++) {
    		message = message + em[i].getMessage2();
    	}
    	sortEmployees.setText(message);
    }
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
    void numberEmployees(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	admi.loadEmployees();
    	double total = admi.numberEmployees(admi.getFirst());
    	infoEmployee.setText("Number of employees: " + total);
    }
    @FXML
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
    void workedDays(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	admi.loadEmployees();
    	double total = admi.calculateWorkedDays(admi.getFirst());
    	infoEmployee.setText("Promedium days worked: " + total/10);
    }
    @FXML
    void extraHours(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
    	admi = new Administration();
    	admi.loadEmployees();
    	double total = admi.calculateExtraHoursWorked(admi.getFirst());
    	infoEmployee.setText("Extra hours worked: " + total);
    }

}

