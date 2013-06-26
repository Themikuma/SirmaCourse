package com.sirma.itt.javacourse.networkingandgui.calculator;

/**
 * A concrete implementation of the subtract command.
 * 
 * @author gdimitrov
 */
public class SubtractCommand extends Command {

	@Override
	public double execute(String input) {
		String[] operands = input.split("[-]");
		double result = Double.parseDouble(operands[0]);
		for (int i = 1; i < operands.length; i++) {
			result -= Double.parseDouble(operands[i]);
		}
		return result;
	}

}
