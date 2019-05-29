package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the balance ui.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Account;
import model.Assets;
import model.Company;
import model.Liabilities;
import model.Patrimonies;

public class BalanceController {
	
	private Company company;
	
	@FXML
    private BorderPane borderPane;

    @FXML
    private ImageView logo;

    @FXML
    private Label companyInformation;

    @FXML
    private SplitPane slipPane;

    @FXML
    private TableView<Account> table;

    @FXML
    private TableColumn<Account, Integer> code;

    @FXML
    private TableColumn<Account, String> name;

    @FXML
    private TableColumn<Account, Double> debit;

    @FXML
    private TableColumn<Account, Double> credit;
    
    @FXML
    private Label balance;
    
    @FXML
    private TextArea listDebit;

    @FXML
    private TextArea listCredit;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField codeTF;

    @FXML
    private TextField debitTF;

    @FXML
    private TextField creditTF;
    
    private ObservableList<Account> listAssets; 
    
    private ObservableList<Account> listLiabilities;
    
    private ObservableList<Account> listPatrimonies; 
      
    @FXML
    /**
	 * This method initialize the components of the GUI before to be launched by the constructor main method.
	 * 
	 */
    public void initialize() throws IOException{
    	
    	company = new Company();
    	company.loadInformation("data/companyInformation.txt");
    	Image imagen = new Image(company.getLogo());
    	logo.setImage(imagen);
    	companyInformation.setText("     "+company.getName()+"\n"+"NIT "+company.getNit());
    	initializeTable();
    	
    }
    /**
	 * This method initialize the component Table.
	 * 
	 */
    public void  initializeTable() throws IOException {
    	code.setCellValueFactory(new PropertyValueFactory<>("code"));
		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		debit.setCellValueFactory(new PropertyValueFactory<>("debit"));
		
		credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
    }
    
    @FXML
    /** this method allows to handle the row selected. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void handleRowSelect(MouseEvent event) {
    	Account row = table.getSelectionModel().getSelectedItem(); 
        if(row != null){ 
        	nameTF.setText(row.getName());
        	codeTF.setText(""+row.getCode());
        	addListBalance(row);
        } 
    }
    /** this method add the elements to the balance's list. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void addListBalance(Account current) {
    	if(current.getListDebit()!= null) {
    		String debit = "";
    		for(int i = 0; i<current.getListDebit().size(); i++) {
    			debit += " "+current.getListDebit().get(i)+"\n";
        	}
    		listDebit.setText(debit);
    	}
    	
    	if(current.getListCredit()!= null) {
        	String credit = ""; 
    		for(int i = 0; i<current.getListCredit().size(); i++) {
        		credit += " "+current.getListCredit().get(i)+"\n";
        	}
    		listCredit.setText(credit);
    	}
    	balance.setText(current.getBalance());
    	current.setCredit(current.calculateCredit());
    	current.setDebit(current.calculateDebit());
    }
    
    /** this method allows to create the asset's list by the reading of an archive text. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the assets.
	 */
    public ObservableList<Account> getAssets(List<Assets> current) throws IOException{
    	listAssets = FXCollections.observableArrayList();
    	for(int i = 0 ;i < current.size(); i++) {
    		listAssets.add(current.get(i));
    	}
		return listAssets;
    }
    /** this method allows to create the liabilities's list by the reading of an archive text. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the liabilities.
	 */
    public ObservableList<Account> getLiabilities(List<Liabilities> current) throws IOException{
    	listLiabilities = FXCollections.observableArrayList();
    	for(int i = 0 ;i < current.size(); i++) {
    		listLiabilities.add(current.get(i));
    	}
		return listLiabilities;
    }
    /** this method allows to create the patrimonies's list by the reading of an archive text. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the patrimonies.
	 */
    public ObservableList<Account> getPatrimonies(List<Patrimonies> current) throws IOException{
    	listPatrimonies = FXCollections.observableArrayList();
    	for(int i = 0 ;i < current.size(); i++) {
    		listPatrimonies.add(current.get(i));
    	}
		return listPatrimonies;
    }
    
    @FXML
    /** this method allows to add an balance to the account. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void addBalance(ActionEvent event) {
    	
    	String code = codeTF.getText(); 
    	if(code.charAt(0) == '1' ) {
    		addBalanceAssets(code);
    	}
    	else if(code.charAt(0) == '2') {
    		addBalanceLiabilities(code);
    	}
    	else {
    		addBalancePatrimonies(code);
    	}
    }
    /** this method allows to add an balance to the asset's account. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void addBalanceAssets(String code) {
    	if(debitTF.getText() != null) {
			int code1 = Integer.parseInt(code);
			Assets current = company.searchAssetsByCode(code1);
			String debitCurrent = debitTF.getText();
			double debit = Double.parseDouble(debitCurrent);
			current.getListDebit().add(debit);
			addListBalance(current);
		}
		if(creditTF.getText() != null) {
			int code1 = Integer.parseInt(code);
			Assets current = company.searchAssetsByCode(code1);
			String creditCurrent = creditTF.getText();
			double credit = Double.parseDouble(creditCurrent);
			current.getListCredit().add(credit);
			addListBalance(current);
		}
    }
    /** this method allows to add an balance to the liabilitie's account. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void addBalanceLiabilities(String code) {
    	if(debitTF.getText() != null) {
			int code1 = Integer.parseInt(code);
			Liabilities current = company.searchLiabilitiesByCode(code1);
			String debitCurrent = debitTF.getText();
			double debit = Double.parseDouble(debitCurrent);
			current.getListDebit().add(debit);
			addListBalance(current);
		}
		if(creditTF.getText() != null) {
			int code1 = Integer.parseInt(code);
			Liabilities current = company.searchLiabilitiesByCode(code1);
			String creditCurrent = creditTF.getText();
			double credit = Double.parseDouble(creditCurrent);
			current.getListCredit().add(credit);
			addListBalance(current);
		}
    }
    /** this method allows to add an balance to the patrimonie's account. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void addBalancePatrimonies(String code) {
    	if(debitTF.getText() != null) {
			int code1 = Integer.parseInt(code);
			Patrimonies current = company.searchPatrimoniesByCode(code1);
			String debitCurrent = debitTF.getText();
			double debit = Double.parseDouble(debitCurrent);
			current.getListDebit().add(debit);
			addListBalance(current);
		}
		if(creditTF.getText() != null) {
			int code1 = Integer.parseInt(code);
			Patrimonies current = company.searchPatrimoniesByCode(code1);
			String creditCurrent = creditTF.getText();
			double credit = Double.parseDouble(creditCurrent);
			current.getListCredit().add(credit);
			addListBalance(current);
		}
    }
    @FXML
    /** this method allows to see the asset's list. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void assets(ActionEvent event) throws IOException {
    	company.loadAssets();
    	getAssets(company.getAssets());
    	table.setItems(listAssets);
    }

    @FXML
    /** this method allows to see the liabilities's list. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void liabilities(ActionEvent event) throws IOException {
    	company.loadLiabilities();
    	getLiabilities(company.getLiabilities());
    	table.setItems(listLiabilities);
    }

    @FXML
    /** this method allows to see the patrimonies's list. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 */
    public void patrimonies(ActionEvent event) throws IOException {
    	company.loadPatrimonies();
    	getPatrimonies(company.getPatrimonies());
    	table.setItems(listPatrimonies);
    }

    @FXML
    public void saveInformation(ActionEvent event) {

    }

    @FXML
    /** this method allows to show the information of the account sorting by code. <br>
   	 * @param event the event that is caused by the user to trigger the method.
   	 * @throws IOException in the case of a problem reading or finding the file that recovers the account.
   	 */
    public void sortCode(ActionEvent event) throws IOException {
    	String code = ""+table.getItems().get(0).getCode();
    	if(code.charAt(0) == '1') {
    		company.sortAssetsByCode();
    		getAssets(company.getAssets());
    		table.setItems(listAssets);
    	}
    	else if(code.charAt(0) == '2') {
    		company.sortLiabilitiesByCode();
    		getLiabilities(company.getLiabilities());
        	table.setItems(listLiabilities);
    	}
    	else {
    		company.sortPatrimoniesByCode();
    		getPatrimonies(company.getPatrimonies());
        	table.setItems(listPatrimonies);
    	}
    }

    @FXML
    /** this method allows to show the information of the account sorting by name. <br>
   	 * @param event the event that is caused by the user to trigger the method.
   	 * @throws IOException in the case of a problem reading or finding the file that recovers the account.
   	 */
    public void sortName(ActionEvent event) throws IOException {
    	String code = ""+table.getItems().get(0).getCode();
    	if(code.charAt(0) == '1') {
    		company.sortAssetsByName();
    		getAssets(company.getAssets());
    		table.setItems(listAssets);
    	}
    	else if(code.charAt(0) == '2') {
    		company.sortLiabilitiesByName();
    		getLiabilities(company.getLiabilities());
        	table.setItems(listLiabilities);
    	}
    	else {
    		company.sortPatrimoniesByName();
    		getPatrimonies(company.getPatrimonies());
        	table.setItems(listPatrimonies);
    	}
    }

    @FXML
    public void testBalance(ActionEvent event) {
    	//Label label = new Label(""+company.testBalance());
    }
    /**
     * This method handles a new event into the stage, showing the options of the balance
     * @throws IOException if the fxml file can't be correctly loaded. 
     */
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("balance.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Balance");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }

}