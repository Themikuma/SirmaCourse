package com.sirma.itt.javacourse.designpatterns.strategy;

/**
 * @author gdimitrov
 */
public class Context {

	private Strategy algorithms;

	/**
	 * Creates an instance of the client class that uses one of the strategies.
	 * 
	 * @param algorithms
	 *            - a concrete implementation of the strategy.
	 */
	public Context(Strategy algorithms) {
		this.algorithms = algorithms;
	}

	/**
	 * Executes the current algorithm.
	 */
	public void execute() {
		algorithms.execute();
	}
}
