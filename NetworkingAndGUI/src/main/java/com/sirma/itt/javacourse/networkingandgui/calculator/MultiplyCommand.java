package com.sirma.itt.javacourse.networkingandgui.calculator;

/**
 * A concrete implementation of the multiply command.
 * 
 * @author gdimitrov
 */
public class MultiplyCommand extends Command {

	@Override
	public double execute(String input) {
		String[] operands = input.split("[*]");
		double result = 1;
		for (String string : operands) {
			result *= Double.parseDouble(string);
		}
		return result;
	}

}
