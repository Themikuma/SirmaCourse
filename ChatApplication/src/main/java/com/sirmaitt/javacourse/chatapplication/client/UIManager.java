package com.sirmaitt.javacourse.chatapplication.client;

import javax.swing.text.BadLocationException;

import com.sirmaitt.javacourse.chatapplication.server.ClientManager;

/**
 * This manager handles all presentation to the client's UI.
 * 
 * @author gdimitrov
 */
public class UIManager implements Manager {
	private ClientGUI clientUI;
	private static final String SEPARATOR = System.lineSeparator();

	/**
	 * Creates a UIManager using the UI of the client that invoked the creation.
	 * 
	 * @param client
	 *            the UI of the client
	 */
	public UIManager(ClientGUI client) {
		clientUI = client;
	}

	@Override
	public void displayMessage(String message) {
		clientUI.getChatLog().append(message + SEPARATOR);
		try {
			clientUI.getChatLog().setCaretPosition(
					clientUI.getChatLog().getLineStartOffset(
							clientUI.getChatLog().getLineCount() - 1));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void displayUserList(String message) {
		clientUI.getClients().setText("");
		String[] users = message.split(ClientManager.CLIENT_SEPARATOR);
		for (String user : users) {
			clientUI.getClients().append(user + SEPARATOR);
		}
	}

	@Override
	public void displayErrorMessage(String message) {
		clientUI.getError().setText(message);
	}

}
