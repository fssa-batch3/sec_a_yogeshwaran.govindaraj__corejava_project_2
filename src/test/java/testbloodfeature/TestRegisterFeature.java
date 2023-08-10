package testbloodfeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import bloodmodel.User;
import bloodserviceexception.ServicesException;
import bloodservices.*;
import bloodvalidationexception.InvalidUserException;
import bloodDAOexception.DAOException;

public class TestRegisterFeature {

		public static void main(String[] args) {
	
			User user1 = new User("ishu", "ishu@gmail.com", "ishu@123", "Chennai", "6380840991", "218865870901");
			UserServices userService = new UserServices();
	
			try {
				userService.create(user1);
			} catch (ServicesException | DAOException e) {
				e.printStackTrace();
				fail();
			}
	
		}

	@Test
	public void testRegistrationSuccess() throws InvalidUserException, SQLException {

		UserServices userService = new UserServices();
		User user1 = new User("yogesh@gmail.com", "Yogesh", "@yog#123", "Chennai the is good ", "6380843014",
				"214365870912");
		try {
			assertTrue(userService.create(user1));
		} catch (ServicesException | DAOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInvalidPassword() throws InvalidUserException, SQLException, DAOException {

		UserServices userService = new UserServices();
		User user1 = new User("yogesh@gmail.com", "Yogesh", "@yog#123", "Chennai the is good ", "6380843014",
				"214365870912");
		try {
			assertFalse(userService.create(user1));
		} catch (ServicesException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testUserNull() throws InvalidUserException, SQLException, DAOException {

		UserServices userService = new UserServices();
		User user1 = null;
		try {
			assertFalse(userService.create(user1));
		} catch (ServicesException e) {
			e.printStackTrace();
			fail();
		}

	}
}
