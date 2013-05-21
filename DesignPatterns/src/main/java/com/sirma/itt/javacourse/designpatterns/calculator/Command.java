package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The abstract command class. It declares an interface for executing operations, as well as a
 * receiver variable.
 * 
 * @author gdimitrov
 */
public abstract class Command {

	/**
	 * Executes the implementing class's command.
	 * 
	 * @param input
	 *            the user input.
	 * @return the result of the action.
	 */
	public abstract double execute(String input);
}
