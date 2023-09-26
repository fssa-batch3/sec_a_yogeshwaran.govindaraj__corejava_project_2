package com.fssa.blood.service;

import java.sql.SQLException;
import java.util.function.BooleanSupplier;

import com.fssa.blood.DAO.HospitalDAO;
import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Hospital;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.HospitalValidator;
import com.fssa.blood.validation.exception.InvalidUserException;



public class HospitalService {

public boolean create(Hospital user) throws ServiceException, InvalidUserException{
		
	HospitalDAO userDAO = new HospitalDAO();
		
		try {
			HospitalValidator.Validation(user);
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

	public boolean login(Hospital user) throws ServiceException {

		try {
			HospitalValidator.ValidateEmail(user.getEmail());
			HospitalValidator.ValidatePassword(user.getPassword());

			HospitalDAO userDAO = new HospitalDAO();
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

	public static boolean update(Hospital user ,String email) throws ServiceException {
		
		HospitalDAO userDAO = new HospitalDAO();
		try {
			HospitalValidator.Validation(user);
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

		HospitalDAO userDAO = new HospitalDAO();
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

	public BooleanSupplier loginUser(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	}
		

