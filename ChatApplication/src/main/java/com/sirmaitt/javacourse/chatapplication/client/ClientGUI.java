package com.sirmaitt.javacourse.chatapplication.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirmaitt.javacourse.chatapplication.utility.JTextFieldLimit;
import com.sirmaitt.javacourse.chatapplication.utility.Messages;
import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;

/**
 * Creates the window that holds the GUI for the client.
 * 
 * @author gdimitrov
 */
public class ClientGUI extends JFrame implements ActionListener, KeyListener {

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
	private JLabel error;

	private JMenuBar menubar;
	private JMenu file;
	private JMenu languages;
	private JMenuItem disconnect;
	private JMenuItem connect;
	private JMenuItem exit;
	private JMenuItem en;
	private JMenuItem bg;
	private static final Locale BULGARIAN = new Locale("bg");

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
	 * Creates the dialog that waits for user input.
	 */
	private void initDialog() {
		JTextField host = new JTextField("localhost:7000");
		JTextField nickname = new JTextField();
		nickname.setDocument(new JTextFieldLimit(20));
		nickname.setText("nickname");
		error = new JLabel("");
		error.setForeground(Color.red);
		String address = null;
		String nick = null;
		int result;
		Object[] msg = { ClientResources.getMessage("host", ResourceNames.UserInterface), host,
				ClientResources.getMessage("nickname", ResourceNames.UserInterface), nickname,
				error };
		JOptionPane op = new JOptionPane(msg, JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null);
		boolean connected = false;
		while (!connected) {
			result = JOptionPane.CLOSED_OPTION;
			JDialog dialog = op.createDialog(this,
					ClientResources.getMessage("connectServer", ResourceNames.UserInterface));
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
				if (nick.contains("[") || nick.contains("]") || (nick == null)) {
					error.setText(ClientResources.getMessage("nickname_invalid",
							ResourceNames.Errors));
					nick = "";
				}
				connected = initClient(address, nick);
				setEnabled(true);
				requestFocus();
			} else {
				setEnabled(true);
				return;
			}
		}
		connect.setEnabled(false);
		disconnect.setEnabled(true);
	}

	/**
	 * Refreshes the captions of all the labels using the current language.
	 */
	private void refreshCaptions() {
		file.setText(ClientResources.getMessage("file", ResourceNames.UserInterface));
		languages.setText(ClientResources.getMessage("lang", ResourceNames.UserInterface));
		en.setText(ClientResources.getMessage("en", ResourceNames.UserInterface));
		exit.setText(ClientResources.getMessage("exit", ResourceNames.UserInterface));
		disconnect.setText(ClientResources.getMessage("disconnect", ResourceNames.UserInterface));
		connect.setText(ClientResources.getMessage("connect", ResourceNames.UserInterface));
		bg.setText(ClientResources.getMessage("bg", ResourceNames.UserInterface));
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
			message.setForeground(Color.black);
			Thread clientThread = new Thread(client);
			clientThread.setDaemon(true);
			clientThread.start();
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
		send = new JButton();
		send.setText("Send");
		states = new ArrayList<>();
		send.addActionListener(this);
		send.setEnabled(true);
		message = new JTextField();
		message.setDocument(new JTextFieldLimit(200));
		chatLog = new JTextArea();
		chatLog.setLineWrap(true);
		chatLog.setWrapStyleWord(true);
		clients = new JTextArea("                    ");
		clients.setEditable(false);
		JPanel responsePane = new JPanel(new GridBagLayout());
		JScrollPane responseScroll = new JScrollPane(chatLog);
		JScrollPane usersScroll = new JScrollPane(clients);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 0.75;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 0.5;
		constraints.gridwidth = 4;
		constraints.gridx = 0;
		constraints.gridy = 0;
		responsePane.add(responseScroll, constraints);
		constraints.weightx = 0.25;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		constraints.gridx = 4;
		constraints.gridy = 0;
		responsePane.add(usersScroll, constraints);
		chatLog.setEditable(false);
		Panel messagePane = new Panel(new GridLayout(2, 1, 5, 0));
		messagePane.add(message);
		messagePane.add(send);
		message.addKeyListener(this);
		initMenu();

		setMinimumSize(new Dimension(300, 300));
		setTitle("Client");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(responsePane, BorderLayout.CENTER);
		getContentPane().add(messagePane, BorderLayout.SOUTH);
		setVisible(true);
	}

	/**
	 * Creates the navigational menu for the window.
	 */
	private void initMenu() {
		menubar = new JMenuBar();
		file = new JMenu();
		file.setMnemonic(KeyEvent.VK_F);
		languages = new JMenu();
		languages.setMnemonic(KeyEvent.VK_L);
		connect = new JMenuItem();
		connect.setMnemonic(KeyEvent.VK_C);
		connect.addActionListener(this);
		disconnect = new JMenuItem();
		disconnect.setMnemonic(KeyEvent.VK_T);
		disconnect.addActionListener(this);
		disconnect.setEnabled(false);
		exit = new JMenuItem();
		exit.setMnemonic(KeyEvent.VK_X);
		exit.addActionListener(this);
		en = new JMenuItem();
		en.setMnemonic(KeyEvent.VK_E);
		en.addActionListener(this);
		bg = new JMenuItem();
		bg.setMnemonic(KeyEvent.VK_B);
		bg.addActionListener(this);
		refreshCaptions();

		file.add(connect);
		file.add(disconnect);
		file.add(exit);
		languages.add(en);
		languages.add(bg);
		menubar.add(file);
		menubar.add(languages);
		setJMenuBar(menubar);

	}

	/**
	 * Sends the message to the server.
	 */
	private void sendMessage() {
		try {
			client.sendMessage(message.getText());
			states.add(StateManager.createMemento(message.getText()));
			currentState++;
			message.setText("");
		} catch (NullPointerException e1) {
			message.setForeground(Color.red);
			message.setText(ClientResources.getMessage("not_connected", ResourceNames.Errors));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == send) {
			sendMessage();
		}
		if (e.getSource() == connect) {
			initDialog();
		}
		if (e.getSource() == disconnect) {
			if (client != null) {
				client.sendMessage(Messages.DISCONNECTED.toString());
				client = null;
			}
			disconnect.setEnabled(false);
			connect.setEnabled(true);
			clients.setText("");
		}
		if (e.getSource() == exit) {
			dispose();
		}
		if (e.getSource() == en) {
			ClientResources.setLocale(Locale.ENGLISH);
			refreshCaptions();
		}
		if (e.getSource() == bg) {
			ClientResources.setLocale(BULGARIAN);
			refreshCaptions();
		}
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

	/**
	 * Getter method for error.
	 * 
	 * @return the error
	 */
	public JLabel getError() {
		return error;
	}

}
