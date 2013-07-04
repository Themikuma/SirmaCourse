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
	public boolean isRunning() {
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
			} catch (IOException e) {
				log.append("Couldn't close the server socket" + System.lineSeparator());
			}
		}
	}

	/**
	 * Runs the server until told otherwise by the client.
	 */
	private void runServer() {
		try (ServerSocket servSocket = new ServerSocket(port)) {
			serverSocket = servSocket;
			log.append("Waiting for connection..." + System.lineSeparator());
			while (run) {
				try (Socket clientSocket = serverSocket.accept()) {
					log.append(clientSocket.getInetAddress()
							+ " has succesfully connected on port " + clientSocket.getLocalPort()
							+ System.lineSeparator());
				} catch (IOException e) {
					log.append("The server has been stopped." + System.lineSeparator());
				}
			}
		} catch (IOException e) {
			log.append("Could not listen on port: " + port + System.lineSeparator());
			return;
		}
	}

	@Override
	public void run() {
		runServer();
	}
}