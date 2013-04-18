package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests the functions used to hide a valid Bulgarian IBAN.
 * 
 * @author gdimitrov
 */
public class TestHideIBAN {
	/**
	 * Test the isValid function with a valid IBAN.
	 */
	@Test
	public void testIsValidWIthValidIBAN1() {
		assertTrue(HideIBAN.isValid("<iban>BG80 BNBG 9661 1020 3456 7840</iban>"));
	}

	/**
	 * Test the isValid function with a valid IBAN.
	 */
	@Test
	public void testIsValidWIthValidIBAN2() {
		assertTrue(HideIBAN.isValid("<iban>BG80 BNBG 9661 1020 3456 3256</iban>"));
	}

	/**
	 * Test the isValid function with a valid IBAN.
	 */
	@Test
	public void testIsValidWIthValidIBAN3() {
		assertTrue(HideIBAN.isValid("<iban>BG25 BNBG 0000 1020 3456 7840</iban>"));
	}

	/**
	 * Test the isValid function with a valid IBAN.
	 */
	@Test
	public void testIsValidWIthValidIBAN4() {
		assertTrue(HideIBAN.isValid("<iban>BG80 BNBG 9661 1020 3456 7843</iban>"));
	}

	/**
	 * Test the isValid function with an invalid IBAN.
	 */
	@Test
	public void testIsValidWithInvalidIBAN1() {
		assertFalse(HideIBAN.isValid("<iban>GR16 0110 1050 0000 1054 7023 795</iban>"));
	}

	/**
	 * Test the isValid function with an invalid IBAN.
	 */
	@Test
	public void testIsValidWithInvalidIBAN2() {
		assertFalse(HideIBAN.isValid("<iban>GB35 MIBG 4025 3432 1446 70</iban>"));
	}

	/**
	 * Test the isValid function with an invalid IBAN.
	 */
	@Test
	public void testIsValidWithInvalidIBAN3() {
		assertFalse(HideIBAN.isValid("<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>"));
	}

	/**
	 * Test the isValid function with an invalid IBAN.
	 */
	@Test
	public void testIsValidWithInvalidIBAN4() {
		assertFalse(HideIBAN.isValid("<iban>GR16 0110 1050 0000 1054 7023 795</iban>"));
	}

	/**
	 * Test hideIBAN with a valid IBAN.
	 */
	@Test
	public void testHideIBANWithValidIBAN1() {
		assertEquals(HideIBAN.hideIBAN("<iban>BG80 BNBG 9661 1020 3456 7843</iban>"),
				"<iban>****7843</iban>");
	}

	/**
	 * Test hideIBAN with a valid IBAN.
	 */
	@Test
	public void testHideIBANWithValidIBAN2() {
		assertEquals(HideIBAN.hideIBAN("<iban>BG80 BNBG 9661 1020 3456 7840</iban>"),
				"<iban>****7840</iban>");
	}
}
