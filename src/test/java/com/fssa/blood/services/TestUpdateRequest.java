package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.service.RequestService;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;


public class TestUpdateRequest {

	@Test
	void testUpdateSuccess() throws ServiceException,DAOException {
		LocalDate date = LocalDate.of(2002, 2, 20);
		RequestService requestService = new RequestService(); 
		String email = "yogesh@gmail.com";
		Request request = new Request("Yogeshwaran", "My blood is B+ you call me a any I will donating the blood for you", "B+", date,6380843016L, email);
		try {
			assertTrue(requestService.updaterequest(request, email));
		} catch (ServiceException |InvalidUserException e) {
			e.printStackTrace();
		} 
	}
}
