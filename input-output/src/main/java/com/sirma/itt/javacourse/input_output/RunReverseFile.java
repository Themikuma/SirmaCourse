package com.sirma.itt.javacourse.input_output;

import java.io.IOException;

/**
 * Contains an entry point method which executes the ReverseFile class.
 * 
 * @author gdimitrov
 */
public final class RunReverseFile {
	/**
	 * Private constructor for utility classes.
	 */
	private RunReverseFile() {
	}

	/**
	 * Runs the ReverseFile class.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		try {
			ReverseFile.reverseFile(ConsoleReader.readString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
