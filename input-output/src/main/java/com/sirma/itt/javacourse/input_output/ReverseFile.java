package com.sirma.itt.javacourse.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Contains methods used to reverse a text file.
 * 
 * @author gdimitrov
 */
public final class ReverseFile {

	/**
	 * Private constructor for utility classes.
	 */
	private ReverseFile() {
	}

	/**
	 * Reverses a text file by putting its entire content into a buffer and then reversing the
	 * buffer.
	 * 
	 * @param fileName
	 *            - the name of the file to be reversed.
	 */
	public static void reverseFile(String fileName) {
		StringBuffer toBeReversed = new StringBuffer();
		Path path = Paths.get(System.getProperty("user.home"), "My Documents", fileName);
		try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(path,
				Charset.defaultCharset()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				toBeReversed.append(line);
				toBeReversed.append("\n");
			}
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String reversed = toBeReversed.reverse().toString();
		try {
			SirmaFileWriter.writeFile(fileName, reversed);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
