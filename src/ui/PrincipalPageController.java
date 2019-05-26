package ui;

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
