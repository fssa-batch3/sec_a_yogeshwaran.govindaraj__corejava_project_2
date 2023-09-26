package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.blood.model.Hospital;
import com.fssa.blood.service.HospitalService;



public class TestHospitalLoginFeature {
	

	public static void main(String[] args) {
		

		Hospital user1 = new Hospital("yogesh@gmail.com", "@yog#123");
		HospitalService userService = new HospitalService();

		try {
			userService.loginUser("yogesh11@gmail.com", "@Yogesh#123");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
	
	
	@Test
	void testLoginSuccess() {
		HospitalService userService = new HospitalService();
		Hospital user1 = new Hospital("yogesh11@gmail.com", "@Yogesh#123");

		assertFalse(userService.loginUser("yogesh11@gmail.com", "@Yogesh#123"));
	}

	@Test
	void testLoginNotSuccess() {
		HospitalService  userService = new HospitalService();
		Hospital user1 = new Hospital("yogesh@gmail.com", "Yogesh123");
		
		assertFalse(userService.loginUser("yogesh@gmail.com","Yogesh123")); 
	}


	
	
	@Test
	void testLoginWrongPassword() {
		HospitalService  userService = new HospitalService ();
		Hospital user1 = new Hospital("yogesh10@gmail.com", "Yogesh123");
		assertFalse(userService.loginUser("yogesh10@gmail.com", "Yogesh123"));
	}

	
}
