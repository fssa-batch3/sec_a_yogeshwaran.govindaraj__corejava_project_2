package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Hospital;
import com.fssa.blood.service.HospitalService;
import com.fssa.blood.service.exception.ServiceException;



public class TestHospitalUpdate {
	
	@Test
	void testUpdateSuccess() throws ServiceException,DAOException {
		
	
		String email = "yogs@gmail.com";
		Hospital user1 = new Hospital("Yogesh", "yogs@gmail.com", "Ajmal@123", "Trichy",
				"6380843014");
		try {
			assertTrue(HospitalService.update(user1, email));
		} catch (ServiceException e) {
			e.printStackTrace();
		} 
	}
}
