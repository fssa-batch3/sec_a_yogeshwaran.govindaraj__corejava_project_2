package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.blood.model.User;
import com.fssa.blood.service.UserService;

import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestUserLoginFeature {

    @Test
    void testLoginSuccess() {
        UserService userService = new UserService();
        User user1 = new User("yogesh11@gmail.com", "@Yogesh#123");
        assertTrue(userService.loginUser("yogesh11@gmail.com", "@Yogesh#123"));
    }

    @Test
    void testLoginNotSuccess() {
        UserService userService = new UserService();
        User user1 = new User("yogesh@gmail.com", "Yogesh123");
        assertFalse(userService.loginUser("yogesh@gmail.com", "Yogesh123"));
    }

    @Test
    void testLoginWrongPassword() {
        UserService userService = new UserService();
        User user1 = new User("yogesh10@gmail.com", "Yogesh123");
        assertFalse(userService.loginUser("yogesh10@gmail.com", "Yogesh123"));
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



