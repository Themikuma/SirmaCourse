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
	 * @param path
	 *            the path to the file.
	 * @param fileName
	 *            the name of the file to be written to.
	 * @throws IOException
	 *             if there is an I/O exception
	 */
	public static void writeFile(Path path, String fileName) throws IOException {
		StringBuilder userInput = new StringBuilder();
		Path filePath = Paths.get(path.toString(), fileName);
		String line = null;
		while (!".".equals(line)) {
			line = ConsoleReader.readString();
			userInput.append(line);
			userInput.append("\n");
		}
		writeFile(userInput.toString(), filePath);
	}

	/**
	 * Writes the given input to a file. If the file doesn't exist it's first created.
	 * 
	 * @throws IOException
	 *             if there is an I/O exception
	 * @param path
	 *            the path to the file
	 * @param input
	 *            the user input
	 */
	public static void writeFile(String input, Path path) throws IOException {
		try (BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(path,
				StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
			out.write(input.getBytes());
		}
	}
}
