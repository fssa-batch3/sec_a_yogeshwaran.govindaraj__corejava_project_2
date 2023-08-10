package bloodservices;

import java.sql.SQLException;

import bloodDAO.UserDAO;
import bloodDAOexception.DAOException;
import bloodmodel.User;
import bloodserviceexception.ServicesException;
import bloodvalidation.UserValidator;
import bloodvalidationexception.InvalidUserException;

public class UserServices {
	public boolean create(User user) throws ServicesException, DAOException {
		
		UserDAO userDAO = new UserDAO();
		
		try {
			UserValidator.Validation(user);
			if (userDAO.createUser(user)) {
				System.out.println("Successfully created");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException e) {
			throw new ServicesException(e);
		}

	}

	// login user

	public boolean loginUser(User user) throws ServicesException {

		try {
			UserValidator.Validateemail(user.getemail());
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
	}
		
		
	
