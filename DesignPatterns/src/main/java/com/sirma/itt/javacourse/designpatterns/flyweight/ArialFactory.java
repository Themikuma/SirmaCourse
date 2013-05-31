/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.flyweight;

import java.util.HashMap;

/**
 * Creates an instance of the Arial letters and lets the client use them.
 * 
 * @author Georgi
 */
public class ArialFactory {

	private final HashMap<String, ArialLetters> letters;

	/**
	 * Creates an arial factory and the hash map it uses to return letters.
	 */
	public ArialFactory() {
		letters = new HashMap<>();
	}

	/**
	 * Gets the object for the selected letter .
	 * 
	 * @param letter
	 *            the letter we want to use.
	 * @return the letter that was asked for or null if it wasn't one of the predefined letters.
	 */
	public ArialLetters getLetter(String letter) {
		ArialLetters result = letters.get(letter);
		if ("a".equals(letter)) {
			if (result == null) {
				letters.put("a", new ArialLetterA());
			}
		} else if ("b".equals(letter)) {
			if (result == null) {
				letters.put("b", new ArialLetterB());
			}
		}
		return result;
	}
}
