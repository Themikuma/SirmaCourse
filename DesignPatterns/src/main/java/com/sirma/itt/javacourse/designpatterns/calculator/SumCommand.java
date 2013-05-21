package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * A concrete implementation of the sum command.
 * 
 * @author gdimitrov
 */
public class SumCommand extends Command {

	@Override
	public double execute(String input) {
		String[] operands = input.split("[+]");
		double sum = 0;
		for (String string : operands) {
			sum += Double.parseDouble(string);
		}
		return sum;
	}

}
