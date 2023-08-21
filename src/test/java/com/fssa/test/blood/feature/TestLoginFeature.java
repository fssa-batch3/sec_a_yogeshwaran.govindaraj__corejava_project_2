package com.fssa.test.blood.feature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.User;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.services.*;
import com.fssa.blood.validation.exception.InvalidUserException;
import com.google.protobuf.ServiceException;

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
		public void testRegistrationSuccess() throws InvalidUserException, SQLException {
			long startTime = System.nanoTime();

			UserServices userService = new UserServices();
			User user1 = new User("yogs" + startTime + "@gmail.com", "Yogesh", "Ajmal@123", "Chennai the is good ",
					"6380843014", "214365870916");
			try {
				assertTrue(userService.create(user1));
			} catch (ServicesException e) {
				e.printStackTrace();

			}
		}

		@Test
		public void testInvalidPassword() throws InvalidUserException, SQLException {
			long startTime = System.nanoTime();

			UserServices userService = new UserServices();
			User user1 = new User("yogsj" + startTime + "@gmail.com", "Yogesh", "Ajmal123", "Chennai the is good ",
					"6380843014", "214365870916");
			try {
				assertFalse(userService.create(user1));
			} catch (ServicesException e) {
				e.printStackTrace();
			}
		}

		@Test
		public void testUserNull() {

			UserServices userService = new UserServices();
			User user1 = null;
			try {
				assertFalse(userService.create(user1));
				fail();
			} catch (ServicesException e) {
				e.printStackTrace();
			}

		}
}
	

