package com.sirma.itt.javacourse.networkingandgui.calculator;

/**
 * A concrete implementation of the sum command.
 * 
 * @author gdimitrov
 */
public class SumCommand extends Command {

	@Override
	public double execute(String input) {
		String[] operands = input.split("[+]");
		double result = 0;
		for (String string : operands) {
			result += Double.parseDouble(string);
		}
		return result;
	}

}
