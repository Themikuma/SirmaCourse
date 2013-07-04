package com.sirma.itt.javacourse.networkingandgui.download;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * Creates a UI that lets the user download a file.
 * 
 * @author gdimitrov
 */
public class FileDownloadUI extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -8397151569602189854L;
	private JTextField url;
	private JLabel result;
	private JPanel buttonsPane;
	private JButton download;
	private JProgressBar progress;

	/**
	 * Creates the downloader.
	 * 
	 * @param width
	 *            the width of the initial window.
	 * @param height
	 *            the height of the initial window.
	 */
	public FileDownloadUI(int width, int height) {
		initComponents(width, height);
	}

	/**
	 * The actual creation of the download agent.
	 * 
	 * @param width
	 *            the width of the initial window.
	 * @param height
	 *            the height of the initial window.
	 */
	private void initComponents(int width, int height) {

		url = new JTextField();
		result = new JLabel("fds");
		progress = new JProgressBar(0, 100);
		progress.setStringPainted(true);
		result.setBackground(Color.white);
		result.setHorizontalAlignment(JLabel.CENTER);
		result.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		result.setOpaque(true);
		JPanel contentPane = new JPanel(new GridLayout(2, 1, 5, 5));
		contentPane.add(url);
		buttonsPane = new JPanel(new GridLayout(1, 2, 5, 5));
		download = new JButton("Download");
		download.addActionListener(this);
		buttonsPane.add(download);
		buttonsPane.add(progress);
		contentPane.add(buttonsPane);

		setTitle("Downloader");
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(contentPane, BorderLayout.NORTH);
		getContentPane().add(result, BorderLayout.CENTER);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DownloadExecutor dl = new DownloadExecutor(url.getText(), this);
		Thread t1 = new Thread(dl);
		t1.start();
		result.setText("Downloading");
	}

	/**
	 * Getter method for result.
	 * 
	 * @return the result
	 */
	public JLabel getResult() {
		return result;
	}

	/**
	 * Getter method for progress.
	 * 
	 * @return the progress
	 */
	public JProgressBar getProgress() {
		return progress;
	}
}
