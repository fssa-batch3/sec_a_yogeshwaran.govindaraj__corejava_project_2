package Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import blood.model.User;
import blood.Services.*;
import blood.ValidationException.InvalidUserExecption;

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
		public void testRegistrationSuccess() throws InvalidUserExecption, SQLException {
			

			UserServices userService = new UserServices();
	        User user1 = new User("yogesh@gmail.com", "@yog#123");
			try {
				assertTrue(userService.create(user1));
			} catch (ServiceException e) {
				e.printStackTrace();
				fail();
			}
		}

		@Test
		public void testInvalidPassword() throws InvalidUserExecption, SQLException {
			

			 UserServices userService = new UserServices();
	        User user1 = new User("yogesh@gmail.com","@yog#123");
			try {
				assertFalse(userService.create(user1));
			} catch (ServiceException e) {
				e.printStackTrace();
				fail();
			}
		}

		@Test
		public void testUserNull() throws InvalidUserExecption, SQLException {

			 UserServices userService = new UserServices();
			User user1 = null;
			try {
				assertFalse(userService.create(user1));
			} catch (ServiceException e) {
				e.printStackTrace();
				fail();
			}

		}
}
	

