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
		assertEquals(calculator.execute("12+5+2"), 19, 3);
	}

}
