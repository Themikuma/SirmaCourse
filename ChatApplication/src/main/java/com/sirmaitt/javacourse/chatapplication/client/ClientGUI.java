package com.sirmaitt.javacourse.chatapplication.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirmaitt.javacourse.chatapplication.utility.JTextFieldLimit;
import com.sirmaitt.javacourse.chatapplication.utility.Messages;
import com.sirmaitt.javacourse.chatapplication.utility.UIManager;

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
	private JTextArea clients;
	private JTextArea chatLog;
	private JButton send;
	private Client client;
	private List<MessageState> states;
	private int currentState;
	private JScrollBar vertical;

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

	/**
	 * Creates the dialog that waits for user input.
	 */
	private void initDialog() {
		JTextField host = new JTextField("localhost:7007");
		JTextField nickname = new JTextField("nickname");
		nickname.setDocument(new JTextFieldLimit(20));
		JLabel error = new JLabel();
		String address = null;
		String nick = null;
		int result;
		Object[] msg = { "Host: ", host, "Nickname", nickname, error };
		JOptionPane op = new JOptionPane(msg, JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null);
		boolean connected = false;
		while (!connected) {
			result = JOptionPane.CLOSED_OPTION;
			JDialog dialog = op.createDialog(this, "Connect to a server");
			setEnabled(false);
			dialog.setVisible(true);
			try {
				result = (int) op.getValue();
			} catch (Exception e) {
			}
			if (result == JOptionPane.OK_OPTION) {
				address = host.getText();
				nick = nickname.getText();
				if (address == null) {
					address = "";
				}
				if (nick == null) {
					nick = "";
				}
				connected = initClient(address, nick);
				setEnabled(true);
				requestFocus();
			} else {
				dispose();
				return;
			}
		}
	}

	/**
	 * Initializes a new thread for the client to work on.
	 * 
	 * @param address
	 *            the address of the server.
	 * @param nickname
	 *            the nickname of the client.
	 * @return true if the client was successfully initiated.
	 */
	private boolean initClient(String address, String nickname) {
		client = new Client(new UIManager(this));
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
		chatLog = new JTextArea();
		chatLog.setLineWrap(true);
		clients = new JTextArea();
		Panel responsePane = new Panel(new GridBagLayout());
		JScrollPane responseScroll = new JScrollPane(chatLog);
		JScrollPane usersScroll = new JScrollPane(clients);
		GridBagConstraints constraints = new GridBagConstraints();
		vertical = responseScroll.getVerticalScrollBar();
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 0.5;
		constraints.gridwidth = 4;
		constraints.gridx = 0;
		constraints.gridy = 0;
		responsePane.add(responseScroll, constraints);
		constraints.weightx = 0.5;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 0.5;
		constraints.gridwidth = 1;
		constraints.gridx = 4;
		constraints.gridy = 0;
		responsePane.add(usersScroll, constraints);
		chatLog.setEditable(false);
		Panel messagePane = new Panel(new GridLayout(2, 1, 5, 0));
		messagePane.add(message);
		messagePane.add(send);
		message.addKeyListener(this);

		setMinimumSize(new Dimension(300, 300));
		addWindowListener(this);
		setTitle("Client");
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
		vertical.setValue(vertical.getMaximum());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sendMessage();
	}

	@Override
	public void windowOpened(WindowEvent e) {
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
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
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

	/**
	 * Getter method for chatLog.
	 * 
	 * @return the chatLog
	 */
	public JTextArea getChatLog() {
		return chatLog;
	}

	/**
	 * Getter method for clients.
	 * 
	 * @return the clients
	 */
	public JTextArea getClients() {
		return clients;
	}
}
