package com.sirma.itt.javacourse.exceptions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author gdimitrov
 */
public class ObjectListTest {
	private ObjectList list;
	private static final int SIZE = 10;

	/**
	 * Setup for the tests.
	 */
	@Before
	public void setup() {
		list = new ObjectList(SIZE);
	}

	/**
	 * Test successfully adding an element to the list.
	 */
	@Test
	public void testAddElementSuccess() {
		ArrayList<Integer> integers = new ArrayList<>();
		assertTrue(list.addElement(integers));
	}

	/**
	 * This test tries to add more elements than the list can take and expects an exception.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddElementFail() {
		for (int i = 0; i <= SIZE; i++) {
			list.addElement(i);
		}
	}

	/**
	 * This test successfully removes an element.
	 */
	@Test
	public void removeSuccess() {
		boolean success = false;
		list.addElement(10);
		success = list.remove();
		assertTrue(success);

	}

	/**
	 * This test fails to remove an element, because there are no elements in the list.
	 */
	@Test(expected = EmptyListException.class)
	public void removeFail() {
		list.remove();
	}
}
