package controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.iAdmin;
import model.Admin;
import service.AdminImpelements;
import util.InterfaceRegeExAdmin;
import util.RegExImplementAdmin;

public class AdminMain {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		iAdmin obj = new AdminImpelements();
		
		int choice =0;
		try {
		do {
			try {
			System.out.println("***********Admin*************");
			System.out.println("Enter 1 for Creating Admin Account ");
			System.out.println("Enter 2 for Showing All Admin Details");
			System.out.println("Enter 3 for Updating Excisting Admin Account ");
			System.out.println("Enter 4 for Deleting Excisting Admin Acoount ");
			System.out.println("Enter 5 for Search By Admin ID ");
			System.out.println("Enter 6 for Search By First Name ");
			System.out.println("Enter 7 for Search By Last Name ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Creating Admin : ");
				Admin admin = getAdmin();
				int index1 = obj.create(admin);
				break;
			case 2:
				obj.showAllAdmin();
				break;
			case 3:
				System.out.println("For Updating Admin Details : ");
				System.out.print("Enter the User Name : ");
				String userName = sc.next();
				System.out.print("Emter the Password : ");
				String password = sc.next();
				obj.update(userName, password);
				break;
			case 4:
				System.out.println("For Delete Admin DEtails : ");
				System.out.print("Enter the User Name : ");
				String userName1 = sc.next();
				System.out.print("Emter the Password : ");
				String password1 = sc.next();
				obj.deleteAdmin(userName1, password1);
				break;
			case 5:
				System.out.print("Enter the Admin ID : ");
				String adminID = sc.next();
				obj.searchByID(adminID);
				break;
			case 6:
				System.out.print("Enter the First Name : ");
				String firstName = sc.next();
				obj.searchByFirstName(firstName);
				break;
			case 7:
				System.out.print("Enter the Last Name : ");
				String lastName = sc.next();
				obj.searchByLastName(lastName);
				break;
				
			default:
				System.err.println("INVALID ENTRY");
				break;
				
			}
			
			System.out.print("Enter 1 to Continue :");
			choice = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println(e);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		}while(choice==1);
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.err.println(e);
		}
		
	}
	
	private static Admin getAdmin() {
		InterfaceRegeExAdmin regex = new RegExImplementAdmin();
		
		Admin admin = new Admin();
		System.out.print("Enter the First Name : ");
		String firstName = sc.next();
		while(!regex.firstName(firstName)) {
			System.err.println("Invalid First Name....");
			System.err.println("First Name Most Start with Capital letter : ");
			firstName = sc.next();
		}
		admin.setFirstName(firstName);
		
		System.out.print("Enter the Last Name : ");
		String lastName = sc.next();
		while(!regex.lastName(lastName)) {
			System.err.println("Invalid Last Name....");
			System.err.println("Last Name Most Start with Capital letter : ");
			lastName = sc.next();
		}
		admin.setLastName(lastName);
		
		System.out.print("Enter the Admin ID : ");
		String adminId = sc.next();
		while(!regex.adminID(adminId)) {
			System.err.println("Invalid Admin ID....");
			System.err.println("Admin ID most be numeric and 4 digits : ");
			adminId = sc.next();
		}
		admin.setAdminID(adminId);
		
		System.out.print("Enter the Type of Admin : ");
		String typeOfAdmin = sc.next();
		while(!regex.typeOfAdmin(typeOfAdmin)) {
			System.err.println("Invalid Type of Admin....");
			System.err.println("Type of Admin most Start with Capital letter : ");
			typeOfAdmin = sc.next();
		}
		admin.setTypeOfAdmin(typeOfAdmin);
		
		System.out.print("Enter the User Name : ");
		String userName = sc.next();
		while(!regex.userName(userName)) {
			System.err.println("Invalid UserName....");
			System.err.println("UserName most contain atleast 1 Number 1 Special character and no space : ");
			userName = sc.next();
		}
		admin.setUserName(userName);
		
		System.out.print("Enter the Password : ");
		String password = sc.next();
		while(!regex.password(password)) {
			System.err.println("Invalid Password....");
			System.err.println("Minimum 8 Characters");
			System.err.println("Atleast 1 UpperCase");
			System.err.println("Atleast 1 Numeric Number");
			System.err.println("Has exactly 1 Special Character");
			password = sc.next();
		}
		admin.setPassword(password);
		
		return admin;
		
	}
	
}
