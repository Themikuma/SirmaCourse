package com.sirma.itt.javacourse.designpatterns.templatemethod;

/**
 * The abstract class of the template method pattern.
 * 
 * @author gdimitrov
 */
public abstract class AbstractClass {
	/**
	 * Does part of the work that is common for all the implementing classes.
	 * 
	 * @param i
	 *            a number that will be used for the work.
	 */
	public void doSomeWork(int i) {
		int operand = i;
		operand = operand << 1;
	}

	/**
	 * The method that does the rest of the work depending on the implementing method.
	 * 
	 * @param operand
	 *            the operand on which to perform the actions.
	 * @return the new value of the operand.
	 */
	public abstract int doMoreWork(int operand);
}
