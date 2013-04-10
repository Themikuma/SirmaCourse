package com.sirma.itt.javacourse.exceptions;

/**
 * Runner for the sumator class.
 * 
 * @author gdimitrov
 */
public final class RunSumator {
	/**
	 * Private constructor for a utility class.
	 */
	private RunSumator() {
	}

	/**
	 * Run the sumator class using strings.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		System.out.println(Sumator.sum("33441234544", "12455354"));
	}

}
