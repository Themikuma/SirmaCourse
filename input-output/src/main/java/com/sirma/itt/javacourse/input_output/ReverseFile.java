package com.sirma.itt.javacourse.input_output;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
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
	 * @param path
	 *            - the path to the file.
	 * @param fileName
	 *            - the name of the file to be reversed.
	 * @return the reversed string.
	 * @throws FileNotFoundException
	 *             If the file to reverse wasn't found
	 */
	public static String reverseFile(Path path, String fileName) throws FileNotFoundException {
		StringBuffer toBeReversed = new StringBuffer();
		Path filePath = Paths.get(path.toString(), fileName);
		if (Files.notExists(filePath, LinkOption.NOFOLLOW_LINKS)) {
			throw new FileNotFoundException("File was not found");
		}
		try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(filePath,
				Charset.defaultCharset()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				toBeReversed.append(line);
				toBeReversed.append("\n");
			}
			Files.delete(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String reversed = toBeReversed.reverse().toString();
		try {
			SirmaFileWriter.writeFile(path, fileName, reversed);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reversed;
	}
}
