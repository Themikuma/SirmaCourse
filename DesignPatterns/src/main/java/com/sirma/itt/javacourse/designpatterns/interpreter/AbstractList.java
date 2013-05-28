package com.sirma.itt.javacourse.designpatterns.interpreter;

/**
 * The interface of the list that is going to be iterated over.
 * 
 * @param <T>
 *            The type of the list.
 * @author gdimitrov
 */
public interface AbstractList<T> {

	/**
	 * Creates an iterator for the list.
	 * 
	 * @return returns an iterator implementing the {@link Iterator} interface.
	 */
	Iterator<T> createIterator();

	/**
	 * Adds an item to the list.
	 */
	void add();

	/**
	 * Gets the item at the selected index.
	 * 
	 * @param index
	 *            the index of the item to return.
	 * @return the item by index.
	 */
	T get(int index);
}
