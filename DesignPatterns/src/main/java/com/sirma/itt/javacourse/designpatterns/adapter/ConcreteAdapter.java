package com.sirma.itt.javacourse.designpatterns.adapter;

/**
 * Uses the legacy rectangle to draw a rectangle. This is done so we can reuse the complex drawing
 * methods of the old rectangle.
 * 
 * @author gdimitrov
 */
public class ConcreteAdapter implements Adapter {

	@Override
	public void draw(int x1, int y1, int x2, int y2) {
		LegacyRectangle rectangle = new LegacyRectangle();
		rectangle.draw(x2, y1, x2 - x1, y1 - y2);
	}

}
