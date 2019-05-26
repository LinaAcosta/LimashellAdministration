package model;
/**
 * This class manage the necessary attributes and methods to manage the administrative platform
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import customExceptions.AreaNotFoundException;
import customExceptions.IncorrectInformationException;
import customExceptions.NotInformationException;

public class Administration{
	//Attributes & constants
	private Manager manager;
	private Employee root;
	private Employee first;
	private Employee first_admi;
	private List<Employee> employees;
	private Employee root_it;
	private Employee employee_month;
	public final static String PATH_FILE = "data/manager's_Info";
	public final static String PATH_FILE2 = "data/employees";
	private final static String PATHSERIALIZABLE = "data/employeeMonth";
	//Constructor method
	/**
	 * <b>Administration Constructor</b><br>
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employee of the month.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 * @throws FileNotFoundException in the case that the recovering file of the employee of the month does not exists.
	 */
	public Administration() throws FileNotFoundException, ClassNotFoundException, IOException {
		employees = new ArrayList<>();
		load();
		
	}
	/**
	 * This method returns the Manager that is created by reading and archive text "manager's_info" <br>
	 * @return the Manager of the company
	 */
	public Manager getManager() {
		return manager;
	}
	/**
	 * This method returns the list of the employees that is created by reading and archive text "employees" <br>
	 * @return the list of employees of the company
	 */
	public List<Employee> getEmployees(){
		return employees;
	}
	/**
	 * This method returns the first employee that is created by reading and archive text "employees" <br>
	 * @return the first employee that is created
	 */
	public Employee getFirst() {
		return first;
	}
	/**
	 * This method allows to import and read a file that contains the respective information of the Manager of the company.<br>
	 * <b>Pre:</b> The path of the file exists
	 * <b>Pre:</b> The file exists<br>
	 * <b>Pos:</b> The file had been readed and the information within it has been used to create the manager of the company<br>
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public void loadManagerInformation() throws IOException {
		File archive = new File(PATH_FILE);
		FileReader reader = new FileReader(archive);
		BufferedReader br = new BufferedReader(reader);
		String ln = br.readLine();
		while(ln != null) {
			String[] parts = ln.split(";");
			String id = parts[0];
			String password = parts[1];
			manager = new Manager(id, password);
			ln = br.readLine();
		}
		reader.close();
		br.close();
	}
	/**
	 * This method allows to recover the employee of the month when the manager choose it<br>
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employee of the month.
	 * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 * @throws FileNotFoundException in the case that the recovering file of the employee of the month does not exists.
	 */
	public void load() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		File employee = new File(PATHSERIALIZABLE);
		if(employee.exists()) {
			ObjectInputStream myLoader = new ObjectInputStream(new FileInputStream(employee));
			employee_month =  (Employee) myLoader.readObject();
			myLoader.close();
		}
		else {
			employee_month = null;
		}
	}
	/**
	 * This method allows to save the employee of the month that is choosing for the manager of the company<br>
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employee of the month. 
	 * @throws FileNotFoundException in the case that the recovering file of the employee of the month does not exists
	 */
	public void saveEmployeeMonth() throws FileNotFoundException, IOException {
		
		File employee = new File(PATHSERIALIZABLE);
		
		ObjectOutputStream mySavior = new ObjectOutputStream(new FileOutputStream(employee));
		mySavior.writeObject(employee);
		mySavior.close();
	}
	/**
	 * This method searchs an id inside the linked list of employees of the company.<br>
	 * @param id the id associated to the employee of the month
	 * @return an Employee that represents the employee of the month
	 * @throws IOException in the case of a problem reading or finding the file that recovers the employee of the month.
	 */
	public Employee searchEmployeeMonth(int id) throws IOException {
		loadEmployees();
		Employee current = first;
		while(current != null) {
			if(id == current.getID()) {
				employee_month = current;
				current = null;
			}else {
				current = current.getNext();
			}
		}
		return employee_month;
	}
	/**
	 * This method allows to import and read a file that contains the respective information of the all the employees of the company.<br>
	 * <b>Pre:</b> The path of the file exists
	 * <b>Pre:</b> The file exists<br>
	 * <b>Pos:</b> The file had been readed and the information within it has been used to create the employees of the company<br>
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public void loadEmployees() throws IOException {
		File archive = new File(PATH_FILE2);
		FileReader reader = new FileReader(archive);
		BufferedReader br = new BufferedReader(reader);
		String ln = br.readLine();
		while(ln != null) {
			String[] parts = ln.split(";");
			String name = parts[0];
			String last_name = parts[1];
			int id = Integer.parseInt(parts[2]);
			double base_salary = Double.parseDouble(parts[3]);
			String work_area = parts[4];
		    int extra_hours = Integer.parseInt(parts[5]);
		    int worked_days = Integer.parseInt(parts[6]);
			Employee a = new Employee(name,last_name,id,base_salary,work_area,extra_hours,worked_days);
			employees.add(a);
			if(root == null) {
				root = a;
				System.out.println(a.getMessage());
			}
			else {
				Employee current = root;
				boolean added = false;
				while(!added) {
					if(a.getID()>root.getID()) {
						if(current.getRight() == null) {
							current.setRight(a);
							System.out.println(a.getMessage());
							added = true;
						}else {
							current = current.getRight();
						}
					}else {
						if(current.getLeft()== null) {
							current.setLeft(a);
							System.out.println(a.getMessage());
							added = true;
						}else {
							current = current.getLeft();
						}
					}
				}
			}
			if(first == null) {
				first = a;
			}else {
				Employee current = first;
				while(current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(a);
			}
			ln = br.readLine();
		}
		reader.close();
		br.close();
		
	}
	/**
	 * This method calculate the total value to be paid for all the employees of the company<br>
	 * <b>Pre:</b> the linked list of employees exist.<br>
	 * <b>Post:</b> the value to be paid is calculated. <br> 
	 * @param a Employee that represents the first employee of the linked list
	 * @return a double that represents the total value to be paid for all the employees
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public double calculatePayrollEmployees(Employee e) throws IOException {
		if(e.getNext()== null) {
			return e.calculatePayroll();
		}else {
			return e.calculatePayroll() + calculatePayrollEmployees(e.getNext());
		}
	}
	/**
	 * This method searchs an id inside the binary tree associated with the employees of the company.<br>
	 * @param id the id associated to the employee that needs to be found
	 * @return an Employee that represents the employee that was found
	 * @throws NotInformationException in the case that the param not exists.
	 */
	public Employee searchEmployee(String ide) throws NotInformationException {
		int id = Integer.parseInt(ide);
		Employee a = null;
		Employee current = root;
		if(ide == null) {
			throw new NotInformationException(ide,ide);
		}
		else {
			while(current != null) {
				if(id == current.getID()) {
					a = current;
					current = null;
				}else if(id >= current.getID()) {
					current = current.getRight();
				}else {
					current = current.getLeft();
				}
			}
		}
		return a;
	}
	/**
	 * This method allows the entry of the manager to the administrative platform.<br>
	 * @param id the id associated to the manager 
	 * @param password the password associated to the manager 
	 * @return an String that indicates whether or not can enter the system
	 * @throws NotInformationException in the case that the param not exists.
	 * @throws IncorrectInformationException in the case that the param are differents to the information of the manager.
	 */
	public String enterSystem(String i, String p) throws NotInformationException, IncorrectInformationException {
		String message = "";
		String id = ""; 
		String password = ""; 
		if(i == null) {
			throw new NotInformationException(id, password);
		}else if(p == null){
				throw new NotInformationException(id, password);
		}
		else {
			id = i;
			password = p;
			if(id.equals(manager.getID()) == true) {
				if(password.equals(manager.getPassword()) == true) {
					message = "Welcome!";
				}
				else {
					throw new IncorrectInformationException(i, p);
				}
			}else {
				throw new IncorrectInformationException(i, p);
			}
		return message;
	    }
	}
	 /**
     * This method sort the employees by its last name in an lexicographycal order.<br>
     * <b>Pre:</b> the list of employees exist.<br>
	 * <b>Post:</b> the list of employees is sort by last name. <br> 
	 * @return a array that represents the employees of the company sorting by last name
     */
	public Employee[] sortByLastName() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		Comparator<Employee> employeeComparator = new EmployeeLastNameComparator();
		Arrays.sort(em,employeeComparator);
		return em;
	}
	/**
     * This method sort the employees by name in an lexicographycal order.<br>
     * <b>Pre:</b> the list of employees exist.<br>
	 * <b>Post:</b> the list of employees is sort by name. <br> 
	 * @return a array that represents the employees of the company sorting by name
     */
	public Employee[] sortByName() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		Comparator<Employee> employeeComparator = new EmployeeNameComparator();
		Arrays.sort(em,employeeComparator);
		return em;
	}
	/**
     * This method sort the employees by id from lowest to highest.<br>
     * <b>Pre:</b> the list of employees exist.<br>
	 * <b>Post:</b> the list of employees is sort by id. <br> 
	 * @return a array that represents the employees of the company sorting by id
     */
	public Employee[] sortByID() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		int i;
    	int k;
    	int p;
    	Employee buffer;
    	int limit = em.length-1;
        for(k = 0; k < limit; k++){
            p = k;
            for(i = k+1; i <= limit; i++){
            	if(em[i].getID()<em[p].getID()) {
            		p = i;
            	}
            }
            if(p != k){
                buffer = em[p];
                em[p] = em[k];
                em[k] = buffer;
            }
        }
        return em;
    }
	/**
     * This method sort the employees by extra hours worked from lowest to highest.<br>
     * <b>Pre:</b> the list of employees exist.<br>
	 * <b>Post:</b> the list of employees is sort by extra hours worked. <br> 
	 * @return a array that represents the employees of the company sorting by extra hours worked
     */
	public Employee[] sortByHours() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		for (int i=1; i < em.length; i++) {
	         Employee aux = em[i];
	         int j;
	         for (j=i-1; j >= 0 && em[j].getExtraHours() > aux.getExtraHours(); j--){
	              em[j+1] = em[j];
	          }
	         em[j+1] = aux;
	    }
		return em;
   	   
	}
	/**
     * This method sort the employees by salary from lowest to highest.<br>
     * <b>Pre:</b> the list of employees exist.<br>
	 * <b>Post:</b> the list of employees is sort by salary. <br> 
	 * @return a array that represents the employees of the company sorting by salary
     */
	public Employee[] sortBySalary() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		Employee temp;
        for(int i=1;i < em.length;i++){
            for (int j=0 ; j < em.length- 1; j++){
                if (em[j].getBaseSalary() > em[j+1].getBaseSalary()){
                    temp = em[j];
                    em[j] = em[j+1];
                    em[j+1] = temp;
                }
            }
        }  
		return em;
	}
	/**
     * This method sort the employees by area's work in an lexicographycal order.<br>
     * <b>Pre:</b> the list of employees exist.<br>
	 * <b>Post:</b> the list of employees is sort by area's work. <br> 
	 * @return a array that represents the employees of the company sorting by area's work
     */
	public Employee[] sortByArea() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		Arrays.sort(em);
		return em;
	}
	/**
     * This method sort the employees by days worked from lowest to highest.<br>
     * <b>Pre:</b> the list of employees exist.<br>
	 * <b>Post:</b> the list of employees is sort by days worked. <br> 
	 * @return a array that represents the employees of the company sorting by days worked
     */
	public Employee[] sortByDays() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		Employee temp;
        for(int i=1;i < em.length;i++){
            for (int j=0 ; j < em.length- 1; j++){
                if (em[j].getWorkedDays() > em[j+1].getWorkedDays()){
                    temp = em[j];
                    em[j] = em[j+1];
                    em[j+1] = temp;
                }
            }
        }  
		return em;
	}

	/**
	 * This method search a employee of the company using Binary Searching
	 * @param id the id of the employee that needs be found
	 * @return a Employee that represents the employee found
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public Employee searchByID(int id) throws IOException {
		loadEmployees();
		boolean found = false;
		int pos = 0;
		int low = 0;
		int high = employees.size()-1;
		
		while(low<=high && !found) {
			int mid = (low+high)/2;
			if(employees.get(mid).getID() == id) {
				pos = mid;
				found = true;
			}
			else if(employees.get(mid).getID()>id) {
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return employees.get(pos);
	}
	/**
	 * This method calculate the total number of employees that has the company<br>
	 * <b>Pre:</b> the linked list of employees exist.<br>
	 * <b>Post:</b> the number of employees is calculated. <br> 
	 * @param a Employee that represents the first employee of the linked list
	 * @return a int that represents the total number of employees 
	 */
	public int numberEmployees(Employee e) {
		if(e.getNext()== null) {
			return 1;
		}else {
			return 1 + numberEmployees(e.getNext());
		}
	}
	/**
	 * This method search a employee of the company using Binary Searching
	 * @param salary the salary of the employee that needs be found
	 * @return a Employee that represents the employee found
	 * @throws IOException in the case that the file cannot be imported or readed.
	 */
	public Employee searchSalary(double salary) throws IOException {
		loadEmployees();
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		boolean stop = false;
		int pos = 0;
    	int low = 0;
    	int hight = em.length - 1;
    	while(low <= hight && !stop) {
    		int mid = (low+hight)/2;
    		if(em[mid].getBaseSalary() == salary) {
    			stop = true;
    			pos = mid;
    		}
    		else if(salary < em[mid].getBaseSalary()) {
    			hight = mid -1;
    		}
    		else {
    			low = mid + 1;
    		}
	    }
		return em[pos];
	}
	/**
	 * This method returns the first employee of the administrative area
	 * @return an Employee that represents the first employee created of the administrative area
	 */
	public Employee getFirstAdmi() {
		return first_admi;
	}
	/**
	 * this method allows to return a message that contains the information of the employees that work in the administrative area
	 * <b>Pre:</b> the list of employees exists<br>
	 * <b>Pre:</b> the first employee of the administrative area exists<br>
	 * @return  a String that represents information of the employees that work in the administrative area
	 * @throws IOException in the case that the file cannot be imported or readed.
	 * @throws AreaNotFoundException in the case that the area was not found
	 */
	public String admiArea() throws IOException, AreaNotFoundException {
		loadEmployees();
		String message = null;
		for(int i = 0; i<employees.size(); i++) {
			if(employees.get(i).getWorkArea().equals("ADMINISTRATION") == true) {
				if(first_admi == null) {
					first_admi = employees.get(i);
					message += employees.get(i).getMessage2();
				}else {
					Employee current = first_admi;
					while(current.getNext()!= null) {
						current = current.getNext();
					}
					current.setNext(employees.get(i));
					message += employees.get(i).getMessage2();
				}
			}
		}
		if(message != null) {
			return message;
		}else {
			throw new AreaNotFoundException("ADMINISTRATION");
		}
	}
	/**
	 * this method allows to return a message that contains the information of the employees that work in the plant area
	 * <b>Pre:</b> the list of employees exists<br>
	 * <b>Pre:</b> the first employee of the plant area exists<br>
	 * @return  a String that represents information of the employees that work in the plant area
	 * @throws IOException in the case that the file cannot be imported or readed.
	 * @throws AreaNotFoundException in the case that the area was not found
	 */
	public String PlantArea() throws IOException, AreaNotFoundException {
		loadEmployees();
		String message = null;
		for(int i = 0; i<employees.size(); i++) {
			if(employees.get(i).getWorkArea().equals("PLANT") == true) {
				if(first_admi == null) {
					first_admi = employees.get(i);
					message += employees.get(i).getMessage2();
				}else {
					Employee current = first_admi;
					while(current.getNext()!= null) {
						current = current.getNext();
					}
					current.setNext(employees.get(i));
					message += employees.get(i).getMessage2();
				}
			}
		}
		if(message != null) {
			return message;
		}else {
			throw new AreaNotFoundException("PLANT");
		}
	}
	/**
	 * this method allows to return a message that contains the information of the employees that work in the finance area
	 * <b>Pre:</b> the list of employees exists<br>
	 * <b>Pre:</b> the first employee of the finance area exists<br>
	 * @return  a String that represents information of the employees that work in the finance area
	 * @throws IOException in the case that the file cannot be imported or readed.
	 * @throws AreaNotFoundException in the case that the area was not found
	 */
	public String FinanceArea() throws IOException, AreaNotFoundException {
		loadEmployees();
		String message = null;
		for(int i = 0; i<employees.size(); i++) {
			if(employees.get(i).getWorkArea().equals("FINANCE") == true) {
				if(first_admi == null) {
					first_admi = employees.get(i);
					message += employees.get(i).getMessage2();
				}else {
					Employee current = first_admi;
					while(current.getNext()!= null) {
						current = current.getNext();
					}
					current.setNext(employees.get(i));
					message += employees.get(i).getMessage2();
				}
			}
		}
		if(message != null) {
			return message;
		}else {
			throw new AreaNotFoundException("PLANT");
		}
	}
	/**
	 * this method allows to return a message that contains the information of the employees that work in the adversiting area
	 * <b>Pre:</b> the list of employees exists<br>
	 * <b>Pre:</b> the first employee of the adversiting area exists<br>
	 * @return  a String that represents information of the employees that work in the adversiting area
	 * @throws IOException in the case that the file cannot be imported or readed.
	 * @throws AreaNotFoundException in the case that the area was not found
	 */
	public String adverArea() throws IOException, AreaNotFoundException {
		loadEmployees();
		String message = null;
		for(int i = 0; i<employees.size(); i++) {
			if(employees.get(i).getWorkArea().equals("ADVERTISING") == true) {
				if(first_admi == null) {
					first_admi = employees.get(i);
					message += employees.get(i).getMessage2();
				}else {
					Employee current = first_admi;
					while(current.getNext()!= null) {
						current = current.getNext();
					}
					current.setNext(employees.get(i));
					message += employees.get(i).getMessage2();
				}
			}
		}
		if(message != null) {
			return message;
		}else {
			throw new AreaNotFoundException("PLANT");
		}
	}
	/**
	 * this method allows to return a message that contains the information of the employees that work in the IT area
	 * <b>Pre:</b> the list of employees exists<br>
	 * <b>Pre:</b> the root employee of the IT area exists<br>
	 * @return  a String that represents information of the employees that work in the IT area
	 * @throws IOException in the case that the file cannot be imported or readed.
	 * @throws AreaNotFoundException in the case that the area was not found
	 */
	public String ITArea() throws IOException, AreaNotFoundException {
		loadEmployees();
		String message = null;
		for(int i = 0; i<employees.size(); i++) {
			if(employees.get(i).getWorkArea().equals("IT") == true) {
				if(root_it == null) {
					root_it = employees.get(i);
					message += employees.get(i).getMessage2();
				}else {
					Employee current = root_it;
					boolean added = false;
					while(!added) {
						if(employees.get(i).getID()>root_it.getID()) {
							if(current.getRight() == null) {
								current.setRight(employees.get(i));
								message += employees.get(i).getMessage2();
								added = true;
							}else {
								current = current.getRight();
							}
						}else {
							if(current.getLeft()== null) {
								current.setLeft(employees.get(i));
								message += employees.get(i).getMessage2();
								added = true;
							}else {
								current = current.getLeft();
							}
						}
					}
				}
			}
		}
		if(message != null) {
			return message;
		}else {
			throw new AreaNotFoundException("PLANT");
		}
	}
	/**
	 * This method calculate the total days worked by the employees<br>
	 * <b>Pre:</b> the linked list of employees exist.<br>
	 * <b>Post:</b> the worked days is calculated. <br> 
	 * @param a Employee that represents the first employee of the linked list
	 * @return a int that represents the total days worked by the employees 
	 */
	public int calculateWorkedDays(Employee e) {
		if(e.getNext()== null) {
			return e.getWorkedDays();
		}else {
			return e.getWorkedDays() + calculateWorkedDays(e.getNext());
		}
	}
	/**
	 * This method calculate the total extra hours worked by the employees<br>
	 * <b>Pre:</b> the linked list of employees exist.<br>
	 * <b>Post:</b> the total extra hours worked is calculated. <br> 
	 * @param a Employee that represents the first employee of the linked list
	 * @return a int that represents the total extra hours worked by the employees 
	 */
	public int calculateExtraHoursWorked(Employee e) {
		if(e.getNext()== null) {
			return e.getExtraHours();
		}else {
			return e.getExtraHours() + calculateExtraHoursWorked(e.getNext());
		}
	}
	
}
