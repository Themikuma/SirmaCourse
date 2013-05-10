package com.sirma.itt.javacourse.input_output;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * @author gdimitrov
 */
public class SerializedMethodsTest {
	/**
	 * Test both the save and get object functions.
	 */
	@Test
	public void testSaveAndGetObject() {
		DataClass serializableObject = new DataClass();
		Path path = Paths.get(System.getProperty("user.home"), "test.txt");
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			throw new RuntimeException("Failed to delete the file", e);
		}
		String pathAsString = path.toString();
		SerializedMethods.saveObject(pathAsString, serializableObject);
		Object newObject = null;
		newObject = SerializedMethods.getObject(pathAsString);
		assertEquals("class com.sirma.itt.javacourse.input_output.DataClass", newObject.getClass()
				.toString());
	}
}
