package com.sirma.itt.javacourse.networkingandgui.reverse;

/**
 * Holds the last sent items from the client.
 * 
 * @author gdimitrov
 */
public class Memento {
	private final String state;

	/**
	 * @param state
	 *            the state of the object at the given point.
	 */
	protected Memento(String state) {
		this.state = state;
	}

	/**
	 * Getter method for state.
	 * 
	 * @return the state
	 */
	protected String getState() {
		return state;
	}

}
