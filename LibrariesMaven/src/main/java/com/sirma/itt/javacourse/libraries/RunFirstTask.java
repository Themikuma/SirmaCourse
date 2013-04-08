package com.sirma.itt.javacourse.libraries;

import main.java.FirstTask;

/**
 * This class runs some of the methods from the imported JAR that contains all of the solutions to
 * the first task
 * 
 * @author gdimitrov
 */
public class RunFirstTask {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstTask firstTask = new FirstTask();
		System.out.println(firstTask.gcd(100, 44));
		System.out.println(firstTask.lcm(254, 566));
	}
}
