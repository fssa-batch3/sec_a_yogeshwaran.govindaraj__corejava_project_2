package com.fssa.blood.service;

import java.util.List;
import java.util.function.BooleanSupplier;

import com.fssa.blood.DAO.RequestDAO;
import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
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


//
//    private static RequestDAO requestDAO; // Assuming you have a DAO class
//
//    public RequestService() {
//        this.requestDAO = requestDAO;
//    }

    public static Request getRequestsByEmail(String email) throws ServiceException {
        Request req = new Request();
		try {
			req = RequestDAO.readRequest(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return req;
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
public List<Request> listRequestsByEmail() throws ServiceException {
	RequestDAO requestDAO = new RequestDAO();
    try {
        return RequestDAO.listrequest();
    } catch (DAOException e) {
    	e.printStackTrace();
        // You can log the exception or perform error handling as needed
        throw new ServiceException("Error in listing requests by email");
    }
}

public static void main(String[] args) {
	
	try {
		List<Request> req = new RequestService().listRequestsByEmail();
		System.out.println(req.get(0).toString());
	} catch ( ServiceException e) {
		e.printStackTrace();
	}
	
}

public BooleanSupplier loginUser(String string, String string2) {

	return null;
}







	
}

