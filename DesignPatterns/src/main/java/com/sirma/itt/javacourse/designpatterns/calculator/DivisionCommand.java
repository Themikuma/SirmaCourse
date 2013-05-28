package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * Concrete implementation of the division command.
 * 
 * @author gdimitrov
 */
public class DivisionCommand extends Command {

	@Override
	public double execute(String input) {
		String[] operands = input.split("[/]");
		double result = Double.parseDouble(operands[0]);
		for (int i = 1; i < operands.length; i++) {
			if (Double.parseDouble(operands[i]) == 0) {
				continue;
			}
			result /= Double.parseDouble(operands[i]);
		}
		return result;
	}
}
