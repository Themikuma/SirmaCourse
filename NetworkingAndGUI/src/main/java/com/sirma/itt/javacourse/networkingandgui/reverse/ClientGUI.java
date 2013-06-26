package com.sirma.itt.javacourse.networkingandgui.reverse;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Creates the window that holds the GUI for the client.
 * 
 * @author gdimitrov
 */
public class ClientGUI extends JFrame implements ActionListener, WindowListener, KeyListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4016819477611948502L;

	private JTextField message;
	private JTextField response;
	private JButton send;
	private Client client;
	private ArrayList<Memento> states;
	private int currentState;

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
		initClient();
	}

	/**
	 * Initializes a new thread for the client to work on.
	 */
	private void initClient() {
		client = new Client(response);
		Thread clientThread = new Thread(client);
		clientThread.start();
		states = new ArrayList<>();
		currentState = 0;
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
		send = new JButton();
		send.setText("Send");
		send.addActionListener(this);
		send.setEnabled(true);
		message = new JTextField();
		response = new JTextField();
		response.setEditable(false);
		Panel textPane = new Panel(new GridLayout(2, 1, 5, 5));
		textPane.add(response);
		textPane.add(message);
		message.addKeyListener(this);

		addWindowListener(this);
		setTitle("Client");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(textPane, BorderLayout.CENTER);
		getContentPane().add(send, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		client.setMessage(message.getText());
		states.add(Originator.createMemento(message.getText()));
		currentState++;
		message.setText("");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		client.setMessage(".");
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (currentState < states.size()) {
				message.setText(Originator.getState(states.get(currentState)));
				currentState++;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (currentState > 0) {
				currentState--;
				message.setText(Originator.getState(states.get(currentState)));
			}
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			client.setMessage(message.getText());
			states.add(Originator.createMemento(message.getText()));
			currentState++;
			message.setText("");
		}

	}
}
