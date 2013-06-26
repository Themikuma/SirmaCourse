package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

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

	private JTextArea log;
	private JButton stop;
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
		Random random = new Random();
		server = new Server(random.nextInt(20) + 7000, log);
		Thread serverThread = new Thread(server);
		serverThread.start();
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
		stop = new JButton();
		log = new JTextArea();
		stop.setText("Stop");
		stop.addActionListener(this);
		stop.setEnabled(true);

		setTitle("Server");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(log, BorderLayout.CENTER);
		getContentPane().add(stop, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		server.stop();
	}
}
