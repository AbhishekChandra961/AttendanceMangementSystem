package interfaces;

import model.Faculty;

public interface iFaculty {

	void createFaculty(Faculty faculty);
	void updateFaculty(String mobileNumber);
	void delete(String mobileNumber);
	void searchByMobileNumber(String mobileNumber);
	void searchByFirstName(String firstName);
	void searchByLastName(String lastName);
	void searchBySubject(String Subject);
	void printAll();
	
}
