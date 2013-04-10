package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

/**
 * The tests on the custom sumator.
 * 
 * @author gdimitrov
 */
public class SumatorTest {
	private Sumator sumator;

	/**
	 * Setup for the tests.
	 */
	@Before
	public void setup() {
		sumator = new Sumator();
	}

	/**
	 * Test the integer sumator.
	 */
	@Test
	public void testSumInt() {
		int a = 4;
		int b = 7;
		assertEquals(11, Sumator.sum(a, b));
	}

	/**
	 * Test the real numbers sumator.
	 */
	@Test
	public void testSumReal() {
		double a = 4.3;
		double b = 5.6;
		assertEquals(9.9, sumator.sum(a, b), 0.0000000001);
	}

	/**
	 * Test the strings sumator.
	 */
	@Test
	public void testSumString() {
		String a = "111";
		String b = "111";
		assertEquals(222, Sumator.sum(a, b));
	}

	/**
	 * Test the BigInteger sumator.
	 */
	@Test
	public void testSumBigInteger() {
		BigInteger a = new BigInteger("1111111111");
		BigInteger b = new BigInteger("1111111111");
		BigInteger expectedSum = new BigInteger("2222222222");
		assertEquals(expectedSum, Sumator.sum(a, b));
	}

	/**
	 * Test the BigDecimal sumator.
	 */
	@Test
	public void testSumBigDecimal() {
		BigDecimal a = new BigDecimal("1111111111");
		BigDecimal b = new BigDecimal("1111111111");
		BigDecimal expectedSum = new BigDecimal("2222222222");
		assertEquals(expectedSum, Sumator.sum(a, b));
	}
}
