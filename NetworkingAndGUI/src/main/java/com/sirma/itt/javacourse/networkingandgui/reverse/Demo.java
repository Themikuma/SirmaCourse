package com.sirma.itt.javacourse.networkingandgui.reverse;

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
	 * @throws InterruptedException
	 *             if the thread is interrupted.
	 */
	public static void main(String[] args) throws InterruptedException {
		ServerGUI server = new ServerGUI(300, 300);
	}
}
