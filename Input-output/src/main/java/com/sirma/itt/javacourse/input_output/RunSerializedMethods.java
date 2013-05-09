package com.sirma.itt.javacourse.input_output;

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
		String path = "C:\\Users\\user\\Documents\\Test.txt";
		SerializedMethods.saveObject(path, serializableObject);
		Object newObject = null;
		newObject = SerializedMethods.getObject(path);
		System.out.println(newObject.getClass());
	}

}
