package com.sirma.itt.javacourse.designpatterns.memento;

/**
 * The memento that is going to store the ball's states.
 * 
 * @author gdimitrov
 */
public class BallMemento {
	private final int x;
	private final int y;

	/**
	 * Getter method for y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter method for x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Saves the current state of the ball.
	 * 
	 * @param x
	 *            the x coordinate of the ball.
	 * @param y
	 *            the y coordinate of the ball.
	 */
	public BallMemento(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
