package com.sirma.itt.javacourse.designpatterns.memento;

import java.util.Stack;

/**
 * The caretaker that moves the ball around.
 * 
 * @author gdimitrov
 */
public class Caretaker {
	private Ball ball;
	private Stack<BallMemento> states;

	/**
	 * Creates a new ball to play around with.
	 */
	public Caretaker() {
		ball = new Ball();
		states = new Stack<>();
	}

	/**
	 * Moves the ball to a new position.
	 * 
	 * @param x
	 *            the new x position.
	 * @param y
	 *            the new y position.
	 */
	public void move(int x, int y) {
		states.add(ball.saveState());
		ball.move(x, y);
	}

	/**
	 * Reverts the last action.
	 */
	public void undo() {
		if (!states.isEmpty()) {
			ball.revertState(states.pop());
		}
	}
}
