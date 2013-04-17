package com.sirma.itt.javacourse.exceptions;

/**
 * Runner for the console reader class.
 * 
 * @author gdimitrov
 */
public final class RunConsoleReader {
	/**
	 * Private constructor for a utility class.
	 */
	private RunConsoleReader() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this method
	 * @throws ConsoleReadException
	 *             {@link ConsoleReadException}
	 */
	public static void main(String[] args) throws ConsoleReadException {
		try {
			ConsoleReader.read();
			System.out.println("Reading successful");
		} catch (ConsoleReadException e) {
			System.out.println(e.getMessage());
		}
	}

}
