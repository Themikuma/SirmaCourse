package com.sirmaitt.javacourse.chatapplication.server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.BadLocationException;

/**
 * This manager handles all presentation to the client's UI.
 * 
 * @author gdimitrov
 */
public class UILogManager implements LogManager {
	private ServerGUI serverUI;
	private static final String SEPARATOR = System.lineSeparator();

	/**
	 * Creates a UIManager using the UI of the client that invoked the creation.
	 * 
	 * @param serverUI
	 *            the UI of the server.
	 */
	public UILogManager(ServerGUI serverUI) {
		this.serverUI = serverUI;
	}

	@Override
	public void logEvent(String message) {
		DateFormat formater = new SimpleDateFormat("HH:mm:ss");
		serverUI.getLog()
				.append("<" + formater.format(Calendar.getInstance().getTime()) + ">" + message
						+ SEPARATOR);
		try {
			serverUI.getLog().setCaretPosition(
					serverUI.getLog().getLineStartOffset(serverUI.getLog().getLineCount() - 1));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

}
