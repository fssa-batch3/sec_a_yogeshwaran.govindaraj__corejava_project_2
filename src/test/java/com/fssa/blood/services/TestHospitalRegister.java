package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.blood.model.Hospital;
import com.fssa.blood.service.HospitalService;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;



public class TestHospitalRegister {
	public static void main(String[] args) throws ServiceException, InvalidUserException {

		Hospital user1 = new Hospital("Yogesh", "yogesh@gmail.com", "@Yogesh#123", "Trichy",
				"6380843014");
		HospitalService userService = new HospitalService();

		try {
			assertFalse(userService.create(user1));
		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
			fail();
		}
	

	}
	
	
	@Test
	 void testRegistrationSuccess() {
		HospitalService userService = new HospitalService();
		Hospital user1 = new Hospital( "Yogesh","yogs@gmail.com", "Ajmal@123", "Trichy",
				"6380843014");
		try {
			assertTrue(userService.create(user1));
		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
			
		}
	}
	

	 
	@Test  
	 void testNullUser() throws InvalidUserException {
		HospitalService userService = new HospitalService(); 
		Hospital user1 = null;
		
		try {
			assertFalse(userService.create(user1));
			fail();

		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	 void testRegistrationExistsingUser() throws InvalidUserException {
		HospitalService userService = new HospitalService();
		Hospital user1 = new Hospital("yogs@gmail.com", "Yogesh", "Ajmal@123", "Trichy",
				"6380843014");
		
		try {
			assertFalse(userService.create(user1));
		} catch (ServiceException | InvalidUserException e) {
			
			e.printStackTrace();
			
		}
	}
	
	

}
