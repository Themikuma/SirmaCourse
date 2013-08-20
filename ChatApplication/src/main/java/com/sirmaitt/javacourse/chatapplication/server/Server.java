package com.sirmaitt.javacourse.chatapplication.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import com.sirmaitt.javacourse.chatapplication.utility.Messages;
import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;

/**
 * Handles each connection by giving it a new server thread.
 * 
 * @author gdimitrov
 */
public class Server implements Runnable {

	private final LogManager logManager;
	private final int port;
	private boolean run;
	private ServerSocket serverSocket = null;
	private final ClientManager clients;

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
	 * Stops the server from listening for connections and frees up the port
	 * that it's using.
	 */
	public void stop() {
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
			logManager.logEvent(ServerResources.getMessage("start",
					ResourceNames.Messages));
			clients.getAdmin()
					.sendMessage(
							(ServerResources.getMessage("start",
									ResourceNames.Messages) + Calendar
									.getInstance().getTime()));
			while (run) {
				try {
					Socket clientSocket = serverSocket.accept();
					ConnectionHandler connection = new ConnectionHandler(
							logManager, clientSocket, clients);
					Thread connectionThread = new Thread(connection);
					connectionThread.start();
				} catch (IOException e) {
					logManager.logEvent(ServerResources.getMessage("stop",
							ResourceNames.Messages));
					clients.broadcastMessage(Messages.DISCONNECTED.toString());
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			logManager.logEvent(ServerResources.getMessage("port",
					ResourceNames.Messages));
		} catch (IOException e) {
			logManager.logEvent(ServerResources.getMessage("portTaken",
					ResourceNames.Errors));
		}
	}

	@Override
	public void run() {
		handleConnection();
	}
}
