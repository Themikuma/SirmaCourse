package com.sirma.itt.javacourse.exceptions;

/**
 * A list with a fixed length, that can take objects.
 * 
 * @author gdimitrov
 */
public class ObjectList {
	private Object[] list;
	private int currentObject;

	/**
	 * Constructor that takes the number of elements the list will have.
	 * 
	 * @param numberOfElements
	 *            how many elements the list will have.
	 */
	public ObjectList(int numberOfElements) {
		list = new Object[numberOfElements];
		currentObject = 0;
	}

	/**
	 * Method to add an element to the list.
	 * 
	 * @param obj
	 *            the element to add.
	 * @return true if the element was added.
	 */
	public boolean addElement(Object obj) {
		try {
			list[currentObject] = obj;
			currentObject++;
		} catch (Exception e) {
			throw new IndexOutOfBoundsException("Index was out of bounds");
		}
		return true;
	}

	/**
	 * Remove the last element in the list.
	 * 
	 * @return true if an element was removed
	 */
	public boolean remove() {
		if (currentObject == 0) {
			throw new EmptyListException("There were no elements to remove.");
		}
		list[currentObject] = null;
		currentObject--;
		return true;
	}

	/**
	 * Print all the elements of the list.
	 */
	public void printAllElements() {
		for (int i = 0; i < currentObject; i++) {
			System.out.println(list[i]);
		}
	}
}
