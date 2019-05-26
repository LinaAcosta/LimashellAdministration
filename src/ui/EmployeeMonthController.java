package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the Employee's month User Interface.
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

public class EmployeeMonthController {

    @FXML
    private TextField id;

    @FXML
    private Label info;
    private Administration admi;

    @FXML
    /** this method allows to choose the employee of the month. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void choose(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
    	admi = new Administration();
    	if(id.getText().isEmpty() == true) {
    		info.setText("Please enter the id");
    	}else {
    		Employee e = admi.searchEmployeeMonth(Integer.parseInt(id.getText()));
    		if(e == null) {
    			info.setText("The employee does not exist");
    		}else {
    			admi.saveEmployeeMonth();
    			info.setText(e.getMessage());
    		}
    	}
    }
    /**
     * This method handles a new event into the stage, showing the options of the employee's month
     * @throws IOException if the fxml file can't be correctly loaded. 
     */
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employee.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Options");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}
