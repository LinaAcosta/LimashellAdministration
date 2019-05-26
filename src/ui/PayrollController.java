package ui;

import java.io.IOException;

import customExceptions.NotInformationException;
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

public class PayrollController {
	private Administration admi;

    @FXML
    private Label employeeInfo;

    @FXML
    private Label salary;

    @FXML
    private Label days;

    @FXML
    private Label hours;

    @FXML
    private Label totalAcrued;

    @FXML
    private Label hContributions;

    @FXML
    private Label pContributions;

    @FXML
    private Label totalD;

    @FXML
    private Label paidNet;

    @FXML
    private Label totalPaidNet;
    
    @FXML
    private TextField id;

    @FXML
    void CalculateTotalPaidNet(ActionEvent event) throws IOException {
    	admi = new Administration();
    	admi.loadEmployees();
    	double total = admi.calculatePayrollEmployees(admi.getFirst());
    	totalPaidNet.setText("The total value to be paid by all workers is: " + total);
    }

    @FXML
    void calculatePayroll(ActionEvent event) throws NotInformationException {
    	String ide;
    	if(id.getText().isEmpty() == true) {
    		ide = null;
    	}else {
    		ide = id.getText();
    	}
    	try {
    		if(admi.searchEmployee(ide) == null) {
    			employeeInfo.setText("The employee does not exist");
    		}else {
    			Employee e = admi.searchEmployee(id.getText());
    			double totalA = ((e.getBaseSalary()/30)*e.getWorkedDays()) + (e.getExtraHours()*4313);
    			salary.setText(""+ e.getBaseSalary());
    			days.setText(""+ (e.getBaseSalary()/30)*e.getWorkedDays());
    			hours.setText("" + e.getExtraHours()*4313);
    			totalAcrued.setText("" + totalA);
    			hContributions.setText("" + totalA*0.04);
    			pContributions.setText("" + totalA*0.04);
    			totalD.setText("" + 2*totalA*0.04);
    			paidNet.setText("" + e.calculatePayroll());
    			
    		}
    	}catch(NotInformationException e) {
    		employeeInfo.setText(e.getMessage());
    	}
    }

    @FXML
    void searchEmployee(ActionEvent event) throws IOException, NotInformationException {
    	admi = new Administration();
    	admi.loadEmployees();
    	String ide;;
    	if(id.getText().isEmpty() == true) {
    		ide = null;
    	}else {
    		ide = id.getText();
    	}
    	try {
    		if(admi.searchEmployee(ide) == null) {
    			employeeInfo.setText("The employee does not exist");
    		}else {
    			employeeInfo.setText(admi.searchEmployee(ide).getMessage());
    		}
    	}catch(NotInformationException e) {
    		employeeInfo.setText(e.getMessage());
    	}
    }
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payroll.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Calculate Payroll");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}
