package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test the instantiate by name class.
 * 
 * @author gdimitrov
 */
public class InstantiateByNameTest {
	/**
	 * Tests the getInstanceByName method using correct data.
	 * 
	 * @throws ClassNotFoundException
	 *             {@link ClassNotFoundException}
	 */
	@Test
	public void testGetInstanceByNameWithCorrectData() throws ClassNotFoundException {
		Object instance = InstantiateByName.getInstanceByName("java.lang.String");
		assertEquals(new String(), instance);
	}

	/**
	 * Tests the getInstanceByName method using incorrect class name.
	 * 
	 * @throws ClassNotFoundException
	 *             {@link ClassNotFoundException}
	 */
	@Test(expected = ClassNotFoundException.class)
	public void testGetInstanceByNameWithIncorrectClassName() throws ClassNotFoundException {
		InstantiateByName.getInstanceByName("Wrong input");
	}
}
