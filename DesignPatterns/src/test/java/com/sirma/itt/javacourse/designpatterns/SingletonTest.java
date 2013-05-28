package com.sirma.itt.javacourse.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.designpatterns.singleton.Singleton;

/**
 * Tests the implementation of the Singleton design pattern.
 * 
 * @author gdimitrov
 */
public class SingletonTest {

	/**
	 * Tests the getInstance method by invoking it multiple times for different objects and checking
	 * if they are the same object.
	 */
	@Test
	public void testGetInstanceMultipleTimes() {
		Singleton firstInstance = Singleton.getInstance();
		Singleton secondInstance = Singleton.getInstance();
		assertEquals(firstInstance, secondInstance);
	}
}
