package testbloodfeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import bloodmodel.User;
import bloodserviceexception.ServicesException;
import bloodservices.*;
import bloodvalidationexception.InvalidUserException;
import bloodDAOexception.DAOException;

public class TestLoginFeature {
	


		
		public static void main(String[] args) {
			

	        User user1 = new User("yogesh@gmail.com", "@yog#123");
	        UserServices userService = new UserServices();

			try {
				userService.create(user1);
			} catch (Exception e) {
				e.printStackTrace();
				fail();
			}

		}

		@Test
		public void testRegistrationSuccess() throws InvalidUserException, SQLException, ServicesException, DAOException, ServiceException {
			

			UserServices userService = new UserServices();
	        User user1 = new User("yogesh@gmail.com", "@yog#123");
			assertTrue(userService.create(user1));
		}

		@Test
		public void testInvalidPassword() throws InvalidUserException, SQLException, ServicesException, DAOException, ServiceException {
			

			 UserServices userService = new UserServices();
	        User user1 = new User("yogesh@gmail.com","@yog#123");
			assertFalse(userService.create(user1));
		}

		@Test
		public void testUserNull() throws InvalidUserException, SQLException, ServicesException, DAOException, ServiceException {

			 UserServices userService = new UserServices();
			User user1 = null;
			assertFalse(userService.create(user1));

		}
}
	

