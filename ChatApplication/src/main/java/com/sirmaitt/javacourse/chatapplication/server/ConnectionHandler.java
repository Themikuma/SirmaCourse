package com.sirmaitt.javacourse.chatapplication.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * The server recieves messages and sends them to all the clients. Before a client is allowed to
 * connect the server checks whether the nickname provided by the client is unique.
 * 
 * @author gdimitrov
 */
public class ConnectionHandler implements Runnable {

	private JTextArea log;
	private Socket clientSocket;
	private ClientManager manager;
	private static final String SEPARATOR = System.lineSeparator();

	/**
	 * Creates a server that starts listening on the given port.
	 * 
	 * @param log
	 *            the log in which to log the data.
	 * @param clientSocket
	 *            the socket that the client uses to communicate with the server.
	 * @param manager
	 *            the client manager used by this instance of the server.
	 */
	public ConnectionHandler(JTextArea log, Socket clientSocket, ClientManager manager) {
		this.manager = manager;
		this.log = log;
		this.clientSocket = clientSocket;
	}

	/**
	 * Accepts ingoing messages from the client, that created this thread and sends these messages
	 * to all the clients.
	 */
	private void communicate() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String line = in.readLine();
			line = line.substring(line.indexOf("_") + 1);
			Client client = new Client(line, clientSocket.getOutputStream());
			if (!manager.addClient(client)) {
				client.sendMessage("Your nickname is already taken");
				return;
			}
			log.append(client.toString() + " has connected");
			client.sendMessage("Welcome");
			manager.broadcastMessage("Client <" + line + "> has connected");
			manager.broadcastMessage(".list_" + manager.getClientNicknames());
			while (true) {
				line = in.readLine();
				if (".disconnect".equals(line)) {
					client.sendMessage("Disconnecting");
					manager.removeClient(client);
					break;
				}
				manager.broadcastMessage(line);
			}
		} catch (IOException e) {
			log.append("A client has disconnected" + SEPARATOR);
		}
	}

	@Override
	public void run() {
		communicate();
	}
}
