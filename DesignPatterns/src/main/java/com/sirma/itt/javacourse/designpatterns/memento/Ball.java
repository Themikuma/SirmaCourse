package com.sirma.itt.javacourse.designpatterns.memento;

/**
 * The ball that is going to fly around.
 * 
 * @author gdimitrov
 */
public class Ball {
	private int x;
	private int y;

	/**
	 * Saves the current state of the ball.
	 * 
	 * @return returns a memento of the current state of the ball.
	 */
	public BallMemento saveState() {
		return new BallMemento(x, y);
	}

	/**
	 * Sets a position for the ball.
	 * 
	 * @param x
	 *            the new x position of the ball.
	 * @param y
	 *            the new y position of the ball.
	 */
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Sets the current state of the ball using a ball memento.
	 * 
	 * @param ballMemento
	 *            the previous state of the ball.
	 */
	public void revertState(BallMemento ballMemento) {
		x = ballMemento.getX();
		y = ballMemento.getY();
	}

}
