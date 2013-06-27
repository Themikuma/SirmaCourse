package com.sirma.itt.javacourse.networkingandgui.reverse;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import javax.swing.JFrame;
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
	private Server server;

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

		setTitle("Server");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(log, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * Initialises the server.
	 */
	private void initServer() {
		Random random = new Random();
		int port = random.nextInt(20) + 7000;
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
				server = new Server(log, clientSocket);
				log.append("Got a new connection" + System.lineSeparator());
				Thread serverThread = new Thread(server);
				serverThread.start();
			} catch (IOException e) {
				e.printStackTrace();
				log.append("There was an error with starting up the server"
						+ System.lineSeparator());
				break;
			}
		}
	}

}
