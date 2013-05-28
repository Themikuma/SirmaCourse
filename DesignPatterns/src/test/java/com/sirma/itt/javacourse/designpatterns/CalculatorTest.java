package com.sirma.itt.javacourse.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.designpatterns.calculator.Client;

/**
 * Tests the calculator made using the command design pattern.
 * 
 * @author gdimitrov
 */
public class CalculatorTest {

	/**
	 * Test the sum function of the calculator.
	 */
	@Test
	public void testSum() {
		Client calculator = new Client();
		assertEquals(calculator.execute("12+5+2.1"), 19.1, 3);
	}

	/**
	 * Test the subtract function of the calculator.
	 */
	@Test
	public void testSubtract() {
		Client calculator = new Client();
		assertEquals(calculator.execute("16.2-2.2"), 14, 3);
	}

	/**
	 * Test the multiply function of the calculator.
	 */
	@Test
	public void testMultiply() {
		Client calculator = new Client();
		assertEquals(14, calculator.execute("2*3.5*2"), 3);
	}

	/**
	 * Test the divide function of the calculator.
	 */
	@Test
	public void testDivide() {
		Client calculator = new Client();
		assertEquals(2, calculator.execute("28/2/7"), 3);
	}

	/**
	 * Test the power function of the calculator.
	 */
	@Test
	public void testPower() {
		Client calculator = new Client();
		assertEquals(16, calculator.execute("4^2"), 3);
	}
}
