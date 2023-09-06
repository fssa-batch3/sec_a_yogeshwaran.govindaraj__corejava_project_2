package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.validation.exception.InvalidUserException;

public class TestRequestDelete {

	@Test
	void testDeleteSuccess() throws ServicesException {
		String email = "ajay12@gmail.com";
//		Request request = new Request(email);

		RequestService requestService = new RequestService();

		try {
			
			assertTrue(requestService.delete(email));		
			
		} catch (InvalidUserException | DAOException e) {
			e.printStackTrace();
			fail("Request deletion failed");
		} 
	}

}
