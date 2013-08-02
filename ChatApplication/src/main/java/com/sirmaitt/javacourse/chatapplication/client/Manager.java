package com.sirmaitt.javacourse.chatapplication.client;

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

	/**
	 * Starts the reconnect procedure when the client disconnects.
	 */
	void reconnect();

}
