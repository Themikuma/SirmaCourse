package com.sirmaitt.javacourse.chatapplication.client;

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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.sirmaitt.javacourse.chatapplication.util.Messages;

/**
 * Creates the window that holds the GUI for the client.
 * 
 * @author gdimitrov
 */
public class ClientGUI extends JFrame implements ActionListener,
		WindowListener, KeyListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4016819477611948502L;

	private JTextField message;
	private JTextField response;
	private JButton send;
	private Client client;
	private List<MessageState> states;
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
		initDialog();
	}

	private void initDialog() {

		JTextField host = new JTextField("url:port");
		JTextField nickname = new JTextField("nickname");
		Object[] msg = { "Host: ", host, "Nickname", nickname };

		JOptionPane op = new JOptionPane(msg, JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null);
		boolean connected = false;
		while (!connected) {
			JDialog dialog = op.createDialog(this, "Connect to a server");
			dialog.setVisible(true);
			int result = JOptionPane.OK_OPTION;
			try {
				result = ((Integer) op.getValue()).intValue();
			} catch (Exception uninitializedValue) {
			}

			if (result == JOptionPane.OK_OPTION) {
				connected = initClient(host.getText(), nickname.getText());
			} else {
				dispose();
				return;
			}
		}
	}

	/**
	 * Initializes a new thread for the client to work on.
	 */
	private boolean initClient(String address, String nickname) {
		client = new Client(response);
		if (client.connect(address, nickname)) {
			Thread clientThread = new Thread(client);
			clientThread.start();
			states = new ArrayList<>();
			currentState = 0;
			return true;
		}
		return false;
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
		JScrollPane responsePane = new JScrollPane(response);
		response.setEditable(false);
		Panel messagePane = new Panel(new GridLayout(2, 1, 5, 0));
		messagePane.add(message);
		messagePane.add(send);
		message.addKeyListener(this);

		addWindowListener(this);
		setTitle("Client");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(responsePane, BorderLayout.CENTER);
		getContentPane().add(messagePane, BorderLayout.SOUTH);
		setVisible(true);
	}

	/**
	 * Sends the message to the server.
	 */
	private void sendMessage() {
		client.sendMessage(message.getText());
		states.add(StateManager.createMemento(message.getText()));
		currentState++;
		message.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sendMessage();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		client.sendMessage(Messages.DISCONNECTED.toString());
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
				message.setText(StateManager.getState(states.get(currentState)));
				currentState++;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (currentState > 0) {
				currentState--;
				message.setText(StateManager.getState(states.get(currentState)));
			}
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendMessage();
		}

	}
}
