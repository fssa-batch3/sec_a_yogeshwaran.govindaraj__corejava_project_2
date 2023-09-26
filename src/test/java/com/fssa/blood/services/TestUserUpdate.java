package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.User;
import com.fssa.blood.service.UserService;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;

public class TestUserUpdate {

	@Test
	void testUpdateSuccess() throws ServiceException,DAOException {
		
	
		String email = "dinesh@gmail.com";
		User user1 = new User("Yogesh", email, "@Yogesh12", "Trichy",
				"6380843014");
		try {
			assertTrue(UserService.update(user1, email));
		} catch (ServiceException e) {
			e.printStackTrace();
		} 
	}
}