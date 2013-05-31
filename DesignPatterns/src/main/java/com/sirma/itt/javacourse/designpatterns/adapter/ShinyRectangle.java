package com.sirma.itt.javacourse.designpatterns.adapter;

/**
 * This is the shiny new rectangle that uses 2 points instead of one point, widhth and height to
 * draw a rectangle.
 * 
 * @author gdimitrov
 */
public class ShinyRectangle {

	/**
	 * Draw function that uses upper left and lower right point to draw a rectangle.
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
	void draw(int x1, int y1, int x2, int y2) {
		Adapter adapter = new ConcreteAdapter();
		adapter.draw(x1, y1, x2, y2);
	}

}
