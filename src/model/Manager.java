package model;

public class Manager {
	private String id;
	private String password;
	public Manager(String i, String p) {
		id = i;
		password = p;
	}
	public String getID() {
		return id;
	}
	public String getPassword() {
		return password;
	}

}
