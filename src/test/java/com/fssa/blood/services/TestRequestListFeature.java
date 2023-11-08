package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.blood.DAO.exception.DAOException;
import com.fssa.blood.model.Request;
import com.fssa.blood.service.RequestService;
import com.fssa.blood.service.exception.ServiceException;




public class TestRequestListFeature {
	@Test
	 void testValidReadUser() throws DAOException, SQLException, ServiceException {
	        Request list = RequestService.getRequestsByEmail("maari@gmail.com");
	        
	        System.out.println(list);

	}
}
