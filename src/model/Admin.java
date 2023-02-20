package model;

public class Admin {

	private String adminID;
	private String firstName;
	private String lastName;
	private String typeOfAdmin;
	private String UserName;
	private String password;
	/*
	public Admin(String adminID, String firstName, String lastName, String typeOfAdmin, String userName,
			String password) {
		super();
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.typeOfAdmin = typeOfAdmin;
		UserName = userName;
		this.password = password;
	}*/

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTypeOfAdmin() {
		return typeOfAdmin;
	}

	public void setTypeOfAdmin(String typeOfAdmin) {
		this.typeOfAdmin = typeOfAdmin;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
