package ui;

import java.io.FileNotFoundException;
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

public class AdverAreaController {

    @FXML
    private Label info;
    private Administration admi;

    @FXML
    void seeEmployees(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException {
    	admi = new Administration();
    	try {
    		info.setText(admi.adverArea());
    	}catch(AreaNotFoundException e) {
    		info.setText(e.getMessage());
    	}

    }
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adver.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Adversiting Area");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}
