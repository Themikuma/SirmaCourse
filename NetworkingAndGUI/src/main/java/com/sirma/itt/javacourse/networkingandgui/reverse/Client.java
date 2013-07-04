package com.sirma.itt.javacourse.networkingandgui.reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextField;

import com.sirma.itt.javacourse.networkingandgui.util.ServerFinder;

/**
 * The client sends messages and recieves the reversed messages.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

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
		try (Socket socket = ServerFinder.findServer()) {
			if (socket == null) {
				response.setText("No server found. Closing");
				return;
			}
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
			// TODO Auto-generated catch block
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
