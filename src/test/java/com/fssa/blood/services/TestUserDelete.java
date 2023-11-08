package com.fssa.blood.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.blood.service.UserService;
import com.fssa.blood.service.exception.ServiceException;
import com.fssa.blood.validation.exception.InvalidUserException;

public class TestUserDelete {

    @Test
    void testDeleteSuccess() throws ServiceException, SQLException{
        String email = "yogs@gmail.com";

        UserService userService = new UserService();

        try {
        	assertTrue(userService.delete(email));

        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail("deleted failed: " + e.getMessage());
        }
    }
}





