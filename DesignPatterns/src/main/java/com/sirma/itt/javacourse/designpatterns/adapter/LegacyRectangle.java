package com.sirma.itt.javacourse.designpatterns.adapter;

/**
 * A legacy rectangle that uses a lower left point, width and height to draw a rectangle.
 * 
 * @author gdimitrov
 */
public class LegacyRectangle {

	/**
	 * Draws a rectangle using the given parameters.
	 * 
	 * @param x
	 *            the x of the lower left point of the rectangle.
	 * @param y
	 *            the y of the lower left point of the rectangle.
	 * @param w
	 *            the width of the rectangle.
	 * @param h
	 *            the height of the rectangle.
	 */
	public void draw(int x, int y, int w, int h) {
		// Complex drawing stuff go here.
	}
}
