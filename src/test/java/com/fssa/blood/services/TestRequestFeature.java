package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.service.RequestService;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;

public class TestRequestFeature {

	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2002, 2, 23);

		RequestService requestService = new RequestService();
		Request user1 = new Request("Yogesh", "Thank you for giving blood", "O+", date, 6380843014l,
				"mani@gmail.com");
		try {
			requestService.create(user1);

		} catch (ServiceException | DAOException e) {
			e.printStackTrace();
			fail();

		}

	}

	@Test
	public void testRequestFailure() throws SQLException, ServiceException, InvalidUserException {
		LocalDate date = LocalDate.of(2002, 2, 23);

		RequestService userService = new RequestService();
		Request user1 = new Request("Yogesh", "Thank you for giving blood", "AB+", date, 6380843014l,
				"yogesh@gmail.com");
		try {
			assertTrue(userService.create(user1));

		} catch (DAOException e) {
			e.printStackTrace();
			
		}
	}

	@Test
	public void testInvalidNumber() throws InvalidUserException, SQLException, ServiceException {
		LocalDate date = LocalDate.of(2002, 2, 23);

		RequestService userService = new RequestService();
		Request user1 = new Request("Yogesh", "Thank you for giving blood", "AB+", date, 6380843014l,
				"yogesh@gmail.com");
		try {
			assertFalse(!userService.create(user1)); // Using assertTrue to check for the condition

		} catch (DAOException e) {
			e.printStackTrace();
		
		}
	}

}
