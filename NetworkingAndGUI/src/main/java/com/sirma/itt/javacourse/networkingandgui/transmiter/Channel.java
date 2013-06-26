package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Holds the clients which recieve the broadcasts on this channel.
 * 
 * @author gdimitrov
 */
public class Channel {
	private ArrayList<PrintWriter> clients;

	/**
	 * Creates a new broadcast channel.
	 */
	public Channel() {
		clients = new ArrayList<>();
	}

	/**
	 * Getter method for clients.
	 * 
	 * @return the clients
	 */
	public ArrayList<PrintWriter> getClients() {
		return clients;
	}

	/**
	 * Adds the input stream for the current client to the clients of this channel.
	 * 
	 * @param client
	 *            the stream to add.
	 */
	public void addClient(PrintWriter client) {
		clients.add(client);
	}

}
