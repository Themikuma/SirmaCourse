/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.bridge;

/**
 * @author Georgi
 */
public class RefinedAbstraction extends Abstraction {

	/**
	 * Creates a refined abstraction.
	 * 
	 * @param worker
	 *            the worker that is going to be using the abstraction
	 */
	public RefinedAbstraction(Implementor worker) {
		super(worker);
	}

	/**
	 * Uses the doWork method to do some complex calculations.
	 * 
	 * @return some result after the work done.
	 */
	public int complexMethod() {
		int i = 0;
		i++;
		i += doWork();
		return i;
	}

}
