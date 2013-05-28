package com.sirma.itt.javacourse.designpatterns.interpreter;

/**
 * The iterator for {@link List}.
 * 
 * @param <T>
 *            The type of the list that is being iterated over.
 * @author gdimitrov
 */
public class ListIterator<T> implements Iterator<T> {

	private List<T> list;
	private int current;

	/**
	 * Stores the list that is being iterated over as a private property.
	 * 
	 * @param list
	 *            the list, being iterated.
	 */
	public ListIterator(List<T> list) {
		this.list = list;
		current = 0;
	}

	@Override
	public void first() {
		current = 0;
	}

	@Override
	public void next() {
		current++;
	}

	@Override
	public T getCurrent() {
		return list.get(current);
	}

}
