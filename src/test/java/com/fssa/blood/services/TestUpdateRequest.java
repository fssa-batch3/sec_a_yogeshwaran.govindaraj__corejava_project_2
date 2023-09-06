package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.validation.exception.InvalidUserException;


public class TestUpdateRequest {

	@Test
	void testUpdateSuccess() throws ServicesException,DAOException {
		LocalDate date = LocalDate.of(2002, 2, 23);
		RequestService requestService = new RequestService(); 
		String email = "ajay12@gmail.com";
		Request request = new Request("i need B+ blood group", "Thank you for giving blood", "AB+", date,6380843016L, email);
		try {
			assertTrue(requestService.updaterequest(request, email));
		} catch (ServicesException |InvalidUserException e) {
			e.printStackTrace();
		} 
	}
}
