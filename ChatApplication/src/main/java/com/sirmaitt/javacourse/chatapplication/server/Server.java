package com.sirmaitt.javacourse.chatapplication.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JTextArea;

/**
 * Handles each connection by giving it a new server thread.
 * 
 * @author gdimitrov
 */
public class Server implements Runnable {

	private JTextArea log;
	private int port;
	private boolean run;
	private ServerSocket serverSocket = null;
	private Set<ClientManager> clients;

	/**
	 * Creates a connection handler on a given port.
	 * 
	 * @param port
	 *            the port ot connect to.
	 * @param log
	 *            the log to use for loging the results.
	 */
	public Server(int port, JTextArea log) {
		this.log = log;
		this.port = port;
		run = true;
		clients = new HashSet<>();
	}

	/**
	 * Stops the server from listening for connections and frees up the port that it's using.
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
		try (ServerSocket servSocket = new ServerSocket(port)) {
			serverSocket = servSocket;
			log.append("Listening on port: " + port + System.lineSeparator());
			while (run) {
				try {
					Socket clientSocket = serverSocket.accept();
					ConnectionHandler connection = new ConnectionHandler(log, clientSocket);
					Thread connectionThread = new Thread(connection);
					connectionThread.start();
				} catch (IOException e) {
					log.append("Тhe server was stopped" + System.lineSeparator());
					break;
				}
			}
		} catch (IOException e) {
			log.append("Could not listen on port: " + port + System.lineSeparator());
		}
	}

	@Override
	public void run() {
		handleConnection();
	}
}
