package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The calculator client. It creates a concrete command object and executes a command on it.
 * 
 * @author gdimitrov
 */
public class Client {
	/**
	 * Creates an instance of one of the concrete commands based on the operation given in the
	 * expression.
	 * 
	 * @param expression
	 *            the expression to process.
	 * @return the result of the expression.
	 */
	public double execute(String expression) {
		Command command = null;
		if (expression.contains("+")) {
			command = CommandFactory.createInstance(0);
		}
		if (expression.contains("-")) {
			command = CommandFactory.createInstance(1);
		}
		return command.execute(expression);
	}
}
