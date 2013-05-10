package com.sirma.itt.javacourse.input_output;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Contains methods for saving and loading serialized objects.
 * 
 * @author gdimitrov
 */
public final class SerializedMethods {
	/**
	 * Private constructor for utility classes.
	 */
	private SerializedMethods() {
	}

	/**
	 * Saves an object in the given file. If the file doesn't exist it's first created.
	 * 
	 * @param path
	 *            the path to the file to save the object
	 * @param serializeableObject
	 *            the object to save
	 */
	public static void saveObject(String path, DataClass serializeableObject) {
		Path filePath = Paths.get(path);
		try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(filePath,
				StandardOpenOption.APPEND, StandardOpenOption.CREATE))) {
			out.writeObject(serializeableObject);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets an instance of the {@link DataClass} object from the selected file.
	 * 
	 * @param path
	 *            the path to the file.
	 * @return an instance of the {@link DataClass} object
	 */
	public static DataClass getObject(String path) {
		Path filePath = Paths.get(path);
		DataClass object = null;
		try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(filePath))) {
			object = (DataClass) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("The contents of the file were not serializable", e);
		}
		return object;
	}
}
