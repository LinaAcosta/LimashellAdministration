package model;
/**
 * This class manage the necessary attributes and methods to manage the employees
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
public class Employee implements Comparable<Employee>{
	//Attributes & constants
	private String name;
	private String last_name;
	private int id;
	private double base_salary;
	private String work_area;
	private int extra_hours;
	private int worked_days;
	private Employee right;
	private Employee left;
	private Employee next;
	/**
	 * <b>Employee constructor</b>
	 * @param n the name of the employee 
	 * @param l the last name of the employee
	 * @param i the id of the employee
	 * @param b the base salary of the employee
	 * @param w the work area of the employee
	 * @param e the extra hours worked by the employee
	 * @param wd the days worked by the employee
	 */
	public Employee(String n, String l, int i, double b, String w, int e, int wd) {
		name = n;
		id = i;
		last_name = l;
		base_salary = b;
		work_area = w;
		extra_hours = e;
		worked_days = wd;
	}
	/**
	 * this method allows to return the next employee asociated to the actual
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return next a Employee that represents the next employee asociated to the actual
	 */
	public Employee getNext() {
		return next;
	}
	/**
	 * this method allows to change the next employee with the new value that arrives as a parameter 
	 * @param e the new next Employee of the actual employee
	 *<b>Pre:</b> the object Employee exists<br>
	 *<b>Pos:</b> the value of the attribute is succesfully changed<br> 
	 */
	public void setNext(Employee e) {
		next = e;
	}
	/**
	 * this method allows to return the right's employee asociated to the actual
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return right a Employee that represents the right's employee asociated to the actual
	 */
	public Employee getRight() {
		return right;
	}
	/**
	 * this method allows to return the left's employee asociated to the actual
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return left a Employee that represents the left's employee asociated to the actual
	 */
	public Employee getLeft() {
		return left;
	}
	/**
	 * this method allows to change the right's employee with the new value that arrives as a parameter 
	 * @param e the new right's Employee of the actual employee
	 *<b>Pre:</b> the object Employee exists<br>
	 *<b>Pos:</b> the value of the attribute is succesfully changed<br> 
	 */
	public void setRight(Employee e) {
		right = e;
	}
	/**
	 * this method allows to change the left's employee with the new value that arrives as a parameter 
	 * @param e the new left's Employee of the actual employee
	 *<b>Pre:</b> the object Employee exists<br>
	 *<b>Pos:</b> the value of the attribute is succesfully changed<br> 
	 */
	public void setLeft(Employee e) {
		left = e;
	}
	/**
	 * this method allows to return the name of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return name a String that represents the name of the employee
	 */
	public String getName() {
		return name;
	}
	/**
	 * this method allows to return the id of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return id a int that represents the id of the employee
	 */
	public int getID() {
		return id;
	}
	/**
	 * this method allows to return the last name of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return last_name a String that represents the last name of the employee
	 */
	public String getLastName() {
		return last_name;
	}
	/**
	 * this method allows to return the salary of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return base_salary a double that represents the salary of the employee
	 */
	public double getBaseSalary() {
		return base_salary;
	}
	/**
	 * this method allows to return the work's area of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return work_area a String that represents the work's area of the employee
	 */
	public String getWorkArea() {
		return work_area;
	}
	/**
	 * this method allows to return the extra hours worked by the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return extra_hours a int that represents the extra hours worked by the employee
	 */
	public int getExtraHours() {
		return extra_hours;
	}
	/**
	 * this method allows to return the days worked by the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return worked_days a int that represents the days worked by the employee
	 */
	public int getWorkedDays() {
		return worked_days;
	}
	/**
	 * this method allows to calculate the payroll of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return payroll a double that represents the total value to be paid to the employee
	 */
	public double calculatePayroll() {
		double payroll = 0;
		double totalAcrued = ((base_salary/30)*worked_days) + (extra_hours*4313);
		double deductions = 2*(totalAcrued*0.04);
		payroll = totalAcrued - deductions;
		return payroll;
	}
	/**
	 * this method allows to return the information of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return message a String that represents the information the employee
	 */
	public String getMessage() {
		String message = "EMPLOYEE" + "\n" + "NAME: " + name + " " + last_name + "\n" + "ID: " + id + "\n" + "BASE SALARY: " + base_salary + "\n" + "WORK AREA: " + work_area + "\n" +  "EXTRA HOURS: " + extra_hours + "\n" + "WORKED DAYS: " + worked_days;
		return message;
	}
	/**
	 * this method allows to return the information of the employee
	 * <b>Pre:</b> the object Employee exists<br>
	 * @return message a String that represents the information the employee
	 */
	public String getMessage2() {
		String message = "NAME: " + name + " " + last_name + ", " + "ID: " + id + ", " + "BASE SALARY: " + base_salary + ", " + "WORK AREA: " + work_area + ", " +  "EXTRA HOURS: " + extra_hours + ", " + "WORKED DAYS: " + worked_days +"\n";
		return message;
	}
	/**
	 * this method allows to compare two employees by the work's area
	 * <b>Pre:</b> the object Employee exists<br>
	 * @param f1 a Employee which will compare the current
	 * @return comparation a int that represents the value of the comparation
	 */
	@Override
	public int compareTo(Employee f1) {
		int comparation;
		if(work_area.compareTo(f1.getWorkArea())<0) {
			comparation = -1;
		}
		else if(work_area.compareTo(f1.getWorkArea())>0) {
			comparation = 1;
		}
		else {
			comparation = 0;
		}
		return comparation;
	}

}
