package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the ExceptionMessageManager class.
 * 
 * @author gdimitrov
 */
public class TestExceptionMessageManager {
	private ExceptionMessageManager manager;

	/**
	 * Sets up the tests.
	 */
	@Before
	public void setup() {
		manager = new ExceptionMessageManager();
	}

	/**
	 * Adds messages to the message with an existing value in the map and checks if the values of
	 * the messages were added as expected.
	 */
	@Test
	public void testAddMessagesWithExistingValue() {
		manager.addExceptionMessage("Your debit card number is invalid.");
		manager.addExceptionMessage("The Postal Code you entered is invalid.");
		assertEquals("Your debit card number is invalid.|The Postal Code you entered is invalid.",
				manager.getMessage());
	}

	/**
	 * Adds messages to the message with non existing value. Should get an error.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testAddMessagesWithNonExistingValue() {
		manager.addExceptionMessage("This message doesn't exist");
	}

	/**
	 * Checks if the getMessages function is working properly.
	 */
	@Test
	public void testGetMessages() {
		manager.addExceptionMessage("Your debit card number is invalid.");
		manager.addExceptionMessage("The Postal Code you entered is invalid.");
		Collection<String> messages = ExceptionMessageManager.getMessages(manager.getMessage());
		assertFalse(messages.isEmpty());
	}

	/**
	 * Adds messages to the message with an existing key in the map and checks if the values of the
	 * messages were added as expected.
	 */
	@Test
	public void testAddMessageWithExistingKey() {
		manager.addExceptionMessageUsingCode("Invalid number");
		manager.addExceptionMessageUsingCode("Invalid SSN");
		assertEquals(
				"Your debit card number is invalid.|The Social Security Number you entered is invalid.",
				manager.getMessage());
	}

	/**
	 * Adds messages to the message with non existing value. Should get an error.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testAddMessagesWithNonExistingKey() {
		manager.addExceptionMessageUsingCode("This key doesn't exist");
	}
}
