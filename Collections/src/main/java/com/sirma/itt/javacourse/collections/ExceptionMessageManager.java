package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Gets a combination of predefined messages and constructs them to a single string.
 * 
 * @author gdimitrov
 */
public class ExceptionMessageManager {
	private String message;
	private Map<String, String> exceptions;
	private static final String SEPARATOR = "|";
	private boolean first;

	/**
	 * Creates the exceptions map for the class.
	 */
	public ExceptionMessageManager() {
		first = true;
		message = "";
		exceptions = new HashMap<String, String>();
		exceptions.put("Invalid number", "Your debit card number is invalid.");
		exceptions.put("Invalid SSN", "The Social Security Number you entered is invalid.");
		exceptions.put("Invalid PC", "The Postal Code you entered is invalid.");
	}

	/**
	 * Getter method for message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets all the messages that were added in input parameter using the message separator "|" and
	 * returns them as a collection.
	 * 
	 * @param messagesCombination
	 *            the message to split.
	 * @return a collection of all the messages.
	 */
	public static Collection<String> getMessages(String messagesCombination) {
		String[] messages = messagesCombination.split("[" + SEPARATOR + "]");
		ArrayList<String> result = new ArrayList<String>();
		for (String message : messages) {
			result.add(message);
		}
		return result;

	}

	/**
	 * Adds an exception message from the map using it's value.
	 * 
	 * @param mess
	 *            the message of the exception.
	 */
	public void addExceptionMessage(String mess) {
		if (exceptions.containsValue(mess)) {
			if (first) {
				first = false;
				message = mess;
			} else {
				message = message + SEPARATOR + mess;
			}
		} else {
			throw new NoSuchElementException("Message not found");
		}
	}

	/**
	 * Adds an exception message by using it's code to find it.
	 * 
	 * @param messageCode
	 *            the code of the message to add.
	 */
	public void addExceptionMessageUsingCode(String messageCode) {
		if (exceptions.containsKey(messageCode)) {
			if (first) {
				message = exceptions.get(messageCode);
				first = false;
			} else {
				message = message + SEPARATOR + exceptions.get(messageCode);
			}
		} else {
			throw new NoSuchElementException("Key not found");
		}
	}
}
