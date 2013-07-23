package com.sirmaitt.javacourse.chatapplication.utility;

import com.sirmaitt.javacourse.chatapplication.client.ClientGUI;

/**
 * @author gdimitrov
 */
public final class Demo2 {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo2() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this metod.
	 * @throws InterruptedException
	 *             if the thread is interrupted.
	 */
	public static void main(String[] args) throws InterruptedException {
		ClientGUI client1 = new ClientGUI(300, 300);
	}
}
