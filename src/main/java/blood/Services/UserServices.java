package blood.Services;

import java.sql.SQLException;

import com.google.protobuf.ServiceException;

import blood.Validation.UserValidator;
import blood.ValidationException.InvalidUserExecption;
import blood.model.User;
import blood.DAO.UserDAO;

public class UserServices{
	public boolean create(User user)throws ServiceException, InvalidUserExecption, SQLException{
		UserDAO userDAO = new UserDAO();

			if(UserValidator.Validation(user)) {
			if(userDAO.createUser(user)) {
				System.out.println("Successfully created");
				return true;
			}else{
				return false;
			}
			} else {
				return false;
			}
	}
	
	//login user
	
	public boolean loginUser(User user) throws ServiceException {

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
			throw new ServiceException(e.getLocalizedMessage());
			}
	}
	
	public boolean update(User user)throws  ServiceException, InvalidUserExecption, SQLException{
		
		UserDAO userDAO = new UserDAO();
		if(UserValidator.Validation(user)) {
			if(userDAO.update(user)) {
				System.out.println("Successfully Updated");
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	
	public boolean delete(User user)throws  ServiceException, InvalidUserExecption, SQLException{
		
		UserDAO userDAO = new UserDAO();
		if(UserValidator.Validation(user)) {
			if(userDAO.delete(user)) {
				System.out.println("Successfully Deleted");
				return true;
				}else {
					return false;
				}
		}else {
			return false;
		}
	}


	
}
			
		
