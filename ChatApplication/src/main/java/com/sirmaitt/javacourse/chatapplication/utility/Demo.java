package com.sirmaitt.javacourse.chatapplication.utility;

import com.sirmaitt.javacourse.chatapplication.server.ServerGUI;

/**
 * @author gdimitrov
 */
public final class Demo {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this metod.
	 */
	public static void main(String[] args) {
		ServerGUI server = new ServerGUI(300, 300);
	}
}
