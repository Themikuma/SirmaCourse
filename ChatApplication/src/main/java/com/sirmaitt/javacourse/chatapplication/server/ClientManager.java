package com.sirmaitt.javacourse.chatapplication.server;

import java.util.HashSet;
import java.util.Set;

/**
 * Manages the clients that are connected to the server. Provides functions for adding and removing
 * clients and broadcasting messages to all the clients.
 * 
 * @author gdimitrov
 */
public class ClientManager {
	private Set<Client> clients;

	/**
	 * Initializes the member variables.
	 */
	public ClientManager() {
		clients = new HashSet<>();
	}

	/**
	 * Creates a new client and tries to add it to the clients set. If there is a user with the same
	 * nickname the adding fails.
	 * 
	 * @param client
	 *            the client to add.
	 * @return true if the client was successfully added.
	 */
	public boolean addClient(Client client) {
		return clients.add(client);
	}

	/**
	 * Removes the given client from the clients set and stops sending messages to it.
	 * 
	 * @param client
	 *            the client to remove.
	 */
	public void removeClient(Client client) {
		clients.remove(client);
	}

	/**
	 * Getter method for clients.
	 * 
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

}
