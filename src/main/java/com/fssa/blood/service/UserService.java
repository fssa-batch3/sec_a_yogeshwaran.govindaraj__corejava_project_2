package com.fssa.blood.service;

import java.sql.SQLException;
import java.util.function.BooleanSupplier;

import com.fssa.blood.DAO.UserDAO;
import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.User;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.UserValidator;
import com.fssa.blood.validation.exception.InvalidUserException;

public class UserService {
	
	
	
	//In table User detail creating successfully
	
	public boolean create(User user) throws ServiceException, InvalidUserException{
		
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
			throw new ServiceException(e);
		}

	}

	// login user

	public boolean login(User user) throws ServiceException {

		try {
			UserValidator.ValidateEmail(user.getEmail());
			UserValidator.ValidatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.login(user)) {
				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	
	//In table User detail Update successfully

	public static boolean update(User user ,String email) throws ServiceException {
		
		UserDAO userDAO = new UserDAO();
		try {
		UserValidator.Validation(user);
			if (userDAO.update(user,email)) {
				System.out.println("Successfully Updated");
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			throw new ServiceException(e);
		}
	}

	//In table User detail Deleted successfully
	
	public boolean delete(String email) throws ServiceException, InvalidUserException, SQLException {

		UserDAO userDAO = new UserDAO();
		try {
		
			if (userDAO.delete(email)) {
				System.out.println("Successfully Deleted");
				return true;
			} else {
				return false;
			}
				}catch(Exception e) {
			throw new ServiceException(e);
		}
	}
	
	public User getUser(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
//		UserValidator validator = new UserValidator();

		try {
			User loggedUser = userDAO.getUserByEmail(email);
			return loggedUser;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	
	}
	
	public int getUserIdByEmail(String email) throws DAOException {
		int userId = 0;
		try {
			userId = UserDAO.getUserIdByEmail(email);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return userId;
	}
	
//	public User getTenantByEmail(String email) throws DAOException {
//
//		return User.getTenantByEmail(email);
//	}



	public BooleanSupplier loginUser(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	}

		
		
	