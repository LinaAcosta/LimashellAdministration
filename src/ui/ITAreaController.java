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

public class ITAreaController {

    @FXML
    private Label itArea;

    private Administration admi;
    @FXML
    void seeIT(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	try {
    		itArea.setText(admi.ITArea());
    	}catch(AreaNotFoundException e) {
    		itArea.setText(e.getMessage());
    	}
    }
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("itArea.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Admin Area");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}
