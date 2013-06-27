package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Creates the window that holds the GUI for the server.
 * 
 * @author gdimitrov
 */
public class ServerGUI extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4016819477611948502L;
	private Server server;
	private JTextField message;
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
		JPanel contentPane = new JPanel(new GridLayout(2, 1, 5, 5));
		JButton send = new JButton("Send");
		send.addActionListener(this);
		message = new JTextField();
		contentPane.add(message);
		contentPane.add(send);

		setTitle("Server");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(log, BorderLayout.CENTER);
		getContentPane().add(contentPane, BorderLayout.SOUTH);
		setVisible(true);
	}

	/**
	 * Initialises the server.
	 */
	private void initServer() {
		server = new Server(log);
		Thread serverThread = new Thread(server);
		serverThread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		server.setMessage(message.getText());
		message.setText("");
	}
}
