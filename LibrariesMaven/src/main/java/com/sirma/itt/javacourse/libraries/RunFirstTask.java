package com.sirma.itt.javacourse.libraries;

import main.java.FirstTask;

/**
 * This class runs some of the methods from the imported JAR that contains all of the solutions to
 * the first task.
 * 
 * @author gdimitrov
 */
public final class RunFirstTask {
	/**
	 * Private constructor for utility classes.
	 */
	private RunFirstTask() {
	}

	/**
	 * This is a bundle of solutions to tasks one to seven from "Introducing Java".
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		FirstTask firstTask = new FirstTask();
		System.out.println(firstTask.gcd(100, 44));
		System.out.println(firstTask.lcm(254, 566));
	}
}
