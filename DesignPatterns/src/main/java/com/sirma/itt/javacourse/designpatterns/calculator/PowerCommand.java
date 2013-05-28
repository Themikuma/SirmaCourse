package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * Concrete implementation of the power command.
 * 
 * @author gdimitrov
 */
public class PowerCommand extends Command {

	@Override
	public double execute(String input) {
		String[] operands = input.split("\\^");
		double result = Double.parseDouble(operands[0]);
		result = Math.pow(result, Double.parseDouble(operands[1]));
		return result;
	}

}
