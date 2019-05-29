package model;
/**
 * This class manage the necessary attributes and methods to manage the accounts
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Company {
	//Attributes & constants
	private String name;
	private String nit;
	private String logo;
	private List<Assets> assets;
	private List<Liabilities> liabilities;
	private List<Patrimonies> patrimonies;
	public final static String PATH_ASSETS = "data/assets.txt";
	public final static String PATH_LIABILITIES = "data/liabilities.txt";
	public final static String PATH_PATRIMONIES = "data/patrimonies.txt";
	//Constructor method
			/**
			 * <b>Account Constructor</b><br>
			 */
	public Company() {
		this.name = null;
		this.nit = null;
		this.logo = null;
		assets = new ArrayList<Assets>();
		liabilities = new ArrayList<Liabilities>();
		patrimonies = new ArrayList<Patrimonies>();
	}
	/**
	 * this method allows to return the name of the company
	 * <b>Pre:</b> the company exists<br>
	 * @return name a String that represents the name of the company
	 */
	public String getName() {
		return name;
	}
	/**
	 * this method allows to return the nit of the company
	 * <b>Pre:</b> the company exists<br>
	 * @return nit a String that represents the nit of the company
	 */
	public String getNit() {
		return nit;
	}
	/**
	 * this method allows to return the logo of the company
	 * <b>Pre:</b> the company exists<br>
	 * @return logo a String that represents the logo of the company
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * this method allows to return the list of assets of the company
	 * <b>Pre:</b> the company exists<br>
	 * @return assets a List that represents the assets of the company
	 */
	public List<Assets> getAssets() {
		return assets;
	}
	/**
	 * this method allows to return the list of liabilities of the company
	 * <b>Pre:</b> the company exists<br>
	 * @return liabilities a List that represents the liabilities of the company
	 */
	public List<Liabilities> getLiabilities() {
		return liabilities;
	}
	/**
	 * this method allows to return the list of patrimonies of the company
	 * <b>Pre:</b> the company exists<br>
	 * @return patrimonies a List that represents the patrimonies of the company
	 */
	public List<Patrimonies> getPatrimonies() {
		return patrimonies;
	}
	/**
	 * This method allows to import and read a file that contains the respective information of an account.<br>
	 * <b>Pre:</b> The path of the file exists
	 * <b>Pre:</b> The file exists<br>
	 * <b>Pos:</b> The file had been readed and the information within it has been used to create the account of the company<br>
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public void loadInformation(String path) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] parts = line.split(";");
			name = parts[0];
			nit = parts[1];
			logo = parts[2];
			
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
	}
	/**
	 * This method allows to import and read a file that contains the respective information of the assets of the company.<br>
	 * <b>Pre:</b> The path of the file exists
	 * <b>Pre:</b> The file exists<br>
	 * <b>Pos:</b> The file had been readed and the information within it has been used to create the assets of the company<br>
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public void loadAssets() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(PATH_ASSETS)));
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] parts = line.split(";");
			int code = Integer.parseInt(parts[0]);
			String name = parts[1];
			Assets current = new Assets(name,code);
			assets.add(current);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
	}
	/**
	 * This method allows to import and read a file that contains the respective information of the liabilities of the company.<br>
	 * <b>Pre:</b> The path of the file exists
	 * <b>Pre:</b> The file exists<br>
	 * <b>Pos:</b> The file had been readed and the information within it has been used to create the liabilities of the company<br>
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public void loadLiabilities() throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(PATH_LIABILITIES)));
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] parts = line.split(";");
			int code = Integer.parseInt(parts[0]);
			String name = parts[1];
			Liabilities current = new Liabilities(name,code);
			liabilities.add(current);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
	}
	/**
	 * This method allows to import and read a file that contains the respective information of the patrimonies of the company.<br>
	 * <b>Pre:</b> The path of the file exists
	 * <b>Pre:</b> The file exists<br>
	 * <b>Pos:</b> The file had been readed and the information within it has been used to create the patrimonies of the company<br>
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public void loadPatrimonies() throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(PATH_PATRIMONIES)));
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] parts = line.split(";");
			int code = Integer.parseInt(parts[0]);
			String name = parts[1];
			Patrimonies current = new Patrimonies(name,code);
			patrimonies.add(current);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
	}
	/**
     * This method sort the assets by code from lowest to highest.<br>
     * <b>Pre:</b> the list of assets exist.<br>
	 * <b>Post:</b> the list of assets is sort by id. <br> 
	 * @return a list that represents the assets of the company sorting by code
     */
	public void sortAssetsByCode() {
		Collections.sort(assets);
	}
	/**
     * This method sort the assets by name in an lexicographycal order.<br>
     * <b>Pre:</b> the list of assets exist.<br>
	 * <b>Post:</b> the list of assets is sort by id. <br> 
	 * @return a list that represents the assets of the company sorting by name
     */
	public void sortAssetsByName() {
		Collections.sort(assets, new  AccountNameComparator());
	}
	/**
     * This method sort the liabilities by code from lowest to highest.<br>
     * <b>Pre:</b> the list of liabilities exist.<br>
	 * <b>Post:</b> the list of liabilities is sort by id. <br> 
	 * @return a list that represents the liabilities of the company sorting by code
     */
	public void sortLiabilitiesByCode() {
		Collections.sort(liabilities);
	}
	/**
     * This method sort the liabilities by name in an lexicographycal order.<br>
     * <b>Pre:</b> the list of liabilities exist.<br>
	 * <b>Post:</b> the list of liabilities is sort by id. <br> 
	 * @return a list that represents the liabilities of the company sorting by name
     */
	public void sortLiabilitiesByName() {
		Collections.sort(liabilities, new AccountNameComparator());
	}
	/**
     * This method sort the patrimonies by code from lowest to highest.<br>
     * <b>Pre:</b> the list of patrimonies exist.<br>
	 * <b>Post:</b> the list of patrimonies is sort by id. <br> 
	 * @return a list that represents the parrimonies of the company sorting by code
     */
	public void sortPatrimoniesByCode() {
		Collections.sort(patrimonies);
	}
	/**
     * This method sort the patrimonies by name in an lexicographycal order.<br>
     * <b>Pre:</b> the list of patrimonies exist.<br>
	 * <b>Post:</b> the list of patrimonies is sort by id. <br> 
	 * @return a list that represents the patrimonies of the company sorting by name
     */
	public void sortPatrimoniesByName() {
		Collections.sort(patrimonies, new AccountNameComparator());
	}
	/**
	 * This method searchs an code inside the list associated with the assets of the company.<br>
	 * @param code the code associated to the asset that needs to be found
	 * @return an Asset that represents the asset that was found
	 */
	public Assets searchAssetsByCode(int code) {
		Assets searched = null;
		for(int i = 0; i< assets.size(); i++) {
			if(assets.get(i).getCode() == code) {
				searched = assets.get(i);
			}
		}
		return searched;
	}
	/**
	 * This method searchs an code inside the list associated with the liabilities of the company.<br>
	 * @param code the code associated to the liabilitie that needs to be found
	 * @return an Liabilitie that represents the liabilitie that was found
	 */
	public Liabilities searchLiabilitiesByCode(int code) {
		Liabilities searched = null;
		for(int i = 0; i< liabilities.size(); i++) {
			if(liabilities.get(i).getCode() == code) {
				searched = liabilities.get(i);
			}
		}
		return searched;
	}
	/**
	 * This method searchs an code inside the list associated with the patrimonies of the company.<br>
	 * @param code the code associated to the patrimonie that needs to be found
	 * @return an Patrimonie that represents the patrimonie that was found
	 */
	public Patrimonies searchPatrimoniesByCode(int code) {
		Patrimonies searched = null;
		for(int i = 0; i< patrimonies.size(); i++) {
			if(patrimonies.get(i).getCode() == code) {
				searched = patrimonies.get(i);
			}
		}
		return searched;
	}
	/**
	 * This method calculate the total balance of the assets that has the company<br>
	 * <b>Pre:</b> the list of assets exist.<br>
	 * <b>Post:</b> the total balance of assets is calculated. <br> 
	 * @return a double that represents the total balance of the assets of the company 
	 */
	public double totalAssetsBalance(){
		double totalBalance = 0;
		List<Assets> current = assetsBalance();
		for(int i = 0; i< current.size(); i++){
			totalBalance += current.get(i).getTotalBalance();
		}
		return totalBalance;
	} 
	/**
	 * This method calculate the total balance of the liabilities that has the company<br>
	 * <b>Pre:</b> the list of liabilities exist.<br>
	 * <b>Post:</b> the total balance of liabilities is calculated. <br> 
	 * @return a double that represents the total balance of the liabilities of the company 
	 */
	public double totalLiabilitiesBalance(){
		double totalBalance = 0;
		List<Liabilities> current = liabilitiesBalance();
		for(int i = 0; i< current.size(); i++){
			totalBalance += current.get(i).getTotalBalance();
		}
		return totalBalance;
	} 
	/**
	 * This method calculate the total balance of the patrimonies that has the company<br>
	 * <b>Pre:</b> the list of patrimonies exist.<br>
	 * <b>Post:</b> the total balance of patrimonies is calculated. <br> 
	 * @return a double that represents the total balance of the patrimonies of the company 
	 */
	public double totalPatrimoniesBalance(){
		double totalBalance = 0;
		List<Patrimonies> current = patrimoniesBalance();
		for(int i = 0; i< current.size(); i++){
			totalBalance += current.get(i).getTotalBalance();
		}
		return totalBalance;
	}
	/**
	 * This method add the assets to the assets's list<br>
	 * <b>Pre:</b> the list of assets exist.<br>
	 * <b>Post:</b> the assets are added to the list. <br> 
	 * @return a list that represents the assets of the company
	 */
	public List<Assets> assetsBalance(){
		List<Assets> current = new ArrayList<Assets>();
		for(int i = 0; i<assets.size(); i++){
			if((assets.get(i).getDebit() != 0) || (assets.get(i).getCredit() != 0)){
				current.add(assets.get(i));
				}
			}
		return current;
	}
	/**
	 * This method add the liabilities to the liabilities's list<br>
	 * <b>Pre:</b> the list of liabilities exist.<br>
	 * <b>Post:</b> the liabilities are added to the list. <br> 
	 * @return a list that represents the liabilities of the company
	 */
	public List<Liabilities> liabilitiesBalance(){
		List<Liabilities> current = new ArrayList<Liabilities>();
		for(int i = 0; i<liabilities.size(); i++){
			if((liabilities.get(i).getDebit() != 0) || (liabilities.get(i).getCredit() != 0)){
				current.add(liabilities.get(i));
			}
		}
		return current;
	}
	/**
	 * This method add the patrimonies to the assets's list<br>
	 * <b>Pre:</b> the list of patrimonies exist.<br>
	 * <b>Post:</b> the patrimonies are added to the list. <br> 
	 * @return a list that represents the patrimonies of the company
	 */
	public List<Patrimonies> patrimoniesBalance(){
		List<Patrimonies> current = new ArrayList<Patrimonies>();
		for(int i = 0; i<patrimonies.size(); i++){
			if((patrimonies.get(i).getDebit() != 0) || (patrimonies.get(i).getCredit() != 0)){
				current.add(patrimonies.get(i));
			}
		}
		return current;
	}
	/**
	 * this method allows to return a message that contains the information of the account's balance of the company
	 * <b>Pre:</b> the list of assets exists<br>
	 * <b>Pre:</b> the list of liabilities exists<br>
	 * <b>Pre:</b> the list of patrimonies exists<br>
	 * @return  a String that represents information of the accounts's balance of the company
	 */
	public String testBalance(){ 
		String testBalance = "";
		testBalance += " Code"+ " Name"+" Debit"+" Credit"+"\n";
		List<Assets> assentsCurrent = assetsBalance();
		for(int i = 0; i<assentsCurrent.size(); i++){
			testBalance += ""+ assentsCurrent.get(i).toString()+"\n";
		}
		List<Liabilities> liabilitiesCurrent = liabilitiesBalance();
		for(int i = 0; i<liabilitiesCurrent.size(); i++){
			testBalance += ""+ liabilitiesCurrent.get(i).toString()+"\n";
		}
		List<Patrimonies> patrimoniesCurrent = patrimoniesBalance();
		for(int i = 0; i<patrimoniesCurrent.size(); i++){
			testBalance += ""+ patrimoniesCurrent.get(i).toString()+"\n";
		}
		return testBalance;
	}
}