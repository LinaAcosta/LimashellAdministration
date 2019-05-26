package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the works areas.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
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
    /** this method allows to show the screen to show the options of the administrative area. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void adminArea(ActionEvent event) throws IOException {
    	a = new AdmiAreaController();
    	a.seeOptions();
    }

    @FXML
    /** this method allows to show the screen to show the options of the advertising area. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void adverArea(ActionEvent event) throws IOException {
    	ad = new AdverAreaController();
    	ad.seeOptions();
    }

    @FXML
    /** this method allows to show the screen to show the options of the finance area. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void financeArea(ActionEvent event) throws IOException {
    	f = new FinanceController();
    	f.seeOptions();

    }

    @FXML
    /** this method allows to show the screen to show the options of the it area. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void itArea(ActionEvent event) throws IOException {
    	i = new ITAreaController();
    	i.seeOptions();

    }

    @FXML
    /** this method allows to show the screen to show the options of the plant area. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void planArea(ActionEvent event) throws IOException {
    	p = new PlantAreaController();
    	p.seeOptions();

    }
    /**
     * This method handles a new event into the stage, showing the options of the works areas
     * @throws IOException if the fxml file can't be correctly loaded. 
     */
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
