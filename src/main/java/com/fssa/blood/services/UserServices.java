package com.fssa.blood.services;

import java.sql.SQLException;
import java.util.function.BooleanSupplier;

import com.fssa.blood.DAO.UserDAO;
import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.User;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.validation.UserValidator;
import com.fssa.blood.validation.exception.InvalidUserException;

public class UserServices {
	
	
	
	//In table User detail creating successfully
	
	public boolean create(User user) throws ServicesException, InvalidUserException{
		
		UserDAO userDAO = new UserDAO();
		
		try {
			UserValidator.Validation(user);
			if (userDAO.createUser(user)) {
				System.out.println("Successfully created");
				return true;
			} else {
				return false;
			}
		} catch (DAOException e) {
			throw new ServicesException(e);
		}

	}

	// login user

	public boolean login(User user) throws ServicesException {

		try {
			UserValidator.validateEmail(user.getemail());
			UserValidator.Validatepassword(user.getpassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.login(user)) {
				System.out.println(user.getemail() + " Successfully logged in");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServicesException(e);
		}
	}
	
	
	//In table User detail Update successfully

	public boolean update(User user) throws ServicesException {
		
		UserDAO userDAO = new UserDAO();
		try {
		UserValidator.Validation(user);
			if (userDAO.update(user)) {
				System.out.println("Successfully Updated");
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			throw new ServicesException(e);
		}
	}

	//In table User detail Deleted successfully
	
	public boolean delete(User user) throws ServicesException, InvalidUserException, SQLException {

		UserDAO userDAO = new UserDAO();
		try {
		if (UserValidator.Validation(user)) {
			if (userDAO.delete(user)) {
				System.out.println("Successfully Deleted");
				return true;
			} else {
				return false;
			}
		}
		}catch(Exception e) {
			throw new ServicesException(e);
		}
		return false;
	}

	public BooleanSupplier loginUser(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	}
		
		
	
