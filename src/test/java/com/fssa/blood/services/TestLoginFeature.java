package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.blood.model.User;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.services.UserServices;
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
		void testLoginSuccess() {
			UserServices userService = new UserServices();
			User user1 = new User("yogesh11@gmail.com", "@Yogesh#123");

			try {
				assertFalse(userService.login(user1));
				
			} catch (ServicesException e) {
				e.printStackTrace();
				fail();
				
			}
		}

		@Test
		void testLoginNotSuccess() {
			UserServices userService = new UserServices();
			User user1 = new User("yogesh@gmail.com", "Yogesh123");
			
			try {
				assertFalse(userService.login(user1));
			} catch (ServicesException e) {
				e.printStackTrace();
			} 
		}

//		@Test
//		void testLoginWrongEmail() {
//			UserServices userService = new UserServices();
//			User user1 = new User("yogesh@gmail.com", "@Yogesh#123");
//			try {
//				assertFalse(userService.login(user1));
//				fail();
//			} catch (ServicesException e) {
//				e.printStackTrace();
//				
//			}
//		}
		
		
		@Test
		void testLoginWrongPassword() {
			UserServices userService = new UserServices();
			User user1 = new User("yogesh10@gmail.com", "Yogesh123");
			try {
				assertFalse(userService.login(user1));
			} catch (ServicesException e) {
				e.printStackTrace();
			}
		}
	
			


		
		

//		@Test
//		public void testLoginSuccess() throws InvalidUserException, SQLException {
//			long startTime = System.nanoTime();
//
//			UserServices userService = new UserServices();
//			User user1 = new User("yogs" + startTime + "@gmail.com", "Yogesh", "Ajmal@123", "Chennai the is good ",
//					"6380843014");
//			try {
//				assertFalse(userService.create(user1));
//			} catch (ServicesException | InvalidUserException e) {
//				
//				e.printStackTrace();
//				
//			}
//		
//		}
//		
			
		
		
		
//		@Test
//		public void testInvalidPassword() throws InvalidUserException, SQLException, ServicesException {
//			long startTime = System.nanoTime();
//
//			UserServices userService = new UserServices();
//			User user1 = new User("yogsj" + startTime + "@gmail.com", "Yogesh", "Ajmal123", "Chennai the is good ",
//					"6380843014");
//			try {
//				assertFalse(userService.create(user1));
//			} catch (ServicesException | InvalidUserException e) {
//				
//				e.printStackTrace();
//				
//			}
//		
//		}

//		@Test
//		public void testUserNull() throws DAOException, ServicesException, InvalidUserException {
//
//			UserServices userService = new UserServices();
//			User user1 = null;
//			
//			try {
//				assertFalse(userService.create(user1));
//				fail();
//
//			} catch (ServicesException | InvalidUserException e) {
//				
//				e.printStackTrace();
//			}
//		
//
//		}
}


//this anthore 
