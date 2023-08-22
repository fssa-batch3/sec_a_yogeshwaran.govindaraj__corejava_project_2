package com.fssa.test.blood.feature;

import static org.junit.jupiter.api.Assertions.fail;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.service.exception.ServicesException;
import com.fssa.blood.services.RequestService;

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


}
