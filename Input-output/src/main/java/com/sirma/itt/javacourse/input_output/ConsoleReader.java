package com.sirma.itt.javacourse.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads input from the console.
 * 
 * @author gdimitrov
 */
public final class ConsoleReader {
	/**
	 * Private constructor for utility classes.
	 */
	private ConsoleReader() {
	}

	/**
	 * Reads a line of text from the console. The line is terminated by a newline symbol ('\n').
	 * 
	 * @return the input as a string.
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static String readString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		return line;
	}

	/**
	 * Reads a number from the console. The input is terminated with an empty space or a newline.
	 * 
	 * @return the input as a integer
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static int readInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		line = line.split(" ")[0];
		int result = 0;
		try {
			result = Integer.parseInt(line);
		} catch (Exception e) {
			System.out.println("The input wasn't a valid number.");
			throw new NumberFormatException();
		}
		return result;
	}

	/**
	 * Reads a number from the console. The input is terminated with an empty space or a newline.
	 * 
	 * @return the input as a floating point number
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static double readFloat() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		line = line.split(" ")[0];
		double result = 0;
		try {
			result = Float.parseFloat(line);
		} catch (Exception e) {
			System.out.println("The input wasn't a valid number.");
			throw new NumberFormatException();
		}
		return result;
	}

	/**
	 * Reads a single char from the console.
	 * 
	 * @return a single character from the input.
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	public static char readChar() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c = 0;
		c = (char) br.read();
		return c;
	}

}
