package bloodservices;

import bloodDAO.RequestDAO;
import bloodDAOexception.DAOException;
import bloodmodel.Request;
import bloodserviceexception.ServicesException;
import bloodvalidation.RequestValidator;
import bloodvalidationexception.InvalidUserException;

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
				System.out.println("Successfully Reading");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException e) {
			throw new ServicesException(e);
		}

	}
	
}

