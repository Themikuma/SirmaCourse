package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author gdimitrov
 */
public class Sumator {
	/**
	 * Sums two integer numbers.
	 * 
	 * @param a
	 *            first number
	 * @param b
	 *            second number
	 * @return the sum of the two numbers
	 */
	public static int sum(int a, int b) {
		return a + b;
	}

	/**
	 * Sums two real numbers.
	 * 
	 * @param a
	 *            first number
	 * @param b
	 *            second number
	 * @return the sum of the two numbers
	 */
	public double sum(double a, double b) {
		return a + b;
	}

	/**
	 * Sums two numbers represented by strings.
	 * 
	 * @param a
	 *            first number
	 * @param b
	 *            second number
	 * @return the sum of the two numbers
	 */
	public static int sum(String a, String b) {
		int first = Integer.parseInt(a);
		int second = Integer.parseInt(b);
		return first + second;
	}

	/**
	 * Sums two big integers.
	 * 
	 * @param a
	 *            first number
	 * @param b
	 *            second number
	 * @return the sum of the two numbers
	 */
	public static BigInteger sum(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	/**
	 * Sums two big decimal numbers.
	 * 
	 * @param a
	 *            first number
	 * @param b
	 *            second number
	 * @return the sum of the two numbers
	 */
	public static BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

}
