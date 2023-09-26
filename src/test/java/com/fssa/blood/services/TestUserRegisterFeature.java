package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.blood.model.User;
import com.fssa.blood.service.UserService;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;


public class TestUserRegisterFeature {

	// main method

	public static void main(String[] args) throws ServiceException, InvalidUserException {

		User user1 = new User("Yogesh", "yogesh@gmail.com", "@Yogesh#123", "Trichy",
				"6380843014");
		UserService userService = new UserService();

		try {
			assertFalse(userService.create(user1));
		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
			fail();
		}
	

	}
	
	
	@Test
	 void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User( "Yogesh","yogs@gmail.com", "Ajmal@123", "Trichy",
				"6380843014");
		try {
			assertTrue(userService.create(user1));
		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
			
		}
	}
	

	 
	@Test  
	 void testNullUser() throws InvalidUserException {
		UserService userService = new UserService(); 
		User user1 = null;
		
		try {
			assertFalse(userService.create(user1));
			fail();

		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	 void testRegistrationExistsingUser() throws InvalidUserException {
		UserService userService = new UserService();
		User user1 = new User("yogs@gmail.com", "Yogesh", "Ajmal@123", "Trichy",
				"6380843014");
		
		try {
			assertFalse(userService.create(user1));
		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
			
		}
	}
	
	

}

//	@Test
//	public void testRegistrationSuccess() throws InvalidUserException, SQLException, ServicesException {
//		long startTime = System.nanoTime();
//
//		UserServices userService = new UserServices();
//		User user1 = new User("yogs" + startTime + "@gmail.com", "Yogesh", "Ajmal@123", "Chennai the is good ",
//				"6380843014");
//		try {
//			assertFalse(userService.create(user1));
//		} catch (ServicesException | InvalidUserException e) {
//			
//			e.printStackTrace();
//			
//		}
//	
//	}
//
//	@Test
//	public void testInvalidPassword() throws InvalidUserException, SQLException, ServicesException {
//		long startTime = System.nanoTime();
//
//		UserServices userService = new UserServices();
//		User user1 = new User("yogsj" + startTime + "@gmail.com", "Yogesh", "Ajmal123", "Chennai the is good ",
//				"6380843014");
//		try {
//			assertFalse(userService.create(user1));
//		} catch (ServicesException | InvalidUserException e) {
//			e.printStackTrace();
//		}
//	
//	}
//
//	@Test
//	public void testUserNull()   {
//
//		UserServices userService = new UserServices();
//		User user1 = null;
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
//	}
//}
//		
//	
//