package com.sirma.itt.javacourse.networkingandgui.reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextField;

/**
 * The client sends messages and recieves the reversed messages.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

	private JTextField response;
	private Socket socket;
	private String message;
	private BufferedReader in;
	private PrintWriter out;
	private String serverResponse;

	/**
	 * Creates a client and sets the log in which it writes.
	 * 
	 * @param response
	 *            the log to write to.
	 */
	public Client(JTextField response) {
		this.response = response;
	}

	/**
	 * Changes the message and notifies the client to send it.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void sendMessage(String message) {
		this.message = message;
		synchronized (this) {
			notifyAll();
		}
	}

	/**
	 * Runs the client communication with the server.
	 */
	public void connectClient() {
		for (int i = 7000; i < 7020; i++) {
			try {
				socket = new Socket("localhost", i);
				break;
			} catch (UnknownHostException e) {
			} catch (IOException e) {
			}
		}
		if (socket == null) {
			response.setText("No server found. Closing");
			return;
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			response.setText(in.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		synchronized (this) {
			while (true) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				communicate();
				if (".".equals(message)) {
					response.setText("Disconnected from the server");
					break;
				}
			}
		}
		try {
			socket.close();
			in.close();
			out.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Communicates with the server.
	 */
	private void communicate() {
		try {
			if (message == null) {
				return;
			}
			out.println(message);
			serverResponse = in.readLine();
			response.setText("The reverse of " + message + " is " + serverResponse);
		} catch (IOException e) {
			response.setText("The server has stopped working");
		}
	}

	/**
	 * Getter method for serverResponse.
	 * 
	 * @return the serverResponse
	 */
	public String getServerResponse() {
		return serverResponse;
	}

	@Override
	public void run() {
		connectClient();
	}
}
