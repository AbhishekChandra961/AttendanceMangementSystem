package service;

import java.util.Scanner;

import interfaces.iAdmin;
import model.Admin;

public class AdminImpelements implements iAdmin {

	private static Admin adminDetails[] = new Admin[10];
	Scanner sc = new Scanner(System.in);
	
	@Override
	public int create(Admin admin) {
		System.out.println("List of Admins :");
		int index = getIndexAdmin();
		adminDetails[index] = admin;
		//System.out.println(adminDetails[index]);
		System.out.println("Index : "+(index+1));
		return index;
	}

	private int getIndexAdmin() {
		
		for(int i=0; i<adminDetails.length; i++) {
			if(null==adminDetails[i]) {
				return i;
			}
		}
		return 0;
	}
	
	@Override
	public void update(String userName, String password) {
		int u = compareUserName(userName);
		int p = comparePassword(password);
		if(u!=-1 && p!=-1) {
			updateAdminDetails(adminDetails[u]);
		}else if(u==-1 && p==-1){
			System.err.println("INCORRECT USERNAME");
			System.err.println("INCORRECT PASSWORD");
		}else if(u==-1){
			System.err.println("INCORRECT USERNAME");
		}else if(p==-1) {
			System.err.println("INCORRECT PASSWORD");
		}
		
	}

	private void updateAdminDetails(Admin admin) {
		
		Admin con = new Admin();
		int choiceForUpdate,continueOption=1;
		do {
			System.out.println("********Options to Update*********");
			System.out.println("1 for First Name");
			System.out.println("2 for Last Name");
			System.out.println("3 for Admin ID");
			System.out.println("4 for Type of Admin");
			System.out.println("5 for User Name");
			System.out.println("6 for Password");
			choiceForUpdate = sc.nextInt();
			
			switch(choiceForUpdate) {
			case 1:
				System.out.print("Enter new First Name : ");
				admin.setFirstName(sc.next());
				break;
			case 2:
				System.out.print("Enter new Last Name : ");
				admin.setLastName(sc.next());
				break;
			case 3:
				System.out.print("Enter new Admin ID : ");
				admin.setAdminID(sc.next());
				break;
			case 4:
				System.out.print("Enter new Type of Admin : ");
				admin.setTypeOfAdmin(sc.next());
				break;
			case 5:
				System.out.println("Enter new User Name : ");
				admin.setUserName(sc.next());
				break;
			case 6:
				System.out.println("Enter new Password : ");
				admin.setPassword(sc.next());
				break;
			default:
				System.err.println("********INVALID INPUT********");
				break;
			}
			System.out.println("Press 1 to Update Another Fields");
			System.out.println("Press 0 to EXIT the Menu");
			continueOption = sc.nextInt();
			
		}while(continueOption!=0);
	}
	
	@Override
	public void showAllAdmin() {
		System.out.println("*******ALL ADMINS*******");
		for(int i=0;i<adminDetails.length;i++) {
			displayAdminDetails(adminDetails[i]);
		}
		
	}
	
	@Override
	public void deleteAdmin(String userName,String password) {
		int u = compareUserName(userName);
		int p = comparePassword(password);
		if(u!=-1 && p!=-1) {
			adminDetails[u]=null;
			System.out.println("Deleted");
		}else if(u==-1 && p==-1){
			System.err.println("INCORRECT USERNAME");
			System.err.println("INCORRECT PASSWORD");
		}else if(u==-1){
			System.err.println("INCORRECT USERNAME");
		}else if(p==-1) {
			System.err.println("INCORRECT PASSWORD");
		}
		
	}
	
	@Override
	public void searchByID(String adminId) {
		int a = compareAdminID(adminId);
		if(a!=-1) {
			displayAdminDetails(adminDetails[a]);
		}else{
			System.err.println("INCORRECT ADMIN ID");
		}
		
	}

	@Override
	public void searchByFirstName(String firstName) {
		int f = compareFirstName(firstName);
		if(f!=-1) {
			displayAdminDetails(adminDetails[f]);
		}else{
			System.err.println("INCORRECT FIRST NAME");
		}
	}

	@Override
	public void searchByLastName(String lastName) {
		int l = compareLastName(lastName);
		if(l!=-1) {
			displayAdminDetails(adminDetails[l]);
		}else{
			System.err.println("INCORRECT LAST NAME");
		}
		
	}

	private void displayAdminDetails(Admin admin) {
		if(admin != null) {
			System.out.println("********Admin Details*********");
			System.out.println("First Name = "+admin.getFirstName());
			System.out.println("Last Name = "+admin.getLastName());
			System.out.println("Admin ID = "+admin.getAdminID());
			System.out.println("Type of Admin = "+admin.getTypeOfAdmin());
			System.out.println("User Name = "+admin.getUserName());
			System.out.print("Password = ");
			for(int i=0;i<admin.getPassword().length();i++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	private int compareUserName(String userName) {
		for(int i=0;i<adminDetails.length;i++) {
			if(null!=adminDetails[i] && userName.equals(adminDetails[i].getUserName())) {
				return i;
			}
		}
		return -1;
	}
	
	private int comparePassword(String password) {
		for(int i=0;i<adminDetails.length; i++) {
			if(null!=adminDetails[i] && password.equals(adminDetails[i].getPassword())){
				return i;
			}
		}
		return -1;
	}

	private int compareAdminID(String adminID) {
		for(int i=0;i<adminDetails.length; i++) {
			if(null!=adminDetails[i] && adminID.equalsIgnoreCase(adminDetails[i].getAdminID())){
				return i;
			}
		}
		return -1;
	}

	private int compareFirstName(String firstName) {
		for(int i=0;i<adminDetails.length; i++) {
			if(null!=adminDetails[i] && firstName.equalsIgnoreCase(adminDetails[i].getFirstName())){
				return i;
			}
		}
		return -1;
	}

	private int compareLastName(String lastName) {
		for(int i=0;i<adminDetails.length; i++) {
			if(null!=adminDetails[i] && lastName.equalsIgnoreCase(adminDetails[i].getLastName())){
				return i;
			}
		}
		return -1;
	}
	
}
