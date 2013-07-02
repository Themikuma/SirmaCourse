package com.sirma.itt.javacourse.networkingandgui.clientinfo;

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
		ServerGUI server = new ServerGUI(300, 300);
		ClientGUI client = new ClientGUI(200, 300);
		ClientGUI client2 = new ClientGUI(300, 300);
		ClientGUI client3 = new ClientGUI(300, 300);
		ClientGUI client4 = new ClientGUI(300, 300);
		ClientGUI client5 = new ClientGUI(300, 300);
	}
}
