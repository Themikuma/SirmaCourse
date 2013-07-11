package com.sirmaitt.javacourse.chatapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextField;

/**
 * The client sends messages and recieves the reversed messages.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

	// TODO: Create a class that separates the GUI elements from the logic.
	private JTextField response;
	private String message;
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
		// TODO: Pass a parameter in the form "url:port"
		try (Socket socket = new Socket("localhost", 7007)) {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			response.setText(in.readLine());
			synchronized (this) {
				while (true) {
					wait();
					if (message == null) {
						return;
					}
					out.println(message);
					serverResponse = in.readLine();
					response.setText("The reverse of " + message + " is " + serverResponse);
					if (".".equals(message)) {
						response.setText("Disconnected from the server");
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
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
