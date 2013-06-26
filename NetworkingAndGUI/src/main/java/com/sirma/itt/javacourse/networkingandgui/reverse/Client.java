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
	 * Setter method for message.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
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
				continue;
			} catch (IOException e) {
				continue;
			}
		}
		if (socket == null) {
			response.setText("No server found. Closing");
			return;
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
				communicate(message);
				if (".".equals(message)) {
					response.setText("Disconnected from the server");
					break;
				}
			}
		}
		try {
			socket.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Communicates with the server.
	 * 
	 * @param message
	 *            the message the server sent.
	 */
	private void communicate(String message) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			if (message == null) {
				return;
			}
			out.println(message);
			response.setText("The reverse of " + message + " is " + in.readLine());
		} catch (IOException e) {
			response.setText("The server has stopped working");
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
