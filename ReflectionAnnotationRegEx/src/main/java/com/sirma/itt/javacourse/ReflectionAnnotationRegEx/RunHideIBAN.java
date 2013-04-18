package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Contains a main method, demonstrating the HideIBAN class functionality.
 * 
 * @author gdimitrov
 */
public final class RunHideIBAN {
	/**
	 * Private constructor for utility classes.
	 */
	private RunHideIBAN() {
	}

	/**
	 * Runs the HideIBAN class.
	 * 
	 * @param args
	 *            array of command-line arguments given in the console
	 */
	public static void main(String[] args) {
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!"</bankAccounts>".equals(line)) {
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			line = HideIBAN.hideIBAN(line);
			System.out.println(line);
		}
	}
}
