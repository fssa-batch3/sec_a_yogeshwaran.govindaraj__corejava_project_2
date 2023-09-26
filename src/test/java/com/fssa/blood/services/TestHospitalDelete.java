package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import com.fssa.blood.service.HospitalService;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;



public class TestHospitalDelete {
	void testDeleteSuccess() throws ServiceException, SQLException {
		String email = "yogs@gmail.com";


		HospitalService userService = new HospitalService();

		try {
			
			assertTrue(userService.delete(email));		
			
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail("Request deletion failed");
		} 
	}
}
