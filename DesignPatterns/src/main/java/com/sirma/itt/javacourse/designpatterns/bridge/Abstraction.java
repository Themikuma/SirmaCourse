/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.bridge;

/**
 * This abstraction decouples the methods from their actual implementations and lets different
 * implementations be used depending on the constructor.
 * 
 * @author Georgi
 */
public abstract class Abstraction {
	private Implementor worker;

	/**
	 * Creates an abstraction that uses a worker which implements {@link Implementor} interface.
	 * 
	 * @param worker
	 *            an object implementing {@link Implementor} interface.
	 */
	public Abstraction(Implementor worker) {
		this.worker = worker;
	}

	/**
	 * Does some sort of work.
	 * 
	 * @return the result of the work.
	 */
	public int doWork() {
		return worker.doSomeWork();
	}

	/**
	 * Does some more work.
	 */
	public void doMoreWork() {
		worker.doMoreWork();
	}
}
