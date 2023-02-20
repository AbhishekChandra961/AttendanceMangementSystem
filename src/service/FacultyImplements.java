package service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import interfaces.iFaculty;
import model.Faculty;

public class FacultyImplements implements iFaculty {

	public static ArrayList<Faculty> facultyDetails = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void createFaculty(Faculty faculty) {
		facultyDetails.add(faculty);
	}
	
	@Override
	public void updateFaculty(String mobileNumber) {
		
		facultyDetails.stream()
			.filter(data->data.getMobileNumber().contains(mobileNumber))
			.forEach(i->updateOptions(i));
		
	}

	private void updateOptions(Faculty faculty) {
		int option =0;
		int choiceForUpdate,continueOption=1;
		do {
			System.out.println("********Options to Update*********");
			System.out.println("1 for First Name");
			System.out.println("2 for Last Name");
			System.out.println("3 for Mobile Number");
			System.out.println("4 for Roll Number");
			System.out.println("5 for Standard");
			System.out.println("6 for Subject");
			choiceForUpdate = sc.nextInt();
			
			switch(choiceForUpdate) {
			case 1:
				System.out.print("Enter new First Name : ");
				faculty.setFirstName(sc.next());
				break;
			case 2:
				System.out.print("Enter new Last Name : ");
				faculty.setLastName(sc.next());
				break;
			case 3:
				System.out.print("Enter new Mobile Number : ");
				faculty.setMobileNumber(sc.next());
				break;
			case 4:
				System.out.print("Enter new Roll Number : ");
				faculty.setRollNo(sc.next());
				break;
			case 5:
				System.out.println("Enter new Standard : ");
				faculty.setStandard(sc.next());
				break;
			case 6:
				System.out.println("Enter new Subject : ");
				faculty.setSubject(sc.next());
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
	public void searchByMobileNumber(String mobileNumber) {
		facultyDetails.stream()
			.filter(data->data.getMobileNumber().contains(mobileNumber))
			.forEach(data->displayFacultyDetails(data));
		
	}

	@Override
	public void searchByFirstName(String firstName) {
		facultyDetails.stream()
		.filter(data->data.getFirstName().contains(firstName))
		.forEach(data->displayFacultyDetails(data));
		
	}

	@Override
	public void searchByLastName(String lastName) {
		facultyDetails.stream()
		.filter(data->data.getLastName().contains(lastName))
		.forEach(data->displayFacultyDetails(data));
		
	}

	@Override
	public void searchBySubject(String Subject) {
		facultyDetails.stream()
		.filter(data->data.getSubject().contains(Subject))
		.forEach(data->displayFacultyDetails(data));
		
	}

	@Override
	public void printAll() {
		System.out.println("*******ALL FACULTY********");
		for(int i=0;i<facultyDetails.size();i++) {
			displayFacultyDetails(facultyDetails.get(i));
		}
	}
	
	private void displayFacultyDetails(Faculty faculty) {
		if(null!=faculty) {
			System.out.println("********Admin Details*********");
			System.out.println("First Name = "+faculty.getFirstName());
			System.out.println("Last Name = "+faculty.getLastName());
			System.out.println("Roll No = "+faculty.getRollNo());
			System.out.println("Standard = "+faculty.getStandard());
			System.out.println("Subject = "+faculty.getSubject());
			System.out.println("Mobile Number = "+faculty.getMobileNumber());
		}
	}

	@Override
	public void delete(String mobileNumber) {
		facultyDetails.removeAll(facultyDetails.stream()
				.filter(data->data.getMobileNumber()
						.contains(mobileNumber)).collect(Collectors.toList()));
	}
}
