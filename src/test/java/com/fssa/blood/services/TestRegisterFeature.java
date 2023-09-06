package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.blood.model.User;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.services.UserServices;
import com.fssa.blood.validation.exception.InvalidUserException;


public class TestRegisterFeature {

	// main method

	public static void main(String[] args) throws ServicesException, InvalidUserException {

		User user1 = new User("Yogesh", "yogesh@gmail.com", "@Yogesh#123", "Trichy",
				"6380843014");
		UserServices userService = new UserServices();

		try {
			assertFalse(userService.create(user1));
		} catch (ServicesException | InvalidUserException e) {
			
			e.printStackTrace();
			fail();
		}
	

	}
	
	
	@Test
	 void testRegistrationSuccess() {
		UserServices userService = new UserServices();
		User user1 = new User("yogs@gmail.com", "Yogesh", "Ajmal@123", "Trichy",
				"6380843014");
		try {
			assertFalse(userService.create(user1));
		} catch (ServicesException | InvalidUserException e) {
			
			e.printStackTrace();
			
		}
	}
	

	 
	@Test  
	 void testNullUser() throws InvalidUserException {
		UserServices userService = new UserServices(); 
		User user1 = null;
		
		try {
			assertFalse(userService.create(user1));
			fail();

		} catch (ServicesException | InvalidUserException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	 void testRegistrationExistsingUser() throws InvalidUserException {
		UserServices userService = new UserServices();
		User user1 = new User("yogs@gmail.com", "Yogesh", "Ajmal@123", "Trichy",
				"6380843014");
		
		try {
			assertFalse(userService.create(user1));
		} catch (ServicesException | InvalidUserException e) {
			
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
