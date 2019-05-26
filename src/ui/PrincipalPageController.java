package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the principal page ui.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.io.IOException;

import customExceptions.IncorrectInformationException;
import customExceptions.NotInformationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Administration;

public class PrincipalPageController {
	private Administration admi;

    @FXML
    private TextField id;

    @FXML
    private TextField password;

    @FXML
    private Label message;

    private NextScreenController n;
    @FXML
    /** this method allows the entry of the manager to the administrative platform. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
     * @throws NotInformationException in the case that the param not exists.
	 * @throws IncorrectInformationException in the case that the param are differents to the information of the manager.
	 */
    void enter(ActionEvent event) throws IOException, NotInformationException, IncorrectInformationException, ClassNotFoundException {
    	admi = new Administration();
    	admi.loadManagerInformation();
    	String i;
    	String p;
    	if(id.getText().isEmpty() == true) {
    		i = null;
    		if(password.getText().isEmpty() == true) {
    			p = null;
    		}
    		else {
    			p = password.getText();
    		}
    	}else {
    		i = id.getText();
    		if(password.getText().isEmpty() == true) {
    			p = null;
    		}else {
    			p = password.getText();
    		}
    	}
    	try{
    		message.setText(admi.enterSystem(i, p));
    		n = new NextScreenController();
    		n.seeOptions();
    	}catch(NotInformationException e) {
    		message.setText(e.getMessage());
    	}catch(IncorrectInformationException e) {
    		message.setText(e.getMessage());
    	}
    	
    	
    }

}
