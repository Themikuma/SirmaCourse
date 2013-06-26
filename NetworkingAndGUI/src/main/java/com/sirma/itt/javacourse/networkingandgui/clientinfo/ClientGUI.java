package com.sirma.itt.javacourse.networkingandgui.clientinfo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Creates the window that holds the GUI for the server.
 * 
 * @author gdimitrov
 */
public class ClientGUI extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4016819477611948502L;

	private JTextArea log;
	private JButton start;

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
	public ClientGUI(int width, int height) {
		initComponents(width, height);
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
		start = new JButton();
		log = new JTextArea();
		start.setText("Start");
		start.addActionListener(this);
		start.setEnabled(true);

		setTitle("Client");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(log, BorderLayout.CENTER);
		getContentPane().add(start, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		start.setEnabled(false);
		Client client = new Client(log);
		Thread t1 = new Thread(client);
		t1.start();
	}
}
