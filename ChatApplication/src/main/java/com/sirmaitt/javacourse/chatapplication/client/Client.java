package com.sirmaitt.javacourse.chatapplication.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sirmaitt.javacourse.chatapplication.utility.Messages;
import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;

/**
 * The client sends messages and receives messages from other clients.
 * 
 * @author gdimitrov
 */
public class Client implements Runnable {

	private final Manager manager;
	private volatile boolean run;
	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;

	/**
	 * Creates a client and sets the log in which it writes.
	 * 
	 * @param manager
	 *            the UI manager that handles the display of the messages.
	 */
	public Client(Manager manager) {
		this.manager = manager;
		run = true;
	}

	/**
	 * Connects the client to the server and returns if the connection was
	 * successful.
	 * 
	 * @param address
	 *            the address of the server. Should be given in format
	 *            "url:port"
	 * @param nickname
	 *            the nickname of the user connecting.
	 * @return true if the connection was successful.
	 */
	public boolean connect(String address, String nickname) {
		String host = address.substring(0, address.indexOf(":"));
		String port = address.substring(address.indexOf(":") + 1);
		try {
			socket = new Socket(host, Integer.parseInt(port));
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			sendMessage(Messages.CONNECTED_ + nickname);
			String serverResponse = in.readLine();
			return checkResponse(serverResponse);
		} catch (NumberFormatException e) {
			String shit = ClientResources.getMessage("port",
					ResourceNames.Errors);
			manager.displayErrorMessage(shit);
		} catch (IOException e) {
			manager.displayErrorMessage(ClientResources.getMessage("server",
					ResourceNames.Errors));
		}
		return false;
	}

	/**
	 * Checks the server response to see if it is a command.
	 * 
	 * @param serverResponse
	 *            the response to be checked.
	 * @return true if the server approved the connecting client or the response
	 *         wasn't a command.
	 */
	public boolean checkResponse(String serverResponse) {
		if (!serverResponse.startsWith(".")) {
			return true;
		}

		if (serverResponse.startsWith(Messages.ERROR.toString())) {
			manager.displayErrorMessage(ClientResources.getMessage(
					"nickname_taken", ResourceNames.Errors));
			return false;
		}
		if (serverResponse.startsWith(Messages.CONNECTED_.toString())) {
			return true;
		}
		if (serverResponse.startsWith(Messages.LIST.toString())) {
			String message = serverResponse.substring(Messages.LIST.toString()
					.length());
			manager.displayUserList(message);
			return false;
		}
		if (Messages.DISCONNECTED.toString().equals(serverResponse)) {
			manager.displayMessage(ClientResources.getMessage(
					"you_disconnected", ResourceNames.Messages));
			try {
				socket.close();
			} catch (IOException e) {
			}
			return false;
		}
		return true;
	}

	/**
	 * Changes the message and notifies the client to send it.
	 * 
	 * @param message
	 *            the message to set
	 * @return false if the message was a disconnect message and the connect
	 *         dialog should be redisplayed.
	 */
	public boolean sendMessage(String message) {
		if ("".equals(message)) {
			return true;
		}
		String capitalizedMessage = "";
		capitalizedMessage += message.toUpperCase().charAt(0);
		capitalizedMessage += message.substring(1);

		out.println(capitalizedMessage);
		if (message.equals(Messages.DISCONNECTED.toString())) {
			return false;
		}
		return true;
	}

	/**
	 * Listens to all the messages sent from the server.
	 */
	private void listenToServer() {
		String serverResponse = null;
		DateFormat formater = new SimpleDateFormat("HH:mm:ss");
		while (run) {
			try {
				serverResponse = in.readLine();
				if (checkResponse(serverResponse)) {
					manager.displayMessage("[<"
							+ formater.format(Calendar.getInstance().getTime())
							+ ">]" + serverResponse);
				}
			} catch (SocketException e) {
				return;
			} catch (IOException e) {
				manager.displayMessage(ClientResources.getMessage(
						"you_disconnected", ResourceNames.Messages));
			}
		}
	}

	@Override
	public void run() {
		listenToServer();
	}
}
