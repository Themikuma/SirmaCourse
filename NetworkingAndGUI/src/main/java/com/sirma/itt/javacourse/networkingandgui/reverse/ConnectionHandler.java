package com.sirma.itt.javacourse.networkingandgui.reverse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * Handles each connection by giving it a new server thread.
 * 
 * @author gdimitrov
 */
public class ConnectionHandler implements Runnable {

	private JTextArea log;
	private int port;
	private boolean run;
	private ServerSocket serverSocket = null;

	/**
	 * Creates a connection handler on a given port.
	 * 
	 * @param port
	 *            the port ot connect to.
	 * @param log
	 *            the log to use for loging the results.
	 */
	public ConnectionHandler(int port, JTextArea log) {
		this.log = log;
		this.port = port;
		run = true;
	}

	/**
	 * Stops the connection handler from listening for connections and frees up the port that it's
	 * using.
	 */
	public void stop() {
		run = false;
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				log.append("Could not close the server.");
			}
		}
	}

	/**
	 * Handles a connection from a client, by sending it to a new server thread. Uses a
	 * {@link JTextArea} provided in the class constructor to log the results.
	 */
	private void handleConnection() {
		try {
			serverSocket = new ServerSocket(port);
			log.append("Listening on port: " + port + System.lineSeparator());
		} catch (IOException e) {
			log.append("Could not listen on port: " + port + System.lineSeparator());
		}
		while (run) {
			try {
				Socket clientSocket = serverSocket.accept();
				Server server = new Server(log, clientSocket);
				Thread serverThread = new Thread(server);
				serverThread.start();
			} catch (IOException e) {
				log.append("Тhe server was stopped" + System.lineSeparator());
				break;
			}
		}
	}

	@Override
	public void run() {
		handleConnection();
	}
}
