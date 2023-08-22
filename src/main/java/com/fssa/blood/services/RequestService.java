package com.fssa.blood.services;

import com.fssa.blood.DAO.RequestDAO;
import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.validation.RequestValidator;
import com.fssa.blood.validation.exception.InvalidUserException;

public class RequestService {

public boolean create(Request request) throws ServicesException, DAOException {
		
	RequestDAO requestDAO = new RequestDAO();
		
		try {
			RequestValidator.Validation(request);
			if (requestDAO.createrequest(request)) {
				System.out.println("Successfully created");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException e) {
			throw new ServicesException(e);
		}

	}
	


public boolean readrequest(Request request) throws ServicesException, DAOException {
	
	RequestDAO requestDAO = new RequestDAO();
		
		try {
			RequestValidator.Validation(request);
			if (requestDAO.readrequest(request)) {
				System.out.println("Successfully Reading");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException e) {
			throw new ServicesException(e);
		}

	}

public boolean updaterequest(Request request) throws ServicesException, DAOException {
	
	RequestDAO requestDAO = new RequestDAO();
		
		try {
			RequestValidator.Validation(request);
			if (requestDAO.updaterequest(request)) {
				System.out.println("Successfully Update");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException  e) {
			throw new ServicesException(e);
		}

	}
	
}

