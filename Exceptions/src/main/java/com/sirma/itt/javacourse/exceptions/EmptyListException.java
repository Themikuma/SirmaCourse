package com.sirma.itt.javacourse.exceptions;

/**
 * An exception that is thrown when an element is removed from an empty list.
 * 
 * @author gdimitrov
 */
public class EmptyListException extends RuntimeException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 7132637370963830574L;

	/**
	 * Default constructor for the exception.
	 */
	public EmptyListException() {
		super();
	}

	/**
	 * Constructor using a message.
	 * 
	 * @param message
	 *            the message to give to the exception.
	 */
	public EmptyListException(String message) {
		super(message);
	}
}
