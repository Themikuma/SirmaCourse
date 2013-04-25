package com.sirma.itt.javacourse.input_output;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the ReverseFile class.
 * 
 * @author gdimitrov
 */
public class ReverseFileTest {
	private String fileName;
	private Path path;

	/**
	 * Sets the tests up by recreating a file with a given structure.
	 */
	@Before
	public void setup() {
		fileName = "test.txt";
		String text = "the text of\n the file";
		path = Paths.get(System.getProperty("user.home"));
		Path filePath = Paths.get(path.toString(), fileName);
		try {
			Files.deleteIfExists(filePath);
			SirmaFileWriter.writeFile(path, fileName, text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests the reverse function with an existing file.
	 */
	@Test
	public void testReverseWithExistingFile() {
		String reverseFile = null;
		try {
			reverseFile = ReverseFile.reverseFile(path, fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("\nelif eht \nfo txet eht", reverseFile);
	}

	/**
	 * Test the reverse function with a non existing file.
	 * 
	 * @throws FileNotFoundException
	 *             occurs when the file to reverse doesn't exist
	 */
	@Test(expected = FileNotFoundException.class)
	public void testReverseWithNonExistingFile() throws FileNotFoundException {
		ReverseFile.reverseFile(path, "NotExistant");
	}

	/**
	 * Performs a cleanup after the tests are done.
	 */
	@After
	public void cleanUp() {
		Path filePath = Paths.get(path.toString(), fileName);
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
