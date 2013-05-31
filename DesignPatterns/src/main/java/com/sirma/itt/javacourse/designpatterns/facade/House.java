/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.facade;

/**
 * Represents a house that is created by drawing a square and a triangle in a specific way.
 * 
 * @author Georgi
 */
public class House {

	/**
	 * Draws a house using {@link Triangle} and {@link Square}. The house is drawn by given a
	 * central point and the size of the walls. The size of the roof is calculated depending on the
	 * size of the walls.
	 * 
	 * @param x1
	 *            x of the center point
	 * @param y1
	 *            y of the center point
	 * @param size
	 *            size of the walls
	 */
	public void drawHouse(int x1, int y1, int size) {
		int remainder = 0;
		if (size % 2 != 0) {
			remainder = 1;
		}
		Square square = new Square();
		square.draw(x1 - size / 2, y1 + size / 2, x1 + size / 2 + remainder, y1 - size / 2
				+ remainder);
		int xRoofCenter = x1;
		int yRoofCenter = y1 + size / 2;
		int roofWidth = size + size / 2;
		int roofHeight = size / 2;
		Triangle triangle = new Triangle();
		triangle.draw(xRoofCenter - roofWidth / 2, yRoofCenter, xRoofCenter + roofWidth / 2,
				yRoofCenter, xRoofCenter, yRoofCenter + roofHeight);
	}
}
