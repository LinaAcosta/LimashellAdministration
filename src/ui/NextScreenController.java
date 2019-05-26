package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the second screen.
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

public class NextScreenController {
	private PayrollController p;
	private ListEmployeesController l;
	private WorkAreaController w;
	private EmployeeMonthController e;
    @FXML
    /** this method allows to show the screen to calculate payroll. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void calculatePayroll(ActionEvent event) throws IOException{
    	p = new PayrollController();
    	p.seeOptions();
    }

    @FXML
    /** this method allows to show the screen to see the employee's list. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void listEmployees(ActionEvent event) throws IOException {
    	l = new ListEmployeesController();
    	l.seeOptions();

    }
    @FXML
    /** this method allows to show the screen to see the works areas. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void workArea(ActionEvent event) throws IOException {
    	w = new WorkAreaController();
    	w.seeOptions();
    }
    /**
     * This method handles a new event into the stage, showing the options of the second screen
     * @throws IOException if the fxml file can't be correctly loaded. 
     */
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
    @FXML
    /** this method allows to show the screen to choose the month's employee. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employees.
	 */
    void employee_month(ActionEvent event) throws IOException {
    	e = new EmployeeMonthController();
    	e.seeOptions();
    }

}
