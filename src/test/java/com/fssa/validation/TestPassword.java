package com.fssa.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.blood.validation.UserValidator;

public class TestPassword {

	@Test
	public void testValidPassword() {

		assertTrue(UserValidator.ValidatePassword("Password@123"));

	}

	@Test
	public void testInvalidPasswordWithoutSpecialCharacters() {
		assertFalse(UserValidator.ValidatePassword("Password123"));

	}

	@Test
	public void testInvalidPasswordWithoutNumbers() {
		assertFalse(UserValidator.ValidatePassword("Password@"));

	}

	@Test
	public void testInvalidPasswordWithoutCapitalLetters() {
		assertFalse(UserValidator.ValidatePassword("password123"));

	}

	@Test
	public void testInvalidPasswordWithoutSmallLetters() {
		assertFalse(UserValidator.ValidatePassword("PASSWORD@123"));

	}
	@Test
	public void testInvalidPasswordShorterLength() {
		assertFalse(UserValidator.ValidatePassword("Pas@123"));

	}
}
