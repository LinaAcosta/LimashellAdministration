package model;

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
	public Administration() throws FileNotFoundException, ClassNotFoundException, IOException {
		employees = new ArrayList<>();
		load();
		
	}
	public Manager getManager() {
		return manager;
	}
	public List<Employee> getEmployees(){
		return employees;
	}
	public Employee getFirst() {
		return first;
	}
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
	public void saveEmployeeMonth() throws FileNotFoundException, IOException {
		
		File employee = new File(PATHSERIALIZABLE);
		
		ObjectOutputStream mySavior = new ObjectOutputStream(new FileOutputStream(employee));
		mySavior.writeObject(employee);
		mySavior.close();
	}
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
	public double calculatePayrollEmployees(Employee e) throws IOException {
		if(e.getNext()== null) {
			return e.calculatePayroll();
		}else {
			return e.calculatePayroll() + calculatePayrollEmployees(e.getNext());
		}
	}
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
	public Employee[] sortByArea() {
		int e = employees.size();
		Employee[] em = new Employee[e];
		for(int i = 0; i<em.length; i++) {
			em[i] = employees.get(i);
		}
		Arrays.sort(em);
		return em;
	}
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
	public int numberEmployees(Employee e) {
		if(e.getNext()== null) {
			return 1;
		}else {
			return 1 + numberEmployees(e.getNext());
		}
	}
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
	public Employee getFirstAdmi() {
		return first_admi;
	}
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
	public int calculateWorkedDays(Employee e) {
		if(e.getNext()== null) {
			return e.getWorkedDays();
		}else {
			return e.getWorkedDays() + calculateWorkedDays(e.getNext());
		}
	}
	public int calculateExtraHoursWorked(Employee e) {
		if(e.getNext()== null) {
			return e.getExtraHours();
		}else {
			return e.getExtraHours() + calculateExtraHoursWorked(e.getNext());
		}
	}
	
}
