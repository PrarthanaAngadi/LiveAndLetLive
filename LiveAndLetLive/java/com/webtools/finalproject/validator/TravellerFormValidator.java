package com.webtools.finalproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webtools.finalproject.dao.TravellerDAO;
import com.webtools.finalproject.pojo.Person;
import com.webtools.finalproject.pojo.Traveller;

public class TravellerFormValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Traveller.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		Traveller traveller = (Traveller) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.invalid.emailID", "EmailID Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "FirstName Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "LastName Required");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate",
		// "error.invalid.birthDate", "BirthDate Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.streetAddress",
				"error.invalid.address.streetAddress", "StreetAddress Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.aptNo", "error.invalid.address.aptNo",
				"AptNo Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zip", "error.invalid.address.zip", "Zip Required");

		TravellerDAO td = new TravellerDAO();
		try {
			Person p = td.checkAlreadyExistingUserByUserName(traveller.getUserName());
			if (p != null)
				errors.rejectValue("userName", "error.invalid.user", "User Name Already Exists");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Person p = td.checkAlreadyExistingUserByEmailID(traveller.getEmailID());
			if (p != null)
				errors.rejectValue("emailID", "error.invalid.emailID",
						"You have already signed up using this Email ID");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String charRegex = "[a-zA-Z]+";
		String numeric = "[0-9]+";
		String alphanumericRegex = "^[a-zA-Z0-9 ]*$";
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (traveller.getUserName().length() > 15) {
			errors.rejectValue("userName", "error.invalid.userName", "User Name should contain only 15 characters");
		}
		if (traveller.getPassword().length() > 15 && traveller.getPassword().length() < 6) {
			errors.rejectValue("password", "error.invalid.password",
					"Password should contain more than 6 and less than 15 characters");
		}
		if (!traveller.getEmailID().matches(emailRegex)) {
			errors.rejectValue("emailID", "error.invalid.emailID", "Invalid EmailID");

		}
		if (!traveller.getFirstName().matches(charRegex)) {
			errors.rejectValue("firstName", "error.invalid.firstName", "FirstName should contain only characters");

		}
		if (!traveller.getLastName().matches(charRegex)) {
			errors.rejectValue("lastName", "error.invalid.lastName", "LastName should contain only characters");
		}
		if (!traveller.getAddress().getStreetAddress().matches(alphanumericRegex)) {
			errors.rejectValue("address.streetAddress", "error.invalid.address.streetAddress",
					"Street Address should contain only numbers & characters");

		}

		if (!traveller.getAddress().getAptNo().matches(alphanumericRegex)) {
			errors.rejectValue("address.aptNo", "error.invalid.address.aptNo",
					"Apt No should contain only numbers & characters");

		}
		if ((!String.valueOf(traveller.getAddress().getZip()).matches(numeric))) {
			errors.rejectValue("address.zip", "error.invalid.address.zip", "Zip should contain only numbers");

		}
		if (String.valueOf(traveller.getAddress().getZip()).length() < 5) {
			errors.rejectValue("address.zip", "error.invalid.address.zip", "Zip must contain 5 digits");

		}
		if (String.valueOf(traveller.getAddress().getZip()).length() > 5) {
			errors.rejectValue("address.zip", "error.invalid.address.zip", "Zip must contain only 5 digits");

		}
		if (String.valueOf(traveller.getAddress().getZip()).equals("0000")) {
			errors.rejectValue("address.zip", "error.invalid.address.zip", "Invalid Zip");

		}

	}

}
