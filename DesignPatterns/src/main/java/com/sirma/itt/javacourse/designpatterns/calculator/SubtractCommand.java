package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * A concrete implementation of the subtract command.
 * 
 * @author gdimitrov
 */
public class SubtractCommand extends Command {

	@Override
	public double execute(String input) {
		String[] operands = input.split("[-]");
		double sum = Double.parseDouble(operands[0]);
		for (int i = 1; i < operands.length; i++) {
			sum -= Double.parseDouble(operands[i]);
		}
		return sum;
	}

}
