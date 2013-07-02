package com.sirma.itt.javacourse.networkingandgui.reverse;

import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Creates the window that holds the GUI for the server.
 * 
 * @author gdimitrov
 */
public class ServerGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4016819477611948502L;

	private JTextArea log;

	/**
	 * Getter method for log.
	 * 
	 * @return the log
	 */
	public JTextArea getLog() {
		return log;
	}

	/**
	 * Creates the server window.
	 * 
	 * @param width
	 *            width of the window
	 * @param height
	 *            height of the window
	 */
	public ServerGUI(int width, int height) {
		initComponents(width, height);
		initServer();
	}

	/**
	 * Initializes the graphical components of the window.
	 * 
	 * @param width
	 *            width of the window
	 * @param height
	 *            height of the window
	 */
	private void initComponents(int width, int height) {
		setSize(width, height);
		log = new JTextArea();
		log.setEditable(false);
		JScrollPane pane = new JScrollPane(log);

		setTitle("Server");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(pane, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * Initialises the server.
	 */
	private void initServer() {
		Random random = new Random();
		int port = random.nextInt(20) + 7000;
		ConnectionHandler handler = new ConnectionHandler(port, log);
		Thread connectionThread = new Thread(handler);
		connectionThread.start();
	}

}
