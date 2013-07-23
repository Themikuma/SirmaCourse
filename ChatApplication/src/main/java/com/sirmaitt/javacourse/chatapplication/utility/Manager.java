package com.sirmaitt.javacourse.chatapplication.utility;

/**
 * A manager that logs the results from the chat in a way.
 * 
 * @author gdimitrov
 */
public interface Manager {

	/**
	 * Displays the message.
	 * 
	 * @param message
	 *            the message to display.
	 */
	void displayMessage(String message);

	/**
	 * Displays the user list.
	 * 
	 * @param message
	 *            the user list that was recieved from the server.
	 */
	void displayUserList(String message);

}
