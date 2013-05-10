package com.sirma.itt.javacourse.input_output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author gdimitrov
 */
public final class RunSerializedMethods {

	/**
	 * Private constructor for utility classes.
	 */
	private RunSerializedMethods() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed on to this method.
	 */
	public static void main(String[] args) {
		DataClass serializableObject = new DataClass();
		Path path = Paths.get(System.getProperty("user.home"), "test.txt");
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String pathAsString = path.toString();
		SerializedMethods.saveObject(pathAsString, serializableObject);
		Object newObject = null;
		newObject = SerializedMethods.getObject(pathAsString);
		System.out.println(newObject.getClass());
	}

}
