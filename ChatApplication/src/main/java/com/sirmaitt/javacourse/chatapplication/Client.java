package com.sirmaitt.javacourse.chatapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextField;

/**
 * The client sends messages and recieves messages from other clients.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

	// TODO: Create a class that separates the GUI elements from the logic.
	private JTextField response;
	private String message;
	private volatile boolean run;
	private PrintWriter out;
	private String[] address;

	/**
	 * Creates a client and sets the log in which it writes.
	 * 
	 * @param response
	 *            the log to write to.
	 * @param address
	 *            the address of the server given in the form "url:port"
	 */
	public Client(JTextField response, String address) {
		this.address = address.split(":");
		this.response = response;
		run = true;
	}

	/**
	 * Changes the message and notifies the client to send it.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void sendMessage(String message) {
		this.message = message;
		out.println(message);
		if (".disconnect".equals(message)) {
			run = false;
		}
	}

	/**
	 * Listens to all the messages sent from the server.
	 */
	private void listenToServer() {
		try (Socket socket = new Socket(address[0], Integer.parseInt(address[1]))) {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			while (run) {
				response.setText(in.readLine());
				if (".".equals(message)) {
					response.setText("Disconnected from the server");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		listenToServer();
	}
}
