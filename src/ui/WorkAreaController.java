package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WorkAreaController {
	private AdmiAreaController a;
	private ITAreaController i;
	private PlantAreaController p;
	private FinanceController f;
	private AdverAreaController ad;
    @FXML
    void adminArea(ActionEvent event) throws IOException {
    	a = new AdmiAreaController();
    	a.seeOptions();
    }

    @FXML
    void adverArea(ActionEvent event) throws IOException {
    	ad = new AdverAreaController();
    	ad.seeOptions();
    }

    @FXML
    void financeArea(ActionEvent event) throws IOException {
    	f = new FinanceController();
    	f.seeOptions();

    }

    @FXML
    void itArea(ActionEvent event) throws IOException {
    	i = new ITAreaController();
    	i.seeOptions();

    }

    @FXML
    void planArea(ActionEvent event) throws IOException {
    	p = new PlantAreaController();
    	p.seeOptions();

    }
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("workarea.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Work Area");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}
