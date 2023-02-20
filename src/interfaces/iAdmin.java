package interfaces;

import model.Admin;

public interface iAdmin {

	int create(Admin admin);
	void update(String userName, String password);
	void showAllAdmin();
	void deleteAdmin(String userName, String password);
	void searchByID(String adminId);
	void searchByFirstName(String firstName);
	void searchByLastName(String lastName);
}
