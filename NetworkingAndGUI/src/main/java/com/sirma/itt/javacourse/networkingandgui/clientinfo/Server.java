package com.sirma.itt.javacourse.networkingandgui.clientinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextArea;

/**
 * @author gdimitrov
 */
public class Server implements Runnable {

	private int port;
	private ArrayList<PrintWriter> clients;
	private JTextArea log;
	private ServerSocket serverSocket;
	private volatile boolean run;

	/**
	 * Creates a server that starts listening on the given port.
	 * 
	 * @param port
	 *            the port on which to listen.
	 * @param log
	 *            the log in which to log the data.
	 */
	public Server(int port, JTextArea log) {
		this.log = log;
		this.port = port;
		clients = new ArrayList<>();
		run = true;
	}

	/**
	 * Runs the server until told otherwise by the GUI.
	 */
	public void acceptConnection() {
		try (ServerSocket servSocket = new ServerSocket(port)) {
			serverSocket = servSocket;
			Socket clientSocket = null;
			int i = 0;
			while (run) {
				try {
					clientSocket = serverSocket.accept();
					i++;
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					out.println("You're client number " + i);
					for (PrintWriter client : clients) {
						client.println("Client number " + i + " joined us");
					}
					clients.add(out);
				} catch (IOException e) {
					log.append("Server was stopped");
				}
			}
			if (clientSocket != null) {
				clientSocket.close();
			}
		} catch (IOException e) {
			log.insert("Could not listen on port: " + port + System.lineSeparator(), 0);
		}

		log.insert("Waiting for connection....." + System.lineSeparator(), 0);
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
				log.insert("Couldn't close the server socket" + System.lineSeparator(), 0);
			}
		}
	}

	@Override
	public void run() {
		acceptConnection();
	}
}
