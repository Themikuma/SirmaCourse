package com.sirma.itt.javacourse.exceptions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Runs a program that uses an object list.
 * 
 * @author gdimitrov
 */
public final class RunObjectList {
	/**
	 * Private constructor for a utility class.
	 */
	private RunObjectList() {
	}

	/**
	 * Uses the object list to add different objects.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		ObjectList list = new ObjectList(5);
		Stack<Integer> element3 = new Stack<>();
		ArrayList<Integer> element2 = new ArrayList<>();
		Throwable throwable = new Throwable("exception");

		element2.add(4);
		element2.add(3);
		element2.add(4);
		element3.add(6);
		element3.add(2);

		list.addElement(null);
		list.addElement(element2);
		list.addElement(element3);
		list.addElement(throwable);

		list.printAllElements();
	}
}
