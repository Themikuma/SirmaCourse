package com.sirma.itt.javacourse.networkingandgui.clientinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.networkingandgui.util.ServerFinder;

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
		try (Socket socket = ServerFinder.findServer();) {
			if (socket == null) {
				log.append("Couldn't find an open port. Shutting down" + System.lineSeparator());
				return;
			}
			try (BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));) {
				log.append("Connected" + System.lineSeparator());
				while (true) {
					log.append(in.readLine() + System.lineSeparator());

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		connectClient();
	}
}
