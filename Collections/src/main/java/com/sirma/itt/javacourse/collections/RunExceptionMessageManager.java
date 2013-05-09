package com.sirma.itt.javacourse.collections;

import java.util.Collection;

/**
 * Contains an entry point method for the ExceptionMessageManager class.
 * 
 * @author gdimitrov
 */
public final class RunExceptionMessageManager {

	/**
	 * Private constructor for utility classes.
	 */
	private RunExceptionMessageManager() {
	}

	/**
	 * Runs the ExceptionMessageManager class and demontrates how it works.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method.
	 */
	public static void main(String[] args) {
		ExceptionMessageManager manager = new ExceptionMessageManager();
		manager.addExceptionMessage("Your debit card number is invalid.");
		manager.addExceptionMessageUsingCode("Invalid SSN");
		// manager.addExceptionMessage("Doesn't exist");
		System.out.println(manager.getMessage());
		Collection<String> messages = ExceptionMessageManager.getMessages(manager.getMessage());
		for (String string : messages) {
			System.out.println(string);
		}
	}

}
