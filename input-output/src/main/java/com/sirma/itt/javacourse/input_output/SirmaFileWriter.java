package com.sirma.itt.javacourse.input_output;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Creates a file and then writes the console input to it.
 * 
 * @author gdimitrov
 */
public final class SirmaFileWriter {
	/**
	 * Private constructor for utility classes.
	 */
	private SirmaFileWriter() {
	}

	/**
	 * Writes console input to a file.
	 * 
	 * @param fileName
	 *            the name of the file to be written to.
	 * @throws IOException
	 *             if there is an I/O exception
	 */
	public static void writeFile(String fileName) throws IOException {
		StringBuilder userInput = new StringBuilder();
		String line = null;
		while (!".".equals(line)) {
			line = ConsoleReader.readString();
			userInput.append(line);
			userInput.append("\n");
		}
		writeFile(fileName, userInput.toString());
	}

	/**
	 * Writes the given input to a file. If the file doesn't exist it's first created.
	 * 
	 * @throws IOException
	 *             if there is an I/O exception
	 * @param fileName
	 *            the name of the file to be written to.
	 * @param input
	 *            the user input
	 */
	public static void writeFile(String fileName, String input) throws IOException {
		Path path = Paths.get(System.getProperty("user.home"), "My Documents", fileName);
		try (BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(path,
				StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
			out.write(input.getBytes());
		}

	}
}
