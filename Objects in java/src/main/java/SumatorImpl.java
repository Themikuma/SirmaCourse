package main.java;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SumatorImpl implements Sumator {

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public double sum(double a, double b) {
		return a + b;
	}

	@Override
	public String sum(String a, String b) {
		return a + b;
	}

	@Override
	public BigInteger sum(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	@Override
	public BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

}
