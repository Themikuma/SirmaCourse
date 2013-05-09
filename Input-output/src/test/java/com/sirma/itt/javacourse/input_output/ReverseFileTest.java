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
	/**
	 * Sets the tests up by recreating a file with a given structure.
	 */
	@Before
	public void setup() {
	}

	/**
	 * Tests the reverse function with an existing file.
	 */
	@Test
	public void testReverseWithExistingFile() {
		String fileName = "test.txt";
		String text = "the text of\n the file";
		Path path = Paths.get(System.getProperty("user.home"), fileName);
		try {
			Files.deleteIfExists(path);
			SirmaFileWriter.writeFile(text, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Get the reversed file.
		String reverseFile = null;
		try {
			reverseFile = ReverseFile.reverseFile(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Clean up
		Path filePath = Paths.get(path.toString(), fileName);
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
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
		ReverseFile.reverseFile(Paths.get("Not existing"));
	}

	/**
	 * Performs a cleanup after the tests are done.
	 */
	@After
	public void cleanUp() {
	}
}
