package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

/**
 * The client subscribes for channels and then recieves broadcasts from the server.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

	private JTextArea messageLog;
	private volatile boolean run;
	private String subscriptions;
	private Socket socket;
	private String serverResponse;

	/**
	 * Getter method for serverResponse.
	 * 
	 * @return the serverResponse
	 */
	public String getServerResponse() {
		return serverResponse;
	}

	/**
	 * Creates a client and sets the log in which it writes.
	 * 
	 * @param messageLog
	 *            the log to write to.
	 */
	public Client(JTextArea messageLog) {
		this.messageLog = messageLog;
		run = true;
		socket = null;
	}

	/**
	 * Stops the client.
	 */
	public void stop() {
		run = false;
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setter method for subscriptions.
	 * 
	 * @param subscriptions
	 *            the subscriptions to set
	 */
	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}

	/**
	 * Runs the client communication with the server.
	 */
	public void connectClient() {
		BufferedReader in;
		messageLog.append("Looking for server..." + System.lineSeparator());
		for (int i = 7000; i < 7020; i++) {
			try {
				socket = new Socket("localhost", i);
				break;
			} catch (UnknownHostException e) {
			} catch (IOException e) {
			}
		}
		if (socket == null) {
			messageLog.append("No server found. Closing");
			return;
		}
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			messageLog.append("Connected to " + socket.getPort() + System.lineSeparator());
			out.println(subscriptions);
		} catch (IOException e) {
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (run) {
				serverResponse = in.readLine();
				messageLog.append(serverResponse + System.lineSeparator());
			}
		} catch (IOException e) {
		}
		try {
			socket.close();
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		connectClient();
	}
}
