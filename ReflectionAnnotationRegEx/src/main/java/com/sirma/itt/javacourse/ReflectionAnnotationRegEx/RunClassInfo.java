package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

/**
 * Runs class info to demonstrate it's functionality.
 * 
 * @author gdimitrov
 */
public final class RunClassInfo {
	/**
	 * Private constructor for utility classes.
	 */
	private RunClassInfo() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		ClassInfo.getInfo(new Dummy());
		System.out.println();
		ClassInfo.getInfo("");
		System.out.println();
		ClassInfo.getInfo(4);
	}
}
