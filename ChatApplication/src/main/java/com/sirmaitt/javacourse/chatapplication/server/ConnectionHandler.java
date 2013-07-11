package com.sirmaitt.javacourse.chatapplication.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * The server recieves messages and sends back the reversed messages.
 * 
 * @author gdimitrov
 */
public class ConnectionHandler implements Runnable {

	private JTextArea log;
	private Socket clientSocket;
	private static final String SEPARATOR = System.lineSeparator();

	/**
	 * Creates a server that starts listening on the given port.
	 * 
	 * @param log
	 *            the log in which to log the data.
	 * @param clientSocket
	 *            the socket that the client uses to communicate with the server.
	 */
	public ConnectionHandler(JTextArea log, Socket clientSocket) {
		this.log = log;
		this.clientSocket = clientSocket;
	}

	/**
	 * Runs the server until told otherwise by the client.
	 */
	public void reverseMessages() {
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("Welcome to the server");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String line = null;
			StringBuilder reversedLine = null;
			while (true) {
				line = in.readLine();
				reversedLine = new StringBuilder(line);
				reversedLine = reversedLine.reverse();
				if (".".equals(line)) {
					log.append("A client has disconnected" + SEPARATOR);
					break;
				}
				log.append("Accepted message: " + line + SEPARATOR);
				log.append("Sending message: " + reversedLine.toString() + SEPARATOR);
				out.println(reversedLine.toString());
			}
		} catch (IOException e) {
			log.append("A client has disconnected" + SEPARATOR);
		}
	}

	@Override
	public void run() {
		reverseMessages();
	}
}
