package model;
/**
 * This class manage the necessary attributes and methods to manage the balance
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements BalanceAccount, Comparable<Account>{
	//Attributes & constants
	private String name;
	private int code;
	private double debit;
	private double credit;
	private List<Double> listDebit;
	private List<Double> listCredit;
	//Constructor method
		/**
		 * <b>Account Constructor</b><br>
		 * @param name the name of the account 
	     * @param code the code of the account
		 */
	public Account(String name, int code) {
		this.name = name;
		this.code = code;
		this.listDebit = new ArrayList<Double>();
		this.listCredit = new ArrayList<Double>();
	}
	/**
	 * this method allows to return the debit's value of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return debit a double that represents the debit's value of the account
	 */
	public double getDebit() {
		return debit;
	}
	/**
	 * this method allows to return the credit's value of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return debit a double that represents the credit's value of the account
	 */
	public double getCredit() {
		return credit;
	}
	/**
	 * this method allows to change the debit's value with the new value that arrives as a parameter 
	 * @param debit a double that represent's the debit's value of the account
	 *<b>Pre:</b> the account exists<br>
	 *<b>Pos:</b> the value of the attribute is succesfully changed<br> 
	 */
	public void setDebit(double debit) {
		this.debit = debit;
	}
	/**
	 * this method allows to change the credit's value with the new value that arrives as a parameter 
	 * @param credit a double that represent's the credit's value of the account
	 *<b>Pre:</b> the account exists<br>
	 *<b>Pos:</b> the value of the attribute is succesfully changed<br> 
	 */
	public void setCredit(double credit) {
		this.credit = credit;
	}
	/**
	 * this method allows to return the name of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return name a String that represents the name of the account
	 */
	public String getName() {
		return name;
	}
	/**
	 * this method allows to return the code of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return code a int that represents the code of the account
	 */
	public int getCode() {
		return code;
	}
	/**
	 * This method returns the list of debits of the accounts <br>
	 * @return the list of debits
	 */
	public List<Double> getListDebit() {
		return listDebit;
	}
	/**
	 * This method returns the list of credits of the accounts <br>
	 * @return the list of credits
	 */
	public List<Double> getListCredit() {
		return listCredit;
	}
	/**
	 * this method allows to calculate the total debits of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return balance a double that represents the total value of debits in the account
	 */
	public double calculateDebit() {
		double balance = 0;
		for(int i = 0; i < listDebit.size(); i++) {
			balance += listDebit.get(i);
		}
		return balance;
	}
	/**
	 * this method allows to calculate the total credits of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return balance a double that represents the total value of credits in the account
	 */
	public double calculateCredit() {
		double balance = 0;
		for(int i = 0; i < listCredit.size(); i++) {
			balance += listCredit.get(i);
		}
		return balance;
	}
	/**
	 * this method allows to obtain the total balance of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return balance a double that represents the total balance of the account
	 */
	public double getTotalBalance() {
		double totalBalance = BalanceAccount.calculateBalanceAccount(calculateDebit(), calculateCredit());
		return totalBalance;
	}
	/**
	 * this method allows to see the total balance of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return balance a String that represents the message of the total balance of the account
	 */
	public String getBalance() {
		String balance = BalanceAccount.calculateBalance(calculateDebit(), calculateCredit());
		return balance;
	}
	/**
	 * this method allows to return the information of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return msg a String that represents the information the account
	 */
	public String toString(){
		String msg = " "+code+" "+name+" "+debit+" "+credit;
		return msg;
		}
	/**
	 * this method allows to compare two accounts by code
	 * <b>Pre:</b> the account exists<br>
	 * @param account a Account which will compare the current
	 * @return comparation a int that represents the value of the comparation
	 */
	@Override
	public int compareTo(Account account) {
		int comparation;
		if(code < account.code) {
			comparation = -1;
		}else if(code > account.code) {
			comparation = 1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
	
}