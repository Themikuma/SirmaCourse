package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextArea;

/**
 * Accepts connections and sends them to the servers.
 * 
 * @author gdimitrov
 */
public class Server implements Runnable {

	private JTextArea log;
	private ArrayList<Channel> channels;
	private String message;

	/**
	 * Creates a connection that accepts clients.
	 * 
	 * @param log
	 *            the log for the server.
	 */
	public Server(JTextArea log) {
		this.log = log;
		channels = new ArrayList<>();
		channels.add(new Channel());
		channels.add(new Channel());
		channels.add(new Channel());
	}

	/**
	 * Setter method for message.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
		broadcast();
	}

	/**
	 * Broadcasts the message to all the channels interested in it.
	 */
	private void broadcast() {
		log.append("Broadcasting: " + message + System.lineSeparator());
		ArrayList<Channel> broadcast = new ArrayList<>();
		boolean cSharp = message.toLowerCase().contains("c#");
		boolean java = message.toLowerCase().contains("java");
		if (cSharp) {
			broadcast.add(channels.get(0));
		}
		if (java) {
			broadcast.add(channels.get(1));
		}
		if (!cSharp && !java) {
			broadcast.add(channels.get(2));
		}
		ArrayList<OutputStream> recievers = new ArrayList<>();
		for (Channel channel : broadcast) {
			for (OutputStream outputStream : channel.getClients()) {
				if (!recievers.contains(outputStream)) {
					recievers.add(outputStream);
				}
			}
		}
		for (OutputStream outputStream : recievers) {
			PrintWriter out = new PrintWriter(outputStream, true);
			out.println(message);
		}
	}

	/**
	 * Accepts connections from clients.
	 */
	private void acceptConnection() {
		Random random = new Random();
		int port = random.nextInt(2) + 7000;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			log.append("Listening on port: " + port + System.lineSeparator());
		} catch (IOException e) {
			log.append("Could not listen on port: " + port + System.lineSeparator());
		}
		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				log.append("Someone connected" + System.lineSeparator());
				String connect = in.readLine();
				boolean cSharp = connect.toLowerCase().contains("c#");
				boolean java = connect.toLowerCase().contains("java");
				OutputStream out = clientSocket.getOutputStream();
				if (cSharp) {
					channels.get(0).addClient(out);
				}
				if (java) {
					channels.get(1).addClient(out);
				}
				if ((!cSharp && !java) || connect.contains("offtopic")) {
					channels.get(2).addClient(out);
				}
			} catch (IOException e) {
				e.printStackTrace();
				log.append("There was an error with starting up the server"
						+ System.lineSeparator());
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		acceptConnection();
	}

}
