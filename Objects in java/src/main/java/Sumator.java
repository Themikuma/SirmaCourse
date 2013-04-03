package main.java;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Sumator {

	public int sum(int a, int b) {
		return a + b;
	}

	public double sum(double a, double b) {
		return a + b;
	}

	public String sum(String a, String b) {
		return a + b;
	}

	public BigInteger sum(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	public BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

}
