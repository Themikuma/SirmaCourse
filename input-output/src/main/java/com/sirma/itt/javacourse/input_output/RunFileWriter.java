package com.sirma.itt.javacourse.input_output;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

		Path path = Paths.get(System.getProperty("user.home"), "Documents");
		try {
			SirmaFileWriter.writeFile(path, "test.txt", "append me to the file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
