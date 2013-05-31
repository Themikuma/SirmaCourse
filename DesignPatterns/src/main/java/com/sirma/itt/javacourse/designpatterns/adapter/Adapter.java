package com.sirma.itt.javacourse.designpatterns.adapter;

/**
 * Creates a common interface for the legacy rectangle and the new rectangle.
 * 
 * @author gdimitrov
 */
public interface Adapter {

	/**
	 * Draw function that uses the legacy rectangle's draw.
	 * 
	 * @param x1
	 *            the x of the upper left point of the rectangle.
	 * @param y1
	 *            the y of the upper left point of the rectangle.
	 * @param x2
	 *            the x of the lower right point of the rectangle.
	 * @param y2
	 *            the y of the lower right point of the rectangle.
	 */
	void draw(int x1, int y1, int x2, int y2);
}
