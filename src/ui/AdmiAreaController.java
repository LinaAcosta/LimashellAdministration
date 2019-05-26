package ui;

import java.io.IOException;

import customExceptions.AreaNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Administration;

public class AdmiAreaController {

    @FXML
    private Label infoArea;
    private Administration admi;
    @FXML
    void seeEmployees(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	try {
    		infoArea.setText(admi.admiArea());
    	}catch(AreaNotFoundException e) {
    		infoArea.setText(e.getMessage());
    	}
    }

    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admi.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Admin Area");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}
