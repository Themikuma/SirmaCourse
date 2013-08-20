package com.sirmaitt.javacourse.chatapplication.server;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Represents a client as the server sees one.
 * 
 * @author gdimitrov
 */
public class Client {

	private final String nickname;
	private final PrintWriter writer;

	/**
	 * Creates a new client.
	 * 
	 * @param nickname
	 *            the nickname of the client.
	 * @param out
	 *            the output stream of the client.
	 */
	public Client(String nickname, OutputStream out) {
		this.nickname = nickname;
		writer = new PrintWriter(out, true);
	}

	/**
	 * Sends the message to the client.
	 * 
	 * @param message
	 *            the message to send.
	 */
	public void sendMessage(String message) {
		writer.println(message);
	}

	@Override
	public boolean equals(Object obj) {
		Client client = (Client) obj;
		if (client.hashCode() == 0) {
			return true;
		}
		return nickname.toLowerCase().equals(client.nickname.toLowerCase());
	}

	@Override
	public int hashCode() {
		if (nickname.toLowerCase().contains("admin") || nickname.contains("]")
				|| nickname.contains("[") || nickname.length() < 4) {
			return 0;
		}
		return nickname.hashCode();
	}

	@Override
	public String toString() {
		return nickname.toString() + " ";
	}
}
