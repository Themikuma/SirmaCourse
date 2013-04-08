package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Sumator {

	public static int sum(int a, int b) {
		return a + b;
	}

	public double sum(double a, double b) {
		return a + b;
	}

	public static int sum(String a, String b) {
		int first = Integer.parseInt(a);
		int second = Integer.parseInt(b);
		return first + second;
	}

	public static BigInteger sum(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	public static BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

}
