package com.fssa.test.blood.feature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.model.User;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.services.RequestService;
import com.fssa.blood.services.UserServices;
import com.fssa.blood.validation.exception.InvalidUserException;

public class TestRequestFeature {

	public static void main(String[] args) {
		
		Request user1 = new Request("i need AB+ blood group", "Thank you for giving blood", "AB+", "2023-08-22", "218965870919", "2188658709");
		RequestService requestService = new RequestService();

		try {
			requestService .create(user1);
		} catch (ServicesException | DAOException e) {
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testRequestSuccess() throws SQLException, ServicesException, InvalidUserException {
		long startTime = System.nanoTime();

		RequestService requestService = new RequestService();
		Request user1 = new Request("i need AB+ blood group", "Thank you for giving blood", "AB+", "2023-08-22", "218965870919", "2188658709");
		try {
			assertFalse(requestService.create(user1));
		
		} catch (ServicesException|DAOException e) {
			
			e.printStackTrace();
			
		}
	
	}
	
	
	
	@Test
	public void testInvalidNumber() throws InvalidUserException, SQLException, ServicesException {
		long startTime = System.nanoTime();

		RequestService userService = new RequestService();
		Request user1 = new Request("yogsj" + startTime + "@gmail.com", "Yogesh", "Ajmal123", "Chennai the is good ",
				"6380843041", "214365870916");
		try {
			assertFalse(userService.create(user1));
		} catch (DAOException e) {
			e.printStackTrace();
		}
	
	}

}




