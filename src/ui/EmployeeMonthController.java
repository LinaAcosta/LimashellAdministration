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

public class EmployeeMonthController {

    @FXML
    private TextField id;

    @FXML
    private Label info;
    private Administration admi;

    @FXML
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
