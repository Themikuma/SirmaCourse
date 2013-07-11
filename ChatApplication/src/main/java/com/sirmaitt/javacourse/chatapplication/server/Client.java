package com.sirmaitt.javacourse.chatapplication.server;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Represents a client as the server sees one.
 * 
 * @author gdimitrov
 */
public class Client {

	private String nickname;
	private PrintWriter writer;

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
		writer = new PrintWriter(out);
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
		return nickname.equals(client.nickname);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return nickname.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nickname.toString();
	}
}
