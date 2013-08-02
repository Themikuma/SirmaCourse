/**
 * 
 */
package com.sirmaitt.javacourse.chatapplication.utility;

/**
 * Holds all the messsages used to communicate between the server and the client.
 * 
 * @author Georgi
 */
public enum Messages {
	ERROR, CONNECTED_, DISCONNECTED, LIST;
	@Override
	public String toString() {
		return "." + super.toString();
	}
}
