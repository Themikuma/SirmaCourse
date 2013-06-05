package com.sirma.itt.javacourse.threads.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runs the counter until user input is provided and then prints the value of the counter.
 * 
 * @author gdimitrov
 */
public final class Demo {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo() {

	}

	/**
	 * @param args
	 *            array of command-line arguments provided by the user.
	 */
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread t = new Thread(counter);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		t.start();
		try {
			reader.read();
			counter.setRun(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(counter.getCurrent());
	}

}
