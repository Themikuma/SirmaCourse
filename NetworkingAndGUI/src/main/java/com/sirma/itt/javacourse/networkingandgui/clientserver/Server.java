package com.sirma.itt.javacourse.networkingandgui.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * Server for the server log application.
 * 
 * @author gdimitrov
 */
public class Server implements Runnable {

	private int port;
	private volatile boolean run;
	private JTextArea log;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	/**
	 * Creates a server listening to a specific port.
	 * 
	 * @param port
	 *            the port to listen to.
	 * @param log
	 *            the log in which to log the data.
	 */
	public Server(int port, JTextArea log) {
		this.port = port;
		this.log = log;
		run = false;
	}

	/**
	 * Checks if the server is running.
	 * 
	 * @return the run
	 */
	public boolean isRun() {
		return run;
	}

	/**
	 * Starts the server.
	 */
	public void start() {
		run = true;
	}

	/**
	 * Stops the server.
	 */
	public void stop() {
		run = false;
		if (serverSocket != null) {
			try {
				serverSocket.close();
				clientSocket = null;
			} catch (IOException e) {
				log.insert("Couldn't close the server socket" + System.lineSeparator(), 0);
			}
		}
	}

	/**
	 * Runs the server until told otherwise by the client.
	 */
	public void runServer() {

		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			log.insert("Could not listen on port: " + port + System.lineSeparator(), 0);
		}

		log.insert("Waiting for connection....." + System.lineSeparator(), 0);

		while (run) {
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				log.insert("The server has been stopped." + System.lineSeparator(), 0);
			}
			if (clientSocket != null) {
				log.insert(clientSocket.getInetAddress() + " has succesfully connected on port "
						+ clientSocket.getLocalPort() + System.lineSeparator(), 0);
			}
		}
		try {
			if (clientSocket != null) {
				clientSocket.close();
			}
			serverSocket.close();
		} catch (IOException e) {
			log.insert("Coudldn't close the streams" + System.lineSeparator(), 0);
		}
	}

	@Override
	public void run() {
		runServer();
	}
}