package com.sirma.itt.javacourse.networkingandgui.clientserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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
		System.out.println("Searching for an open port ");

		Socket socket = null;

		for (int i = 7000; i < 7020; i++) {
			try {
				socket = new Socket("localhost", i);
				break;
			} catch (UnknownHostException e) {
			} catch (IOException e) {
			}
		}
		if (socket == null) {
			System.out.println("Couldn't find an open port. Shutting down");
			return;
		}
		System.out.println("Connected");
		try {
			socket.close();
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
