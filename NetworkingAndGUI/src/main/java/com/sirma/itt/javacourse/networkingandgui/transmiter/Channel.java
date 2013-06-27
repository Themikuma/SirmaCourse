package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Holds the clients which recieve the broadcasts on this channel.
 * 
 * @author gdimitrov
 */
public class Channel {
	private ArrayList<OutputStream> clients;

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
	public ArrayList<OutputStream> getClients() {
		return clients;
	}

	/**
	 * Adds the output stream for the current client to the clients of this channel.
	 * 
	 * @param client
	 *            the stream to add.
	 */
	public void addClient(OutputStream client) {
		clients.add(client);
	}

	/**
	 * Removes the client's stream from the clients listening to this channel.
	 * 
	 * @param client
	 *            - the client to be removed.
	 * @return true if the stream was found and removed.
	 */
	public boolean removeClient(OutputStream client) {
		if (clients.contains(client)) {
			clients.remove(client);
			return true;
		}
		return false;
	}

}
