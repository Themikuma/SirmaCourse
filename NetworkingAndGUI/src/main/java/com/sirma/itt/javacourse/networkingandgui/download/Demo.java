package com.sirma.itt.javacourse.networkingandgui.download;

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
	 *            array of command-line arguments passed to this method.
	 */
	public static void main(String[] args) {
		Downloader downloader = new Downloader(300, 300);
	}

}