package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the IT Area User Interface.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
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
    /** this method allows to show the information of the employees in the IT area. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void seeIT(ActionEvent event) throws IOException, ClassNotFoundException {
    	admi = new Administration();
    	try {
    		itArea.setText(admi.ITArea());
    	}catch(AreaNotFoundException e) {
    		itArea.setText(e.getMessage());
    	}
    }
    /**
     * This method handles a new event into the stage, showing the options of the finance area
     * @throws IOException if the fxml file can't be correctly loaded. 
     */
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
