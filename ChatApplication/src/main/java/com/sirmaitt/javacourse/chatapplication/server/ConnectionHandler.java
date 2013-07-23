package com.sirmaitt.javacourse.chatapplication.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

import com.sirmaitt.javacourse.chatapplication.utility.Messages;

/**
 * The server receives messages and sends them to all the clients. Before a client is allowed to
 * connect the server checks whether the nickname provided by the client is unique.
 * 
 * @author gdimitrov
 */
public class ConnectionHandler implements Runnable {

	private final JTextArea log;
	private final Socket clientSocket;
	private final ClientManager manager;
	private static final String SEPARATOR = System.lineSeparator();
	private static final String SYSTEM = "<SYSTEM>: ";

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
	 * Accepts ongoing messages from the client, that created this thread and sends these messages
	 * to all the clients.
	 */
	private void communicate() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String line = in.readLine();
			Client client = null;
			if (!line.startsWith(Messages.CONNECTED_.toString())) {
				client = new Client("admin", clientSocket.getOutputStream());
			} else {
				line = line.substring(line.indexOf("_") + 1);
				client = new Client(line, clientSocket.getOutputStream());
			}
			if (!manager.addClient(client)) {
				client.sendMessage(Messages.ERROR + "your nickname is already taken");
				return;
			}
			log.append(client.toString() + " has connected" + SEPARATOR);
			manager.broadcastMessage("Client <" + line + "> has connected");
			client.sendMessage("Welcome");
			manager.broadcastMessage(Messages.LIST.toString() + manager.getClientNicknames());
			while (true) {
				line = in.readLine();
				if (Messages.DISCONNECTED.toString().equals(line)) {
					client.sendMessage(SYSTEM + "Disconnected");
					manager.removeClient(client);
					manager.broadcastMessage(SYSTEM + client + " has disconnected");
					break;
				}
				manager.broadcastMessage("<" + client + ">: " + line);
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
