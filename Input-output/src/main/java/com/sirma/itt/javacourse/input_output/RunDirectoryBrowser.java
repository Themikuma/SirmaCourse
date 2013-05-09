package com.sirma.itt.javacourse.input_output;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Contains an entry point method for the RunDirectoryBrowser.
 * 
 * @author gdimitrov
 */
public final class RunDirectoryBrowser {
	/**
	 * Private constructor for utility classes.
	 */
	private RunDirectoryBrowser() {

	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		Path path = Paths.get(System.getProperty("user.home"), "gameplay.txt");
		try {
			DirectoryBrowser.listContent(path.toString());
		} catch (NoSuchFileException e) {
			e.printStackTrace();
		}

	}
}
