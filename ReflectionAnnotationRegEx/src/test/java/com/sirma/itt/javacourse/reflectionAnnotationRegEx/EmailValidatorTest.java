package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for the EmailValidator class.
 * 
 * @author gdimitrov
 */
public class EmailValidatorTest {
	/**
	 * Tests the isValid function with valid email.
	 */
	@Test
	public void testIsValidWithValidInput1() {
		assertTrue(EmailValidator.isValid("test.t-s@sir-ma.com"));
	}

	/**
	 * Tests the isValid function with valid email.
	 */
	@Test
	public void testIsValidWithValidInput2() {
		assertTrue(EmailValidator.isValid("h1ello@sirma999.com"));
	}

	/**
	 * Tests the isValid function with valid email.
	 */
	@Test
	public void testIsValidWithValidInput3() {
		assertTrue(EmailValidator.isValid("test@sirma.com"));
	}

	/**
	 * Tests the isValid function with valid email.
	 */
	@Test
	public void testIsValidWithValidInput4() {
		assertTrue(EmailValidator.isValid("eee@s-sirma.com"));
	}

	/**
	 * Tests the isValid function with valid email.
	 */
	@Test
	public void testIsValidWithValidInput5() {
		assertTrue(EmailValidator.isValid("eee@cc.british.museum"));
	}

	/**
	 * Tests the isValid function with valid email.
	 */
	@Test
	public void testIsValidWithValidInput6() {
		assertTrue(EmailValidator.isValid("test.@sirma.com"));
	}

	/**
	 * Tests the isValid function with invalid email.
	 */
	@Test
	public void testIsValidWithInvalidInput1() {
		assertFalse(EmailValidator.isValid("2test.@sirma.com"));
	}

	/**
	 * Tests the isValid function with invalid email.
	 */
	@Test
	public void testIsValidWithInvalidInput2() {
		assertFalse(EmailValidator.isValid("tes=t.@sirma.com"));
	}

	/**
	 * Tests the isValid function with invalid email.
	 */
	@Test
	public void testIsValidWithInvalidInput3() {
		assertFalse(EmailValidator.isValid("tes\t.@sirma.com"));
	}

	/**
	 * Tests the isValid function with invalid email.
	 */
	@Test
	public void testIsValidWithInvalidInput4() {
		assertFalse(EmailValidator.isValid("tes<>t.@sirma.com"));
	}

	/**
	 * Tests the isValid function with invalid email.
	 */
	@Test
	public void testIsValidWithInvalidInput5() {
		assertFalse(EmailValidator.isValid("tes t.@sirma.com"));
	}
}
