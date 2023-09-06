package com.fssa.blood.validation;

import java.util.regex.Pattern;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.User;
import com.fssa.blood.validation.exception.InvalidUserException;



public class UserValidator {

	public static boolean Validation(User user) throws InvalidUserException {
		boolean match = false;
		if (user != null && Validatename(user.getname()) && validateEmail(user.getemail())
				&& Validatepassword(user.getpassword()) && Validatephone(user.getphone())
				&& Validateaddress(user.getaddress()) ) {
			match = true;
		} else {
			throw new InvalidUserException("Invalid user");
		}
		return match;
	}
	
	
	// Checking the loginUser present or not

			public static boolean validateLogIn(User user) throws DAOException {
				if (user != null && validateEmail(user.getemail()) && Validatepassword(user.getpassword())) {
					return true;
				} else {
					throw new DAOException("User details not valid");

				}
			}
		
			
			// Checking the validate update details
			
			public static boolean validateUpdateUser(User user) throws DAOException, InvalidUserException {
				if (user != null && Validatename(user.getname()) && Validatepassword(user.getpassword())
						&& validateEmail(user.getemail())){
					return true; 
				} else {
					throw new DAOException("User details not valid");
				}
			}
			
			// Checking the validate deleted details
			
			public static boolean validateDeleteUser(User user) throws DAOException {
				if (user != null && validateEmail(user.getemail()) ) {
					return true;
				} else {
					throw new DAOException("User details not valid");

				}
			}
/**
 * name must contain alapbetes
 * @param name
 * @return
 * @throws InvalidUserException
 */
	
			
		


			//its mine 

	public static boolean Validatename(String name) throws InvalidUserException {
		boolean match = false;

		String regex = "^[A-Za-z]\\w{2,29}$";;
		match = Pattern.matches(regex, name);

		if (match) {
			System.out.println("Name is Valid");
		} else {
			throw new InvalidUserException("Name is Invalid");
		}
		return match;
	}

	public static boolean validateEmail(String email) {

		boolean match = false;
		String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		match = Pattern.matches(emailRegex, email);

		if (match) {
			System.out.println("Email is Valid");
		} else {
			System.out.println("Email is Invalid");
		}
		return match;
	}

	public static boolean Validatepassword(String password) {
		boolean match = false;

		String passwordRegex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(passwordRegex, password);

		if (match) {
			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password");
		}
		return match;
	}

	public static boolean Validateaddress(String address) {

		boolean match = false;

		String addressRegex = "^[A-Za-z0-9\\s,.'-]{3,}$";
		match = Pattern.matches(addressRegex, address);

		if (match) {
			System.out.println("Address is valid");
		} else {
			System.out.println("Address is Invalid");
		}
		return match;
	}

	public static boolean Validatephone(String phone) {

		boolean match = false;
		String phoneRegex = "[0-9]{10}";
		match = Pattern.matches(phoneRegex, phone);

		if (match) {
			System.out.println("PhoneNumber is Valid");
		} else {
			System.out.println("PhoneNumber is Invalid");
		}
		return match;
	}


}
