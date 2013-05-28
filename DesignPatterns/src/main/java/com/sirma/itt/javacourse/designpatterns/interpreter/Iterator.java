package com.sirma.itt.javacourse.designpatterns.interpreter;

/**
 * The interface for the iterators.
 * 
 * @param <T>
 *            The type of the list.
 * @author gdimitrov
 */
public interface Iterator<T> {

	/**
	 * Points the iterator to the first item of the list.
	 */
	void first();

	/**
	 * Points the iterator to the next item of the list.
	 */
	void next();

	/**
	 * Gets the current item.
	 * 
	 * @return the current item of the list.
	 */
	T getCurrent();

}
