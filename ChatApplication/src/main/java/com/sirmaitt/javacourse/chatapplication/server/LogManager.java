package com.sirmaitt.javacourse.chatapplication.server;

/**
 * A manager that logs the results from the chat in a way.
 * 
 * @author gdimitrov
 */
public interface LogManager {

	/**
	 * Logs all significant events. Where the events are loged depends on the implementation.
	 * 
	 * @param message
	 *            the message to display.
	 */
	void logEvent(String message);

}
