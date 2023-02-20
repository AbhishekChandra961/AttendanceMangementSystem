package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExImplementFaculty implements InterfaceRegExFaculty {

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
	public boolean mobileNumber(String mobileNumber) {
		Pattern pattern = Pattern.compile("^[+][1-9]{1,2}[\s][6-9][1-9]{9}$");
		Matcher matcher = pattern.matcher(mobileNumber);
		return matcher.find();
	}
/*
	@Override
	public boolean standard(String standard) {
		Pattern pattern = Pattern.compile("^[1-9]{1}$");
		Matcher matcher = pattern.matcher(standard);
		return matcher.find();
	}*/

	@Override
	public boolean subject(String subject) {
		Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]*$");
		Matcher matcher = pattern.matcher(subject);
		return matcher.find();
	}
	/*
	@Override
	public boolean rollNo(String rollNo) {
		
		Pattern pattern = Pattern.compile("^$");
		Matcher matcher = pattern.matcher(rollNo);
		return matcher.find();
		
	}*/
	
	

}
