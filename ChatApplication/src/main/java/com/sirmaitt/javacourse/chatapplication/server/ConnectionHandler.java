package com.sirmaitt.javacourse.chatapplication.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sirmaitt.javacourse.chatapplication.utility.Messages;
import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;
import com.sirmaitt.javacourse.chatapplication.utility.SystemMessage;

/**
 * The server receives messages and sends them to all the clients. Before a client is allowed to
 * connect the server checks whether the nickname provided by the client is unique.
 * 
 * @author gdimitrov
 */
public class ConnectionHandler implements Runnable {

	private final Socket clientSocket;
	private final LogManager logManager;
	private final ClientManager clientManager;
	private static final String SYSTEM = "<SYSTEM>: ";

	/**
	 * Creates a server that starts listening on the given port.
	 * 
	 * @param logManager
	 *            the log manager which is used to log the execution of the server.
	 * @param clientSocket
	 *            the socket that the client uses to communicate with the server.
	 * @param clientManager
	 *            the client manager used by this instance of the server.
	 */
	public ConnectionHandler(LogManager logManager, Socket clientSocket, ClientManager clientManager) {
		this.logManager = logManager;
		this.clientManager = clientManager;
		this.clientSocket = clientSocket;
	}

	/**
	 * Accepts ongoing messages from the client, that created this thread and sends these messages
	 * to all the clients.
	 */
	private void communicate() {
		Client client = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String line = in.readLine();
			if (!line.startsWith(Messages.CONNECTED_.toString())) {
				client = new Client("admin", clientSocket.getOutputStream());
			} else {
				line = line.substring(line.indexOf("_") + 1);
				client = new Client(line, clientSocket.getOutputStream());
			}
			if (!clientManager.addClient(client)) {
				client.sendMessage(Messages.ERROR
						+ SystemMessage.getMessage("taken", ResourceNames.Messages));
				return;
			}
			logManager.logEvent(client.toString()
					+ SystemMessage.getMessage("connected", ResourceNames.Messages));
			clientManager.broadcastMessage(client.toString()
					+ SystemMessage.getMessage("connected", ResourceNames.Messages));
			client.sendMessage(SystemMessage.getMessage("welcome", ResourceNames.Messages) + client);
			clientManager.broadcastMessage(Messages.LIST.toString()
					+ clientManager.getClientNicknames());
			while (true) {
				line = in.readLine();
				if (line == null) {
					continue;
				}
				if (Messages.DISCONNECTED.toString().equals(line)) {
					client.sendMessage(Messages.DISCONNECTED.toString());
					clientManager.removeClient(client);
					clientManager.broadcastMessage(SYSTEM + client
							+ SystemMessage.getMessage("disconnected", ResourceNames.Messages));
					logManager.logEvent(client
							+ SystemMessage.getMessage("disconnected", ResourceNames.Messages));
					break;
				}
				clientManager.broadcastMessage("<" + client + ">: " + line);
			}
		} catch (IOException e) {
			logManager.logEvent(client
					+ SystemMessage.getMessage("disconnected", ResourceNames.Messages));
		}
	}

	@Override
	public void run() {
		communicate();
	}
}
