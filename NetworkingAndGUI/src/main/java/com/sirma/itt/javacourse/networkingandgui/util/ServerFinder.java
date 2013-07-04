package com.sirma.itt.javacourse.networkingandgui.util;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This is a utility class that provides methods that are used to connect clients to servers.
 * 
 * @author gdimitrov
 */
public final class ServerFinder {

	/**
	 * Private constructor for utility class.
	 */
	private ServerFinder() {
	}

	/**
	 * Searches a range of ports and uses the first one that holds a server.
	 * 
	 * @return the socket for the server or null if a server wasn't found in the port range.
	 */
	public static Socket findServer() {
		Socket socket = null;
		for (int i = 7000; i < 7020; i++) {
			try {
				socket = new Socket("localhost", i);
				break;
			} catch (UnknownHostException e) {
			} catch (IOException e) {
			}
		}
		return socket;
	}
}
