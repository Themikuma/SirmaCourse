package com.sirma.itt.javacourse.designpatterns.strategy;

/**
 * The implementations of this interface give different concrete algorithms for implementing the
 * strategy.
 * 
 * @author gdimitrov
 */
public interface Strategy {

	/**
	 * A method that needs to have 2 or more implementations that need to be swaped quickly.
	 */
	void execute();
}
