package com.sirma.itt.javacourse.networkingandgui.reverse;

/**
 * Creates a memento for the client.
 * 
 * @author gdimitrov
 */
public final class StateManager extends MessageState {

	/**
	 * Private constructor for utility class.
	 * 
	 * @param state
	 *            the state of the memento.
	 */
	private StateManager(String state) {
		super(state);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a memento using the given state.
	 * 
	 * @param state
	 *            the current state of the object.
	 * @return a memento.
	 */
	public static MessageState createMemento(String state) {
		return new MessageState(state);
	}

	/**
	 * Gets the state of the current memento.
	 * 
	 * @param memento
	 *            the state of the object in a previous time.
	 * @return a string that shows the state of the object.
	 */
	public static String getState(MessageState memento) {
		return memento.getState();
	}
}
