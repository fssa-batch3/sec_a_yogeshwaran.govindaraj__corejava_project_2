package com.fssa.blood.service;

import java.util.List;
import java.util.function.BooleanSupplier;

import com.fssa.blood.DAO.RequestDAO;
import com.fssa.blood.DAO.UserDAO;
import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.model.User;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.RequestValidator;
import com.fssa.blood.validation.exception.InvalidUserException;

public class RequestService {




public boolean create(Request request) throws ServiceException, DAOException {
		
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
			throw new ServiceException(e);
		}

}


//public String getUser(String email) throws ServiceException {
//	RequestDAO userDAO = new RequestDAO();
////	UserValidator validator = new UserValidator();
//
//	try {
//		String blood = userDAO.getUserByEmail(email);
//		return blood;
//	} catch (DAOException e) {
//		throw new ServiceException(e.getMessage());
//	}
//}
//	


public List<Request> readrequest() throws ServiceException {
	
	RequestDAO requestDAO = new RequestDAO();
		
		try {
		
			List<Request> req = requestDAO.readrequest();
			return req;
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		

	}

public  boolean updaterequest(Request request,String email) throws ServiceException,InvalidUserException, DAOException {
	
	RequestDAO requestDAO = new RequestDAO();
		
		try {
			RequestValidator.Validation(request);
			if (requestDAO.updaterequest(request, email)) {
				System.out.println("Successfully Update");
				return true;
			} else {
				System.out.println("not successfully updated");
				return false;
			}
		} catch (DAOException|InvalidUserException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}

	}

public boolean delete(String email) throws ServiceException, InvalidUserException, DAOException {

	RequestDAO requestDAO = new RequestDAO();
	try {
	
		if (requestDAO.deleterequest(email)) {
			System.out.println("Successfully Deleted");
			return true;
		} else {
			return false;
		}
	
	}catch(DAOException e) {
		e.printStackTrace();
		throw new ServiceException(e);
	}
	
}

public BooleanSupplier loginUser(String string, String string2) {

	return null;
}







	
}

