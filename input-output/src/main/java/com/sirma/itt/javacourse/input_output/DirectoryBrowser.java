package com.sirma.itt.javacourse.input_output;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Shows the contents of a directory from the file system.
 * 
 * @author gdimitrov
 */
public final class DirectoryBrowser {
	/**
	 * Private constructor for utility classes.
	 */
	private DirectoryBrowser() {
	}

	/**
	 * Lists the content of a directory, or a message that the given path lead to a file.
	 * 
	 * @param path
	 *            the path to the file/directory.
	 * @return "file" if the path lead to a file, directory if the path was to a directory.
	 * @throws NoSuchFileException
	 *             when the path leads neither to a directory or a file.
	 */
	public static String listContent(String path) throws NoSuchFileException {
		Path filePath = Paths.get(path);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(filePath)) {
			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
		} catch (NotDirectoryException e) {
			System.out.println("The path points to a file");
			return "File";
		} catch (NoSuchFileException e) {
			throw new NoSuchFileException(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Directory";
	}
}
