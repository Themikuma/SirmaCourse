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
	private StringBuilder clientNicknames;
	public static final String CLIENT_SEPARATOR = "_";

	/**
	 * Initializes the member variables.
	 */
	public ClientManager() {
		clients = new HashSet<>();
		// clients.add(new Client("admin", System.out));
	}

	/**
	 * Creates a new client and tries to add it to the clients set. If there is a user with the same
	 * nickname the adding fails.
	 * 
	 * @param client
	 *            the client to add.
	 * @return true if the client was successfully added.
	 */
	public synchronized boolean addClient(Client client) {
		if (clients.add(client)) {
			return true;
		}
		return false;
	}

	/**
	 * Removes the given client from the clients set and stops sending messages to it.
	 * 
	 * @param client
	 *            the client to remove.
	 */
	public synchronized void removeClient(Client client) {
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

	/**
	 * Broadcasts a message to all the clients.
	 * 
	 * @param message
	 *            the message to be broadcasted.
	 */
	public synchronized void broadcastMessage(String message) {
		for (Client client : clients) {
			client.sendMessage(message);
		}
	}

	/**
	 * Getter method for clientNicknames.
	 * 
	 * @return the clientNicknames
	 */
	public synchronized StringBuilder getClientNicknames() {
		clientNicknames = new StringBuilder();
		for (Client client : clients) {
			clientNicknames.append(client + CLIENT_SEPARATOR);
		}
		clientNicknames.deleteCharAt(clientNicknames.length() - 1);
		return clientNicknames;
	}
}
