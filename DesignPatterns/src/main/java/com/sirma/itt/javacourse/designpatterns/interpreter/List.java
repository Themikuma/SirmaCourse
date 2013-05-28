package com.sirma.itt.javacourse.designpatterns.interpreter;

/**
 * @author gdimitrov
 * @param <T>
 *            The type of the list.
 */
public class List<T> implements AbstractList<T> {

	@Override
	public ListIterator<T> createIterator() {
		return new ListIterator<>(this);
	}

	@Override
	public void add() {
	}

	@Override
	public T get(int index) {
		return null;
	}

}
