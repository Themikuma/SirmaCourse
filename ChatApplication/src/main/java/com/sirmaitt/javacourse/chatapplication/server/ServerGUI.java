package com.sirmaitt.javacourse.chatapplication.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirmaitt.javacourse.chatapplication.utility.JTextFieldLimit;
import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;

/**
 * Creates the window that holds the GUI for the server.
 * 
 * @author gdimitrov
 */
public class ServerGUI extends JFrame implements WindowListener, ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4016819477611948502L;

	private JTextArea log;
	private Server server;

	private JMenuBar menubar;
	private JMenu file;
	private JMenu languages;
	private JMenuItem stop;
	private JMenuItem start;
	private JMenuItem exit;
	private JMenuItem en;
	private JMenuItem bg;
	private static final Locale BULGARIAN = new Locale("bg");

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
		log.setLineWrap(true);
		log.setWrapStyleWord(true);
		JScrollPane pane = new JScrollPane(log);
		initMenu();

		addWindowListener(this);
		setTitle("Server");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(pane, BorderLayout.CENTER);
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
		start = new JMenuItem();
		start.setMnemonic(KeyEvent.VK_S);
		start.addActionListener(this);
		stop = new JMenuItem();
		stop.setMnemonic(KeyEvent.VK_T);
		stop.addActionListener(this);
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

		file.add(start);
		file.add(stop);
		file.add(exit);
		languages.add(en);
		languages.add(bg);
		menubar.add(file);
		menubar.add(languages);
		setJMenuBar(menubar);
	}

	/**
	 * Stops the server in case it's running.
	 */
	private void stopServer() {
		if (server != null) {
			server.stop();
		}
	}

	/**
	 * Initialises the server.
	 */
	private void initServer() {
		JTextField host = new JTextField();
		host.setDocument(new JTextFieldLimit(5));
		host.setText("7000");
		int result;
		Object[] msg = { "Port: ", host };
		JOptionPane op = new JOptionPane(msg, JOptionPane.QUESTION_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null);
		result = JOptionPane.CLOSED_OPTION;
		JDialog dialog = op.createDialog(this, "Connect to a server");
		setEnabled(false);
		dialog.setVisible(true);
		try {
			result = (int) op.getValue();
		} catch (Exception e) {
		}
		if (result == JOptionPane.OK_OPTION) {
			int port = 0;
			try {
				port = Integer.parseInt(host.getText());
			} catch (NumberFormatException e) {
				setEnabled(true);
				log.append(ServerMessages.getMessage("port", ResourceNames.Messages)
						+ System.lineSeparator());
				requestFocus();
				return;
			}
			stopServer();
			server = new Server(port, new UILogManager(this));
			Thread connectionThread = new Thread(server);
			connectionThread.start();
		}
		setEnabled(true);
		requestFocus();
	}

	/**
	 * Refreshes the captions of all the labels using the current language.
	 */
	private void refreshCaptions() {
		file.setText(ServerMessages.getMessage("file", ResourceNames.UserInterface));
		languages.setText(ServerMessages.getMessage("lang", ResourceNames.UserInterface));
		en.setText(ServerMessages.getMessage("en", ResourceNames.UserInterface));
		exit.setText(ServerMessages.getMessage("exit", ResourceNames.UserInterface));
		stop.setText(ServerMessages.getMessage("stop", ResourceNames.UserInterface));
		start.setText(ServerMessages.getMessage("start", ResourceNames.UserInterface));
		bg.setText(ServerMessages.getMessage("bg", ResourceNames.UserInterface));
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		stopServer();
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			initServer();
		}
		if (e.getSource() == stop) {
			stopServer();
		}
		if (e.getSource() == exit) {
			stopServer();
			dispose();
		}
		if (e.getSource() == en) {
			ServerMessages.setLocale(Locale.ENGLISH);
			refreshCaptions();
		}
		if (e.getSource() == bg) {
			ServerMessages.setLocale(BULGARIAN);
			refreshCaptions();
		}
	}
}
