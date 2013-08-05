package com.sirmaitt.javacourse.chatapplication.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sirmaitt.javacourse.chatapplication.utility.Messages;
import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;

/**
 * Handles each connection by giving it a new server thread.
 * 
 * @author gdimitrov
 */
public class Server implements Runnable {

	private final LogManager logManager;
	private int port;
	private boolean run;
	private ServerSocket serverSocket = null;
	private ClientManager clients;

	/**
	 * Creates a connection handler on a given port.
	 * 
	 * @param port
	 *            the port ot connect to.
	 * @param logManager
	 *            the manager that is going to handle loging the results.
	 */
	public Server(int port, LogManager logManager) {
		this.logManager = logManager;
		this.port = port;
		run = true;
		clients = new ClientManager();
	}

	/**
	 * Stops the server from listening for connections and frees up the port that it's using.
	 */
	public void stop() {
		clients.broadcastMessage(Messages.DISCONNECTED.toString());
		run = false;
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * Handles a connection from a client, by sending it to a new server thread.
	 */
	private void handleConnection() {
		try (ServerSocket servSocket = new ServerSocket(port)) {
			serverSocket = servSocket;
			logManager.logEvent(ServerMessages.getMessage("start", ResourceNames.Messages));
			while (run) {
				try {
					Socket clientSocket = serverSocket.accept();
					ConnectionHandler connection = new ConnectionHandler(logManager, clientSocket,
							clients);
					Thread connectionThread = new Thread(connection);
					connectionThread.start();
				} catch (IOException e) {
					logManager.logEvent(ServerMessages.getMessage("stop",
							ResourceNames.Messages));
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			logManager.logEvent(ServerMessages.getMessage("port", ResourceNames.Messages));
		} catch (IOException e) {
			logManager.logEvent(ServerMessages.getMessage("portTaken",
					ResourceNames.Messages));
		}
	}

	@Override
	public void run() {
		handleConnection();
	}
}
