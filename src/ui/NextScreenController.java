package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NextScreenController {
	private PayrollController p;
	private ListEmployeesController l;

    @FXML
    void calculatePayroll(ActionEvent event) throws IOException{
    	p = new PayrollController();
    	p.seeOptions();
    }

    @FXML
    void listEmployees(ActionEvent event) throws IOException {
    	l = new ListEmployeesController();
    	l.seeOptions();

    }
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("next.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Options");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}
