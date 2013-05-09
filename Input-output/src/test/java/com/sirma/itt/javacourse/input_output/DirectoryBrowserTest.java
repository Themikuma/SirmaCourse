package com.sirma.itt.javacourse.input_output;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * Test the DirectoryBrowser class.
 * 
 * @author gdimitrov
 */
public class DirectoryBrowserTest {
	/**
	 * Tests the listContent function by giving a path to the user folder of the current user.
	 * 
	 * @throws NoSuchFileException
	 *             when the directory wasn't found.
	 */
	@Test
	public void testListContentForADirectory() throws NoSuchFileException {
		Path path = Paths.get(System.getProperty("user.home"));
		String content = DirectoryBrowser.listContent(path.toString());
		assertEquals("Directory", content);
	}

	/**
	 * Test the listContent function by giving a path to a file that is created in the current test.
	 * 
	 * @throws NoSuchFileException
	 *             when the file wasn't found.
	 */
	@Test
	public void testListContetForAFile() throws NoSuchFileException {
		String fileName = "test.txt";
		Path path = Paths.get(System.getProperty("user.home"), "Documents", fileName);
		// Create a file for the current test.
		try {
			Files.deleteIfExists(path);
			SirmaFileWriter.writeFile("", path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String content = DirectoryBrowser.listContent(path.toString());
		// Perform cleanup of the newly created file.
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("File", content);
	}

	/**
	 * Test the listContent function by giving an invalid path.
	 * 
	 * @throws NoSuchFileException
	 *             when the file/directory wasn't found.
	 */
	@Test(expected = NoSuchFileException.class)
	public void testListContentForInvalidPath() throws NoSuchFileException {
		Path path = Paths.get(System.getProperty("user.home"), "Doesn't exist");
		DirectoryBrowser.listContent(path.toString());
	}
}
