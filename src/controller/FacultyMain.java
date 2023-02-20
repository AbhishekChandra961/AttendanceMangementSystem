package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.iFaculty;
import model.Faculty;
import service.FacultyImplements;
import util.InterfaceRegExFaculty;
import util.RegExImplementFaculty;

public class FacultyMain {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		iFaculty fobj = new FacultyImplements();
		int choice = 0;
		try {
		do {
			System.out.println("***********Faculty************");
			System.out.println("Enter 1 for Creating Faculty Account ");
			System.out.println("Enter 2 for Showing All Faculty Details");
			System.out.println("Enter 3 for Updating Excisting Faculty Account ");
			System.out.println("Enter 4 for Deleting Excisting Admin Acoount ");
			System.out.println("Enter 5 for Search By Mobile Number ");
			System.out.println("Enter 6 for Search By First Name ");
			System.out.println("Enter 7 for Search By Last Name ");
			System.out.println("Enter 8 for Search By Subject ");
			
			switch(sc.nextInt()){
			case 1:
				System.out.println("Creating Faculty : ");
				fobj.createFaculty(getFaculty());
				break;
			case 2:
				fobj.printAll();
				break;
			case 3:
				System.out.println("Enter the Mobile Number to Update : ");
				String mobileNumber = sc.next();
				fobj.updateFaculty(mobileNumber);
				break;
			case 4:
				System.out.println("Enter the Mobile Number to Delete");
				String mobileNumber1 = sc.next();
				fobj.delete(mobileNumber1);
				System.err.println("DELETED");
				break;
			case 5:
				System.out.println("Enter the Mobile Number to Search");
				String mobileNumber2 = sc.nextLine();
				fobj.searchByMobileNumber(mobileNumber2);
				break;
			case 6:
				System.out.println("Enter the First Name to Search");
				String firstName = sc.next();
				fobj.searchByFirstName(firstName);
				break;
			case 7:
				System.out.println("Enter the Last Name to Search");
				String lastName = sc.next();
				fobj.searchByLastName(lastName);
				break;
			case 8:
				System.out.println("Enter the Subject to Search");
				String subject = sc.next();
				fobj.searchBySubject(subject);
				break;
			default:
				System.err.println("*******INVALID ENTRY*******");
				break;
			}
			
			System.err.println("Enter 1 to continue and Else to terminate :");
			choice = sc.nextInt();
		}while(choice == 1);
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	private static Faculty getFaculty() {
		
		InterfaceRegExFaculty regexF = new RegExImplementFaculty();
		Faculty faculty = new Faculty();
		
		System.out.println("Enter the mobile Number : ");
		String mobileNumber = sc.next();
		while(!regexF.mobileNumber(mobileNumber)) {
			System.err.println("Invaild Number....Enter +CountryCode XXXXXXXXXX ");
			mobileNumber = sc.nextLine();
		}
		faculty.setMobileNumber(mobileNumber);
		
		System.out.println("Enter the First Name : ");
		String firstName = sc.next();
		while(!regexF.firstName(firstName)) {
			System.err.println("Invalid First Name....");
			System.err.println("First Name Most Start with Capital letter : ");
			firstName = sc.next();
		}
		faculty.setFirstName(firstName);
		
		System.out.println("Enter the Last Name : ");
		String lastName = sc.next();
		while(!regexF.lastName(lastName)){
			System.err.println("Invalid Last Name....");
			System.err.println("Last Name Most Start with Capital letter : ");
			lastName = sc.next();
		}
		faculty.setLastName(lastName);
		
		System.out.println("Enter the Roll Number : ");
		String rollNo = sc.next();
		faculty.setRollNo(rollNo);
		
		System.out.println("Enter the Standard : ");
		String standard = sc.next();
		faculty.setStandard(standard);
		
		System.out.println("Enter the Subject : ");
		String subject = sc.next();
		while(!regexF.lastName(subject)) {
			System.err.println("Subject most start with Cap ");
			subject = sc.next();
		}
		faculty.setSubject(subject);
		
		return faculty;
		
	}
}
