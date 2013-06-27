package com.sirma.itt.javacourse.networkingandgui.transmiter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Creates the window that holds the GUI for the client.
 * 
 * @author gdimitrov
 */
public class ClientGUI extends JFrame implements ActionListener, WindowListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4016819477611948502L;

	private JTextField subscriptions;
	private JTextArea messageLog;
	private JButton connect;
	private Client client;

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
		connect = new JButton();
		connect.setText("Connect");
		connect.addActionListener(this);
		connect.setEnabled(true);
		subscriptions = new JTextField();
		messageLog = new JTextArea();
		messageLog.setEditable(false);
		Panel textPane = new Panel(new GridLayout(2, 1, 5, 5));
		textPane.add(messageLog);
		textPane.add(subscriptions);

		addWindowListener(this);
		setTitle("Client");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(textPane, BorderLayout.CENTER);
		getContentPane().add(connect, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		client.setSubscriptions(subscriptions.getText());
		Thread clientThread = new Thread(client);
		clientThread.start();
		connect.setEnabled(false);
		subscriptions.setEnabled(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		client = new Client(messageLog);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		client.stop();
		dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
