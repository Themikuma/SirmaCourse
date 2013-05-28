package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * Creates a concrete command object that executes the operation.
 * 
 * @author gdimitrov
 */
public final class CommandFactory {

	/**
	 * Private constructor for utility classes.
	 */
	private CommandFactory() {
	}

	/**
	 * Creates an instance of a concrete command based on the operation number.
	 * 
	 * @param operationNumber
	 *            the operation which is to be called.
	 * @return a concrete command implementation.
	 */
	public static Command createInstance(int operationNumber) {
		switch (operationNumber) {
			case 0:
				return new SumCommand();
			case 1:
				return new SubtractCommand();
			case 2:
				return new MultiplyCommand();
			case 3:
				return new DivisionCommand();
			case 4:
				return new PowerCommand();
			default:
				break;
		}
		return null;
	}

}
