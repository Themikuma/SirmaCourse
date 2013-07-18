package com.sirmaitt.javacourse.chatapplication.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextField;

import com.sirmaitt.javacourse.chatapplication.util.Messages;

/**
 * The client sends messages and receives messages from other clients.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

	// TODO: Create a class that separates the GUI elements from the logic.
	private final JTextField response;
	private String message;
	private volatile boolean run;
	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;

	/**
	 * Creates a client and sets the log in which it writes.
	 * 
	 * @param response
	 *            the log to write to.
	 * @param address
	 *            the address of the server given in the form "url:port"
	 */
	public Client(JTextField response) {
		this.response = response;
		run = true;
	}

	public boolean connect(String address, String nickname) {
		String host = address.substring(0, address.indexOf(":"));
		String port = address.substring(address.indexOf(":") + 1);
		try {
			socket = new Socket(host, Integer.parseInt(port));
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			sendMessage(Messages.CONNECTED_ + nickname);
			return checkResponse(in.readLine());
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		}
		return false;
	}

	/**
	 * Checks the server response to see if it is a command.
	 * 
	 * @param serverResponse
	 * @return true if the server approved the connecting client or the response
	 *         wasn't a command.
	 */
	private boolean checkResponse(String serverResponse) {
		if (!serverResponse.startsWith(".")) {
			return true;
		}
		if (serverResponse.startsWith(Messages.ERROR.toString())) {
			return false;
		}
		if (serverResponse.startsWith(Messages.CONNECTED_.toString())) {
			return true;
		}
		if (Messages.DISCONNECTED.equals(message)) {
			response.setText("Disconnected from the server");
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Log the exception.
				e.printStackTrace();
			}
			return false;
		}
		return true;

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
		if (Messages.DISCONNECTED.toString().equals(message)) {
			run = false;
		}
	}

	/**
	 * Listens to all the messages sent from the server.
	 */
	private void listenToServer() {
		String serverResponse = null;
		while (run) {
			try {
				serverResponse = in.readLine();
				checkResponse(serverResponse);
				response.setText(serverResponse);
			} catch (IOException e) {
				// TODO Log the exception.
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		listenToServer();
	}
}
