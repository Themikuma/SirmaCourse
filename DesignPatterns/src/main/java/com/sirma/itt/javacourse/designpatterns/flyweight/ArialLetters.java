/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.flyweight;

/**
 * Combines all the letters in a hierarchy.
 * 
 * @author Georgi
 */
public interface ArialLetters {

	/**
	 * Uses the position provided by the arguments to put the letter in the document.
	 * 
	 * @param row
	 *            the row in the document on which the letter to be placed.
	 * @param position
	 *            the position in the document.
	 */
	void useLetter(int row, int position);
}
