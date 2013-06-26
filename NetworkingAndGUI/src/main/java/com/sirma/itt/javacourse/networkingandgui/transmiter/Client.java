package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

/**
 * The client for the client info application.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

	private JTextArea log;

	/**
	 * Creates a client and sets the log in which it writes.
	 * 
	 * @param log
	 *            the log to write to.
	 */
	public Client(JTextArea log) {
		this.log = log;
	}

	/**
	 * Runs the client communication with the server.
	 */
	public void connectClient() {
		log.append("Searching for an open port " + System.lineSeparator());

		Socket socket = null;
		BufferedReader in = null;

		for (int i = 7000; i < 7020; i++) {
			try {
				socket = new Socket("localhost", i);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				break;
			} catch (UnknownHostException e) {
				continue;
			} catch (IOException e) {
				continue;
			}
		}
		if (socket == null) {
			log.append("Couldn't find an open port. Shutting down" + System.lineSeparator());
			return;
		}
		log.append("Connected" + System.lineSeparator());
		while (true) {
			try {
				log.append(in.readLine() + System.lineSeparator());
			} catch (IOException e) {
				break;
			}
		}
		try {
			in.close();
			socket.close();
		} catch (IOException e) {
			log.append("Coudldn't close the streams" + System.lineSeparator());
		}
	}

	/**
	 * Creates a client that uses a server to communicate.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method.
	 */
	public static void main(String[] args) {
	}

	@Override
	public void run() {
		connectClient();
	}
}
