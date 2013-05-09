package com.sirma.itt.javacourse.input_output;

import java.io.IOException;

/**
 * Contains an entry point to run the methods from the ConsoleReader class.
 * 
 * @author gdimitrov
 */
public final class RunConsoleReader {
	/**
	 * Private constructor for utility classes.
	 */
	private RunConsoleReader() {
	}

	/**
	 * Runs the methods in ConsoleReader class.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		// Read an integer.
		try {
			int readInt = ConsoleReader.readInt();
			System.out.println(readInt);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
		}
		// Read a floating point number
		try {
			double readFloat = ConsoleReader.readFloat();
			System.out.println(readFloat);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
		}
		// Read a string
		try {
			System.out.println(ConsoleReader.readString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Read a single character
		try {
			System.out.println(ConsoleReader.readChar());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
