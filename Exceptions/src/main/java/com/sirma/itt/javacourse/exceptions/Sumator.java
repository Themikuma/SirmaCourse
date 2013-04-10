package com.sirma.itt.javacourse.exceptions;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The sumator class can provides functionality for getting the sum of two nubers.
 * 
 * @author gdimitrov
 */
public final class Sumator {
	/**
	 * Private constructor for a utility class.
	 */
	private Sumator() {
	}

	/**
	 * Gets the sum of two given integer numbers.
	 * 
	 * @param a
	 *            first number.
	 * @param b
	 *            second number.
	 * @return the sum of the integers.
	 */
	public static int sum(int a, int b) {
		return a + b;
	}

	/**
	 * Gets the sum of two given real numbers.
	 * 
	 * @param a
	 *            first number.
	 * @param b
	 *            second number.
	 * @return the sum of the integers.
	 */
	public static double sum(double a, double b) {
		return a + b;
	}

	/**
	 * Gets the sum of two numbers represented as strings.
	 * 
	 * @param a
	 *            first number.
	 * @param b
	 *            second number.
	 * @return the sum of the integers.
	 */
	public static int sum(String a, String b) {
		int first = 0;
		int second = 0;
		try {
			first = Integer.parseInt(a);
			second = Integer.parseInt(b);
		} catch (NumberFormatException e) {
			System.out.println("There was a parse error: " + e.getMessage());
		}
		return first + second;
	}

	/**
	 * Gets the sum of two given big integer numbers.
	 * 
	 * @param a
	 *            first number.
	 * @param b
	 *            second number.
	 * @return the sum of the integers.
	 */
	public static BigInteger sum(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	/**
	 * Gets the sum of two given big decimal numbers.
	 * 
	 * @param a
	 *            first number.
	 * @param b
	 *            second number.
	 * @return the sum of the integers.
	 */
	public static BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

}
