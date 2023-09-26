package com.fssa.blood.validation;

import java.util.regex.Pattern;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Hospital;
import com.fssa.blood.validation.exception.InvalidUserException;

public class HospitalValidator {



		public static boolean Validation(Hospital user) throws InvalidUserException {
			boolean match = false;
			
			if(user != null && ValidateName(user.getName()) && ValidateEmail(user.getEmail()) &&  ValidatePassword(user.getPassword()) && ValidateAddress(user.getAddress()) 
					&& ValidatePhone(user.getPhone())) {
				match = true;
			} else {
				throw new InvalidUserException("Invalid user");
			}
			return match;
		}
			
			
			
		
		
		// Checking the loginUser present or not

				public static boolean validateLogIn(Hospital user) throws DAOException {
					if (user != null && ValidateEmail(user.getEmail()) && ValidatePassword(user.getPassword())) {
						return true;
					} else {
						throw new DAOException("User details not valid");

					}
				}
			
				
				// Checking the validate update details
				
				public static boolean validateUpdateUser(Hospital user) throws DAOException, InvalidUserException {
					if (user != null && ValidateName(user.getName()) && ValidatePassword(user.getPassword())
							&& ValidateEmail(user.getEmail())&& ValidateAddress(user.getAddress()) && ValidatePhone(user.getPhone())){
						return true; 
					} else {
						throw new DAOException("User details not valid");
					}
				}
				
				
				
				
				// Checking the validate deleted details
				
				public static boolean validateDeleteUser(Hospital user) throws DAOException {
					if (user != null && ValidateEmail(user.getEmail()) ) {
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
		
				
			


				

		public static boolean ValidateName(String name) throws InvalidUserException {
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

		public static boolean ValidateEmail(String email) {

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

		public static boolean ValidatePassword(String password) {
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

		
		
		public static boolean ValidateAddress(String address) {

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

		public static boolean ValidatePhone(String phone) {

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


