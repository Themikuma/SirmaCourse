package com.sirma.itt.javacourse.networkingandgui.clientserver;

import java.io.IOException;
import java.net.Socket;

import com.sirma.itt.javacourse.networkingandgui.util.ServerFinder;

/**
 * The client class, used to connect to the server.
 * 
 * @author gdimitrov
 */
public class Client {
	/**
	 * Runs the client communication with the server.
	 */
	public void runClient() {
		try (Socket socket = ServerFinder.findServer()) {
			if (socket == null) {
				System.out.println("Couldn't find an open port. Shutting down");
				return;
			}
		} catch (IOException e) {
			throw new RuntimeException("Coudldn't close the streams");
		}
	}

	/**
	 * Creates a client that uses a server to communicate.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method.
	 */
	public static void main(String[] args) {
		Client client = new Client();
		client.runClient();
	}
}
