package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExImplementAdmin implements InterfaceRegeExAdmin{

	@Override
	public boolean firstName(String firstName) {
		Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]*$");
		Matcher matcher = pattern.matcher(firstName);
		return matcher.find();
	}

	@Override
	public boolean lastName(String lastName) {
		Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]*$");
		Matcher matcher = pattern.matcher(lastName);
		return matcher.find();
	}

	@Override
	public boolean adminID(String adminID) {
		Pattern pattern = Pattern.compile("^[0-9]{4}$");
		Matcher matcher = pattern.matcher(adminID);
		return matcher.find();
	}

	@Override
	public boolean typeOfAdmin(String typeOfAdmin) {
		Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]*$");
		Matcher matcher = pattern.matcher(typeOfAdmin);
		return matcher.find();
	}

	@Override
	public boolean userName(String userName) {
		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[@#$%^&+=]).+$");
		Matcher matcher = pattern.matcher(userName);
		return matcher.find();
	}

	@Override
	public boolean password(String password) {
		Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");
		Matcher matcher = pattern.matcher(password);
		return matcher.find();
	}

	
}
