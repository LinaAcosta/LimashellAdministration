package model;

public class Employee implements Comparable<Employee>{
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
	public Employee(String n, String l, int i, double b, String w, int e, int wd) {
		name = n;
		id = i;
		last_name = l;
		base_salary = b;
		work_area = w;
		extra_hours = e;
		worked_days = wd;
	}
	public Employee getNext() {
		return next;
	}
	public void setNext(Employee e) {
		next = e;
	}
	public Employee getRight() {
		return right;
	}
	public Employee getLeft() {
		return left;
	}
	public void setRight(Employee e) {
		right = e;
	}
	public void setLeft(Employee e) {
		left = e;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
	public String getLastName() {
		return last_name;
	}
	public double getBaseSalary() {
		return base_salary;
	}
	public String getWorkArea() {
		return work_area;
	}
	public int getExtraHours() {
		return extra_hours;
	}
	public int getWorkedDays() {
		return worked_days;
	}
	public double calculatePayroll() {
		double payroll = 0;
		double totalAcrued = ((base_salary/30)*worked_days) + (extra_hours*4313);
		double deductions = 2*(totalAcrued*0.04);
		payroll = totalAcrued - deductions;
		return payroll;
	}
	public String getMessage() {
		String message = "EMPLOYEE" + "\n" + "NAME: " + name + " " + last_name + "\n" + "ID: " + id + "\n" + "BASE SALARY: " + base_salary + "\n" + "WORK AREA: " + work_area + "\n" +  "EXTRA HOURS: " + extra_hours + "\n" + "WORKED DAYS: " + worked_days;
		return message;
	}
	public String getMessage2() {
		String message = "NAME: " + name + " " + last_name + ", " + "ID: " + id + ", " + "BASE SALARY: " + base_salary + ", " + "WORK AREA: " + work_area + ", " +  "EXTRA HOURS: " + extra_hours + ", " + "WORKED DAYS: " + worked_days +"\n";
		return message;
	}
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
