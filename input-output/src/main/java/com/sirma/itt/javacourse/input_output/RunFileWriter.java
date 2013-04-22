package com.sirma.itt.javacourse.input_output;

import java.io.IOException;

/**
 * Contains an entry point method to run the FileWriter class.
 * 
 * @author gdimitrov
 */
public final class RunFileWriter {
	/**
	 * Private constructor for utility classes.
	 */
	private RunFileWriter() {
	}

	/**
	 * Runs the FIleWriter class.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		try {
			SirmaFileWriter.writeFile(ConsoleReader.readString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
