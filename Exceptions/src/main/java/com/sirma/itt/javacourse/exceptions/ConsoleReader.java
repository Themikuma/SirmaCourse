package com.sirma.itt.javacourse.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A custom console reader class.
 * 
 * @author gdimitrov
 */
public final class ConsoleReader {
	/**
	 * Private constructor for a utility class.
	 */
	private ConsoleReader() {
	}

	/**
	 * Reads the console input.
	 * 
	 * @throws ConsoleReadException
	 *             {@link ConsoleReadException}
	 */
	public static void read() throws ConsoleReadException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int number = 0;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			number = Integer.parseInt(line);
		} catch (Exception e) {
			throw new ConsoleReadException("The input is not a valid number", e);
		}
		if (number > 100 || number < 0) {
			throw new ConsoleReadException("Number out of bounds");
		}
	}
}
