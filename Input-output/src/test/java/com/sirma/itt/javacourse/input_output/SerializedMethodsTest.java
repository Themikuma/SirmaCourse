package com.sirma.itt.javacourse.input_output;

import static org.junit.Assert.assertEquals;

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
		String path = "C:\\Users\\user\\Documents\\Test.txt";
		SerializedMethods.saveObject(path, serializableObject);
		Object newObject = null;
		newObject = SerializedMethods.getObject(path);
		assertEquals("class com.sirma.itt.javacourse.input_output.DataClass", newObject.getClass()
				.toString());
	}
}
