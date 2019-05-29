package model;
/**
 * This class manage the necessary attributes and methods to manage the balance
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public interface BalanceAccount {
	//Attributes & constants
	public final static String ZERO_BALANCE = "Zero Balance";
	public final static String DEBIT_BALANCE = "Debit Balance";
	public final static String CREDIT_BALANCE = "Credit Balance";
	/**
	 * this method allows to see the type of the balance
	 * <b>Pre:</b> the account exists<br>
	 * @return balance a String that represents the message of the type of the balance
	 */
	public static String calculateBalance(double debit, double credit) {
		String balance;
		if(debit > credit) {
			balance = DEBIT_BALANCE;
		}else if(debit < credit) {
			balance = CREDIT_BALANCE;
		}else {
			balance = ZERO_BALANCE;
		}
		return balance;
	}
	/**
	 * this method allows to obtain the total balance of the account
	 * <b>Pre:</b> the account exists<br>
	 * @return balance a double that represents the total balance of the account
	 */
	public static double calculateBalanceAccount(double debit, double credit) {
		double balance = 0;
		if(calculateBalance(debit,credit) == DEBIT_BALANCE) {
			balance = debit-credit;
		}else if(calculateBalance(debit,credit) == CREDIT_BALANCE) {
			balance = credit-debit;
		}else {
			balance = 0;
		}
		return balance;
	}
}